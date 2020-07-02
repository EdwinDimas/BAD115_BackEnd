package com.bad.planilla.backend.apirest.services;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bad.planilla.backend.apirest.entity.PermisosEntity;
import com.bad.planilla.backend.apirest.entity.RolesEntity;
import com.bad.planilla.backend.apirest.entity.UsersEntity;
import com.bad.planilla.backend.apirest.repository.UserRepository;

@Service("userService")
public class UserServiceImp implements UserDetailsService,IUserService{
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private int cantidadFallida=0;
	private String usernameAnterior ="";
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	@Override
	@Transactional(readOnly=true)
	public List<UsersEntity> list() {
		
		return (List<UsersEntity>) ur.findAll();
	}

	@Override
	public UsersEntity guardar(UsersEntity user) {
		
		return ur.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public UsersEntity buscar(int id) {
		
		return ur.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public UsersEntity buscarUsername(String username) {
		
		return ur.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public UsersEntity buscarEmail(String email) {
		
		return ur.findByEmail(email);
	}

	@Override
	@Transactional(readOnly=true)
	public UsersEntity buscarUsernameEmail(String username, String email) {
		
		return ur.findByUsernameAndEmail(username, email);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity usuario = ur.findByUsername(username);
		if (usuario == null) {
			logger.error("Error, no existe el usuario");
		}
		List<String> permisos = new ArrayList<String>();
		for(RolesEntity rol:usuario.getRoles()) {
			for (PermisosEntity permiso : rol.getPermisos()) {
				permisos.add(permiso.getNombre());
			}
		}
		List<GrantedAuthority> authorities = permisos.stream()
				.map(permiso->new SimpleGrantedAuthority(permiso))
				.peek(authority->logger.info("Permiso:"+authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(username, usuario.getPassword(), usuario.isEstado(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public UsersEntity get_usuario(int idUser) {
		
		return ur.get_usuario(idUser);
	}

}
