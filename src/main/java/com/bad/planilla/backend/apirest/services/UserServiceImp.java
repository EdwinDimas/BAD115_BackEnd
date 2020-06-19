package com.bad.planilla.backend.apirest.services;

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
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity usuario = ur.findByUsername(username);
		if (usuario == null) {
			logger.error("Error, no existe el usuario");
		}
		cantidadFallida++;
		if (cantidadFallida == 3) {
			try {
			//MENSAJE ENVIADO A USUARIO
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(usuario.getEmail());
			helper.setSubject("ESTADO DE CUENTA");
			helper.setText("<h1>Su cuenta en sistema Planilla ha sido DESACTIVADA por tener un máximo de 3 errores en iniciar sesión</h1>", true);
			helper.setText("<h1>Se ha enviado un email al administrador para que este pueda activar su cuenta</h1>", true);
			helper.setText("<h3>Para mayor información consulte con administrador mediante este correo: rr14059@ues.edu.sv</h3>", true);
			javaMailSender.send(msg);
			
			//MENSAJE ENVIADO A ADMINISTRADOR
			MimeMessage msgAdmin = javaMailSender.createMimeMessage();
			MimeMessageHelper helperAdmin = new MimeMessageHelper(msg, true);
			helperAdmin.setTo("rr14059@ues.edu.sv");
			helperAdmin.setSubject("ESTADO DE CUENTA PETICIÓN ACTIVAR");
			helperAdmin.setText("<h1>Cuenta de usuario con Username:"+usuario.getUsername()+" y con Email:"+usuario.getEmail()+" ha exedido los 3 intentos permitidos, su cuenta se ha bloquead</h1>", true);
			helperAdmin.setText("<h1>Se solicita que su cuenta sea desbloqueada</h1>", true);
			javaMailSender.send(msgAdmin);
			
			} catch (MessagingException e) {
			    System.err.println(e.getMessage());
			}
			usuario.setEstado(false);
			ur.save(usuario);
			cantidadFallida = 0;
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
