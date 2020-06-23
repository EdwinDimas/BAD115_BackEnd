package com.bad.planilla.backend.apirest.restcontroller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bad.planilla.backend.apirest.entity.UsersEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.IUserService;
import com.bad.planilla.backend.apirest.services.UserServiceImp;

@CrossOrigin(origins = { Constants.URL_BASE })
@RestController
@RequestMapping(Constants.BASE)
public class UserRestController {

	@Autowired
	private IUserService us;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private Logger logger = LoggerFactory.getLogger(UserRestController.class);

	
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_READ')")
	@GetMapping("/users/list")
	public List<UsersEntity> list(){
		return us.list();
	}
	
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_READ')")
	@GetMapping("/user/{idUser}")
	public ResponseEntity<?> buscar(@PathVariable int idUser){
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuario = null;
		try {
			usuario = us.buscar(idUser);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la busqueda del registro con ID:" + idUser);
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (usuario==null) {
			respuesta.put("mensaje", "El registro con ID:" + idUser + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UsersEntity>(usuario, HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_CREATE')")
	@PostMapping("/user")
	public ResponseEntity<?> crearUsuario(@RequestBody UsersEntity usuario) throws NoSuchAlgorithmException{
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuarioCreado = null,username=null,usuarioEmail=null;
		
		username = us.buscarUsername(usuario.getUsername());
		if(username!=null) {
			respuesta.put("mensaje", "Ya existe un usuario con el username:"+usuario.getUsername());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		usuarioEmail = us.buscarEmail(usuario.getEmail());
		if(usuarioEmail!=null) {
			respuesta.put("mensaje", "Ya existe un usuario con el email:"+usuario.getEmail());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		try {
//			String sha256hex = Hashing.sha256()
//					  .hashString(usuario.getPassword(), StandardCharsets.UTF_8)
//					  .toString();
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder(12,new SecureRandom());
			usuario.setPassword(pe.encode(usuario.getPassword()));
			usuario.setEstado(true);
			usuarioCreado = us.guardar(usuario);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al insertar el nuevo registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "El registro ha sido creado con exito!!");
		respuesta.put("usuario",usuarioCreado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_UPDATE')")
	@PutMapping("/user/{idUsuario}")
	public ResponseEntity<?> editarUsuario(@RequestBody UsersEntity usuario, @PathVariable int idUsuario) throws NoSuchAlgorithmException{
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuarioEditado = null,usuarioActual=null;
		usuarioActual = us.buscar(idUsuario);
		if (usuarioActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro  con ID:" + idUsuario);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			usuarioActual.setUsername(usuario.getUsername());
			usuarioActual.setEmail(usuario.getEmail());
			if (!usuario.getPassword().isEmpty()) {
//				MessageDigest digest = MessageDigest.getInstance("SHA-256");
//				byte[] hash = digest.digest(usuario.getPassword().getBytes(StandardCharsets.UTF_8));
				BCryptPasswordEncoder pe = new BCryptPasswordEncoder(12,new SecureRandom());
				usuarioActual.setPassword(pe.encode(usuario.getPassword()));
			}
			usuarioActual.setRoles(usuario.getRoles());
			usuarioEditado = us.guardar(usuarioActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al editar el registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		respuesta.put("mensaje", "El registro ha sido editado con exito!!");
		respuesta.put("usuario",usuarioEditado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_DISABLED')")
	@PutMapping("/user/desactivar/{idUsuario}")
	public ResponseEntity<?> desactivarUsuario(@PathVariable int idUsuario) throws MessagingException{
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuarioDesactivado = null,usuarioActual=null;
		usuarioActual = us.buscar(idUsuario);
		if (usuarioActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro rol con ID:" + idUsuario);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			if (usuarioActual.isEstado()) {
				usuarioActual.setEstado(false);
			}else {
				usuarioActual.setEstado(true);
			}
			usuarioDesactivado = us.guardar(usuarioActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al desactivar el registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String mensaje = usuarioDesactivado.isEstado() ? "ACTIVADO" : "DESACTIVADO";
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(usuarioDesactivado.getEmail());
		helper.setSubject("ESTADO DE CUENTA:"+mensaje);
		helper.setText("<h1>Su cuenta en sistema Planilla ha sido "+mensaje+"</h1>", true);
		helper.setText("<h3>Para mayor información consulte con administrador mediante este correo:salvadorramos394@gmail.com</h3>", true);
		try {
			javaMailSender.send(msg);
		} catch (MailException ex) {
			// Simple Log para errores msg
			System.err.println(ex.getMessage());
		}
		
		respuesta.put("mensaje","El registro ha sido "+ mensaje+" con éxito!!");
		respuesta.put("usuario",usuarioDesactivado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	
	//BUSCAR Y ACTUALIZAR USUARIO GENERAL GET AND PUT
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_READ')")
	@GetMapping("/user/general/{idUser}")
	public ResponseEntity<?> buscarUsuario(@PathVariable int idUser){
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuario = null;
		try {
			usuario = us.get_usuario(idUser);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la busqueda del registro con ID:" + idUser);
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (usuario==null) {
			respuesta.put("mensaje", "El registro con ID:" + idUser + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UsersEntity>(usuario, HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated() and hasAuthority('USER_UPDATE')")
	@PutMapping("/user/general/{idUsuario}")
	public ResponseEntity<?> editarUsuarioGeneral(@RequestBody UsersEntity usuario, @PathVariable int idUsuario) throws NoSuchAlgorithmException{
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuarioEditado = null,usuarioActual=null;
		usuarioActual = us.buscar(idUsuario);
		if (usuarioActual == null) {
			respuesta.put("mensaje", "Error al obtener su pérfi");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			usuarioActual.setUsername(usuario.getUsername());
			usuarioActual.setEmail(usuario.getEmail());
			if (!usuario.getPassword().isEmpty()) {
				BCryptPasswordEncoder pe = new BCryptPasswordEncoder(12,new SecureRandom());
				usuarioActual.setPassword(pe.encode(usuario.getPassword()));
			}
			usuarioEditado = us.guardar(usuarioActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al editar su pérfil");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		respuesta.put("mensaje", "Su perfíl ha sido editado con éxito!!");
		respuesta.put("usuario",usuarioEditado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/bloqueado/{username}")
	public ResponseEntity<?> usuarioBloqueado(@PathVariable String username){
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuario = us.buscarUsername(username);
		if (usuario == null) {
			//respuesta.put("mensaje", "Error, usuario o password invalidos");
			logger.error("Error, no existe el usuario");
		}
		try {
			try {
				//MENSAJE ENVIADO A USUARIO
				MimeMessage msg = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				helper.setTo(usuario.getEmail());
				helper.setSubject("ESTADO DE CUENTA");
				helper.setText("<h1>Su cuenta en sistema Planilla ha sido DESACTIVADA por tener un máximo de 3 errores en iniciar sesión</h1>"
						+ "<h1>Se ha enviado un email al administrador para que este pueda activar su cuenta</h1>"
						+ "<h3>Para mayor información consulte con administrador mediante este correo: rr14059@ues.edu.sv</h3>", true);
				javaMailSender.send(msg);
				 
				//MENSAJE ENVIADO A ADMINISTRADOR
				MimeMessage msgAdmin = javaMailSender.createMimeMessage();
				MimeMessageHelper helperAdmin = new MimeMessageHelper(msgAdmin, true);
				helperAdmin.setTo("rr14059@ues.edu.sv");
				helperAdmin.setSubject("ESTADO DE CUENTA PETICIÓN ACTIVAR");
				helperAdmin.setText("<h1>Cuenta de usuario con Username:"+usuario.getUsername()+" y con Email:"+usuario.getEmail()+" ha exedido los 3 intentos permitidos, su cuenta se ha bloqueado</h1>"
						+ "<h1>Se solicita que su cuenta sea desbloqueada</h1>", true);
				javaMailSender.send(msgAdmin);
				usuario.setEstado(false);
				usuario = us.guardar(usuario);
				} catch (MessagingException e) {
				    System.err.println(e.getMessage());
				}
			
		} catch (DataAccessException e) {
			logger.error( e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
		}
		
		respuesta.put("mensaje", "Su cuenta de usuario"+usuario.getUsername()+" ha sido bloqueada, se ha enviado un mensaje a administrador y a su email:"+usuario.getEmail()+"!!");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
}
