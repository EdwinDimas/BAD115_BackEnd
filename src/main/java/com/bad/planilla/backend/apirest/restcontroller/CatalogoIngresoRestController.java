package com.bad.planilla.backend.apirest.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bad.planilla.backend.apirest.entity.CatalogoingresosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.ICatalogoIngresoService;

@CrossOrigin(origins = { Constants.URL_BASE })
@RestController
@RequestMapping(Constants.BASE)
public class CatalogoIngresoRestController {
	
	@Autowired
	private ICatalogoIngresoService cs;
	
	@PreAuthorize("isAuthenticated() and hasAuthority('INGRESO_READ')")
	@GetMapping("/ingreso/list/activos")
	public List<CatalogoingresosEntity> listActivos(){
		
		return cs.listTrue();
	}
	
	@PreAuthorize("isAuthenticated() and hasAuthority('INGRESO_READ')")
	@GetMapping("/ingreso/list/all")
	public List<CatalogoingresosEntity> listAll(){
		return cs.list();
	}
  
	@PreAuthorize("isAuthenticated() and hasAuthority('INGRESO_READ')")
	@GetMapping("/ingreso/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id){
		Map<String, Object> respuesta = new HashMap<>();
		CatalogoingresosEntity ingreso = null;
		
		try {
			ingreso = cs.buscar(id);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la busqueda del registro con ID:" + id);
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(ingreso == null) {
			respuesta.put("mensaje", "El registro con ID:" + id + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CatalogoingresosEntity>(ingreso, HttpStatus.OK);
	}
  
	@PreAuthorize("isAuthenticated() and hasAuthority('INGRESO_CREATE')")
	@PostMapping("/ingreso")
	public ResponseEntity<?> crearIngreso(@RequestBody CatalogoingresosEntity ingreso){
		Map<String, Object> respuesta = new HashMap<>();
		CatalogoingresosEntity ingresoCreado =null;
		try {
			ingresoCreado=cs.guardar(ingreso);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al insertar el nuevo registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El registro ha sido creado con exito!!");
		respuesta.put("ingreso",ingresoCreado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PreAuthorize("isAuthenticated() and hasAuthority('INGRESO_UPDATE')")
	@PutMapping("/ingreso/{id}")
	public ResponseEntity<?> editarIngreso(@RequestBody CatalogoingresosEntity ingreso,@PathVariable int id){
		Map<String, Object> respuesta = new HashMap<>();
		CatalogoingresosEntity ingresoActual=null,ingresoEditado = null;
		ingresoActual = cs.buscar(id);
		if (ingresoActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro  con ID:" + id);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			ingresoActual.setAcronimoIngresos(ingreso.getAcronimoIngresos());
			ingresoActual.setNombre(ingreso.getNombre());
			ingresoActual.setPorcentaje_ingreso(ingreso.getPorcentaje_ingreso());
			ingresoEditado = cs.guardar(ingresoActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al editar el registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		respuesta.put("mensaje", "El registro ha sido editado con exito!!");
		respuesta.put("ingreso",ingresoEditado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PreAuthorize("isAuthenticated() and hasAuthority('INGRESO_DISABLED')")
	@GetMapping("/ingreso/desactivar/{id}")
	public ResponseEntity<?> desactivarRol(@PathVariable int id){
		CatalogoingresosEntity ingresoActual=null,ingresoDesactivado=null;
		Map<String, Object> respuesta = new HashMap<>();
		ingresoActual = cs.buscar(id);
		if (ingresoActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro rol con ID:" + id);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			if (ingresoActual.isEstado()) {
				ingresoActual.setEstado(false);
			}else {
				ingresoActual.setEstado(true);
			}
			ingresoDesactivado = cs.guardar(ingresoActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al actualizar el registro");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String mensaje = ingresoDesactivado.isEstado() ? "El registro ha sido ACTIVADO con exito!!" : "El registro ha sido DESACTIVADO con exito!!";
		respuesta.put("mensaje",mensaje );
		respuesta.put("ingreso",ingresoDesactivado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
	
	
	

}
