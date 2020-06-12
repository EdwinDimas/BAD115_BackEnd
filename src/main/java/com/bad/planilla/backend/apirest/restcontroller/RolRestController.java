package com.bad.planilla.backend.apirest.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.bad.planilla.backend.apirest.entity.PermisosEntity;
import com.bad.planilla.backend.apirest.entity.RolesEntity;
import com.bad.planilla.backend.apirest.entity.UsersEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.IPermisoService;
import com.bad.planilla.backend.apirest.services.IRolService;
import com.bad.planilla.backend.apirest.services.IUserService;

@CrossOrigin(origins = { Constants.URL_BASE })
@RestController
@RequestMapping(Constants.BASE)
public class RolRestController {
	
	@Autowired
	private IRolService rs;
	
	@Autowired
	private IPermisoService ps;
	
	@Autowired
	private IUserService us;
	
	@GetMapping("/permisos/list")
	public List<PermisosEntity> listPermisos(){
		return ps.list();
	}
	//PARA SERVICE DE USER EN FRONTEND
	@GetMapping("/rol/list/user")
	public List<RolesEntity> listTrue(){
		return rs.listEstadoTrue();
	}
	
	@GetMapping("/rol/list")
	public List<RolesEntity> list(){
		return rs.list();
	}
	
	@GetMapping("/rol/{idRol}")
	public ResponseEntity<?> buscarRol(@PathVariable int idRol){
		Map<String, Object> respuesta = new HashMap<>();
		RolesEntity rol= null;
		try {
			rol = rs.buscar(idRol);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la busqueda del registro con ID:" + idRol);
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(rol == null) {
			respuesta.put("mensaje", "El registro con ID:" + idRol + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<RolesEntity>(rol, HttpStatus.OK);
	}
	
	@PostMapping("/rol")
	public ResponseEntity<?> crearRol(@RequestBody RolesEntity rol){
		RolesEntity rolcreado = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			rolcreado = rs.guardar(rol);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al insertar el nuevo registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El registro ha sido creado con exito!!");
		respuesta.put("rol",rolcreado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@PutMapping("/rol/{idRol}")
	public ResponseEntity<?> editarRol(@RequestBody RolesEntity rol,@PathVariable int idRol){
		RolesEntity rolEditado = null,rolActual=null;
		Map<String, Object> respuesta = new HashMap<>();
		rolActual = rs.buscar(idRol);
		if (rolActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro rol con ID:" + idRol);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			rolActual.setNombre(rol.getNombre());
			rolActual.setDetalle(rol.getDetalle());
			rolActual.setPermisos(rol.getPermisos());
			rolEditado = rs.guardar(rolActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al editar el registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "El registro ha sido editado con exito!!");
		respuesta.put("rol",rolEditado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@PutMapping("/rol/desactivar/{idRol}")
	public ResponseEntity<?> desactivarRol(@PathVariable int idRol){
		RolesEntity rolActual=null,rolDesactivado=null;
		Map<String, Object> respuesta = new HashMap<>();
		rolActual = rs.buscar(idRol);
		if (rolActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro rol con ID:" + idRol);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		List<UsersEntity> usuarios = us.list();
		for (UsersEntity usuario : usuarios) {
			if (usuario.getRoles().contains(rolActual)) {
				respuesta.put("mensaje", "Error al desactivar el registro rol con ID:" + idRol+", este se encuentra en uso por uno o varios usuarios");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_ACCEPTABLE);
			}
		}
		try {
			if (rolActual.isEstado()) {
				rolActual.setEstado(false);
			}else {
				rolActual.setEstado(true);
			}
			rolDesactivado = rs.guardar(rolActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al actualizar el registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String mensaje = rolDesactivado.isEstado() ? "El registro ha sido ACTIVADO con exito!!" : "El registro ha sido DESACTIVADO con exito!!";
		respuesta.put("mensaje",mensaje );
		respuesta.put("rol",rolDesactivado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	
	
	
	

}
