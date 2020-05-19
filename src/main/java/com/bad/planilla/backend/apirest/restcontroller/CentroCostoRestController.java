package com.bad.planilla.backend.apirest.restcontroller;

import java.util.Calendar;
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

import com.bad.planilla.backend.apirest.entity.CentrocostosEntity;
import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.ICentroCostoService;
import com.bad.planilla.backend.apirest.services.IUnidadOrganizacionalService;

@CrossOrigin(origins = { Constants.URL_BASE })
@RestController
@RequestMapping(Constants.BASE)
public class CentroCostoRestController {

	@Autowired
	private ICentroCostoService cs;
	
	@Autowired
	private IUnidadOrganizacionalService uos;
	

	@GetMapping("/unidad_organizacional/list/{id}")
	public List<UnidadesorganizacionalesEntity> listUnidades(@PathVariable int id){	
		return (id==-1)?uos.listUnidadMayor(true):uos.listUnidadesSuperiores(id);
	}
	
	@GetMapping("/centro_costo/list/{id}")
	public List<CentrocostosEntity> listCostos(@PathVariable int id) {
		return (id == -1) ? cs.costosUnidadMayor():cs.costosHijos(id);
	}

	@GetMapping("/centro_costo/{idCosto}")
	public ResponseEntity<?> buscarCosto(@PathVariable int idCosto) {
		Map<String, Object> respuesta = new HashMap<>();
		CentrocostosEntity costo = null;
		try {
			costo = cs.findById(idCosto);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la busqueda del registro con ID:" + idCosto);
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (costo == null) {
			respuesta.put("mensaje", "El registro con ID:" + idCosto + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CentrocostosEntity>(costo, HttpStatus.OK);

	}
	
	@PostMapping("/centro_costo/{idUnidad}")
	public ResponseEntity<?> crearCosto(@RequestBody CentrocostosEntity costo,@PathVariable int idUnidad){
		CentrocostosEntity costoCreado = null;
		Map<String, Object> respuesta = new HashMap<>();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		try {
			costo.setEstado(true);
			costo.setMontoactual(costo.getMonto());
			costo.setPeriodo(date);
			costoCreado = cs.guardar(costo);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el ingreso del registro en la DB!!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "El registro ha sido creado con exito!!");
        respuesta.put("costo", costoCreado);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	} 
	
	@PutMapping("/centro_costo/{idUnidad}/{idCosto}")
	public ResponseEntity<?> editarCosto(@RequestBody CentrocostosEntity costo, @PathVariable int idUnidad, @PathVariable int idCosto){
		CentrocostosEntity costoEditado = null,costoActual=null;
		Map<String, Object> respuesta = new HashMap<>();
		costoActual = cs.findById(idCosto);
		if (costoActual==null) {
			respuesta.put("mensaje", "Error al obtener el registro empresa con ID:" + idCosto);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		try {
			costoActual.setMonto(costo.getMonto());
			costoActual.setMontoactual(costo.getMonto());
			costoEditado = cs.guardar(costoActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al actualizar el registro en la DB con ID:" + idCosto + " !!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 respuesta.put("mensaje", "El registro ha sido actualizado con exito!!");
	     respuesta.put("costo", costoEditado);
	     return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@PutMapping("/centro_costo/desactivar/{idCosto}")
	public ResponseEntity<?> desactivarCosto(@PathVariable int idCosto){
		Map<String, Object> respuesta = new HashMap<>();
		CentrocostosEntity costoEditado = null,costoActual=null;
		List<CentrocostosEntity> costoHijo=null;
		costoActual = cs.findById(idCosto);
		
		if (costoActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro empresa con ID:" + idCosto);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		
		costoHijo = cs.costosHijos(costoActual.getId_unidadorganizacional().getIdUnidadorganizacional());
		if (costoHijo != null ) {
			respuesta.put("mensaje", "El costo con registro con ID:" + idCosto+" tiene costos hijos, no se puede eliminar");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		try {
			costoActual.setEstado(false);
			costoEditado = cs.guardar(costoActual);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al desactivar el registro en la DB con ID:" + idCosto + " !!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "El registro ha sido desactivado con exito!!");
	     respuesta.put("costo", costoEditado);
	     return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/centro_costo/descontar/{idCosto}")
	public ResponseEntity<?> descontarCosto(@PathVariable int idCosto){
		Map<String, Object> respuesta = new HashMap<>();
		
		return null;
	}
	
	
	
	
	
	
	

}
