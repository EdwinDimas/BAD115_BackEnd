package com.bad.planilla.backend.apirest.restcontroller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.google.common.hash.Hashing;

@CrossOrigin(origins = { Constants.URL_BASE })
@RestController
@RequestMapping(Constants.BASE)
public class UserRestController {

	@Autowired
	private IUserService us;
	
	@GetMapping("/users/list")
	public List<UsersEntity> list(){
		return us.list();
	}
	
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
			String sha256hex = Hashing.sha256()
					  .hashString(usuario.getPassword(), StandardCharsets.UTF_8)
					  .toString();
			usuario.setPassword(sha256hex);
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
	
	@PutMapping("/user/{idUsuario}")
	public ResponseEntity<?> editarUsuario(@RequestBody UsersEntity usuario, @PathVariable int idUsuario) throws NoSuchAlgorithmException{
		Map<String, Object> respuesta = new HashMap<>();
		UsersEntity usuarioEditado = null,usuarioActual=null;
		usuarioActual = us.buscar(idUsuario);
		if (usuarioActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro rol con ID:" + idUsuario);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			usuarioActual.setUsername(usuario.getUsername());
			usuarioActual.setEmail(usuario.getEmail());
			if (!usuario.getPassword().isEmpty()) {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(usuario.getPassword().getBytes(StandardCharsets.UTF_8));
				usuarioActual.setPassword(new String(hash));
			}
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
	
	@PutMapping("/user/desactivar/{idUsuario}")
	public ResponseEntity<?> desactivarUsuario(@PathVariable int idUsuario){
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
		String mensaje = usuarioDesactivado.isEstado() ? "El registro ha sido ACTIVADO con exito!!" : "El registro ha sido DESACTIVADO con exito!!";
		respuesta.put("mensaje", mensaje);
		respuesta.put("usuario",usuarioDesactivado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
}
