package com.bad.planilla.backend.apirest.restcontroller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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

//	@GetMapping("/unidad_organizacional/list/{id}")
//	public List<UnidadesorganizacionalesEntity> listUnidades(@PathVariable int id){	
//		return (id==-1)?uos.listUnidadMayor(true):uos.listUnidadesSuperiores(id);
//	}

	@GetMapping("/unidad_organizacional/list/{id}")
	public ResponseEntity<?> listUnidades(@PathVariable int id) {
		Map<String, Object> respuesta = new HashMap<>();
		List<UnidadesorganizacionalesEntity> unidades = null;
		unidades = (id == -1) ? uos.listUnidadMayor(true) : uos.listUnidadesSuperiores(id);
		System.out.println("unidades:"+unidades);
		if (unidades.isEmpty()) {
			respuesta.put("mensaje", "La unidad padre con ID:" + id + " no existe en la DB");
		}
		BigDecimal presupuestoTotal = null, presupuestoAsignado = null, presupuestoDisponible = null;

		// AQUI COMIENZA IF DE -1
		if (id != -1) {
			CentrocostosEntity costoPadre = cs.costoByUnidadAndPeriodo(id, LocalDate.now().getYear());
			if (costoPadre==null) {
				respuesta.put("mensaje", "El costo padre con ID:" + id + " no existe en la DB");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}	
			presupuestoTotal = costoPadre.getMonto();
			presupuestoDisponible = costoPadre.getMontoactual();
			presupuestoAsignado = (presupuestoTotal.subtract(presupuestoDisponible));
		}
		// AQUI TERMINA IF DE -1

		respuesta.put("unidades", unidades);
		respuesta.put("unidadPadre", id);
		respuesta.put("presupuestoTotal", presupuestoTotal);
		respuesta.put("presupuestoDisponible", presupuestoDisponible);
		respuesta.put("presupuestoAsignado", presupuestoAsignado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

	@GetMapping("/centro_costo/list/{id}")
	public List<CentrocostosEntity> listCostos(@PathVariable int id) {
		int año = LocalDate.now().getYear();
		return (id == -1) ? cs.costosUnidadMayor(año) : cs.costosHijos(id, año);
	}

//	@GetMapping("/centro_costo/list/{id}")
//	public ResponseEntity<?> listCostos(@PathVariable int id){
//		Map<String, Object> respuesta = new HashMap<>();
//		List<CentrocostosEntity> costos = null;
//		costos = (id==-1) ? cs.costosUnidadMayor():cs.costosHijos(id);
//		respuesta.put("costos",costos);
//		return new ResponseEntity<List<CentrocostosEntity>>(costos, HttpStatus.OK);
//	}

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
	public ResponseEntity<?> crearCosto(@RequestBody CentrocostosEntity costo, @PathVariable int idUnidad) {
		CentrocostosEntity costoCreado = null, costoPadre = null, costoExiste = null;
		Map<String, Object> respuesta = new HashMap<>();
		int año = LocalDate.now().getYear();
		UnidadesorganizacionalesEntity unidad = uos.findById(idUnidad);
		if (unidad == null) {
			respuesta.put("mensaje", "La unidad con ID:" + idUnidad + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}

		costoExiste = cs.costoByUnidadAndPeriodo(idUnidad, año);
		if (costoExiste != null) {
			respuesta.put("mensaje",
					"El presupuesto asignado a unidad con ID:" + idUnidad + ", ya existe para el periodo actual!!");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		int unidadPadre = (unidad.isUnidadmayor()) ? 0 : unidad.getUnidadOrganizacionalSuperior();
		try {
			if (!unidad.isUnidadmayor()) {
				costoPadre = cs.costoByUnidadAndPeriodo(unidad.getUnidadOrganizacionalSuperior(), año);
				if (costoPadre.getMontoactual().compareTo(costo.getMonto()) == -1) {
					respuesta.put("mensaje", "El presupuesto asignado es mayor que el presupuesto disponible!!");
					return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
				}
				costoPadre.setMontoactual(costoPadre.getMontoactual().subtract(costo.getMonto()));
				costoPadre = cs.guardar(costoPadre);
			}
			costo.setMontoactual(costo.getMonto());
			costo.setEstado(true);
			costo.setPeriodo(año);
			costo.setId_unidadorganizacional(unidad);
			costo.setIdUnidadPadre(unidadPadre);
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
	public ResponseEntity<?> editarCosto(@RequestBody CentrocostosEntity costo, @PathVariable int idUnidad,
			@PathVariable int idCosto) {
		CentrocostosEntity costoEditado = null, costoActual = null, costoPadre = null;
		Map<String, Object> respuesta = new HashMap<>();
		int año = LocalDate.now().getYear();
		costoActual = cs.findById(idCosto);
		if (costoActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro costo con ID:" + idCosto);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}

		UnidadesorganizacionalesEntity unidad = uos.findById(idUnidad);
		if (unidad == null) {
			respuesta.put("mensaje", "La unidad con ID:" + idUnidad + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}

		int unidadPadre = (unidad.isUnidadmayor()) ? 0 : unidad.getUnidadOrganizacionalSuperior();

		try {

			if (costoActual.getIdUnidadPadre() != 0) {
				costoPadre = cs.costoByUnidadAndPeriodo(costoActual.getIdUnidadPadre(), año);

				costoPadre.setMontoactual(costoPadre.getMontoactual().add(costoActual.getMonto()));
				costoPadre = cs.guardar(costoPadre);
				
				if (costoPadre.getMontoactual().compareTo(costo.getMonto()) == -1) {
					respuesta.put("mensaje", "El presupuesto asignado es mayor que el presupuesto disponible!!");
					return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
				}
				costoPadre.setMontoactual(costoPadre.getMontoactual().subtract(costo.getMonto()));
				costoPadre = cs.guardar(costoPadre);
			}

			costoActual.setMonto(costo.getMonto());
			costoActual.setMontoactual(costo.getMonto());
			costoActual.setId_unidadorganizacional(unidad);
			costoActual.setIdUnidadPadre(unidadPadre);
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
	public ResponseEntity<?> desactivarCosto(@PathVariable int idCosto) {
		Map<String, Object> respuesta = new HashMap<>();
		CentrocostosEntity costoEditado = null, costoActual = null, costoPadre = null;
		List<CentrocostosEntity> costoHijo = null;
		costoActual = cs.findById(idCosto);
		int año = LocalDate.now().getYear();
		if (costoActual == null) {
			respuesta.put("mensaje", "Error al obtener el registro empresa con ID:" + idCosto);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		costoHijo = cs.costosHijos(costoActual.getId_unidadorganizacional().getIdUnidadorganizacional(), año);
		if (!costoHijo.isEmpty()) {
			respuesta.put("mensaje",
					"El costo con registro con ID:" + idCosto + " tiene costos hijos, no se puede eliminar");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		try {
			if (costoActual.getIdUnidadPadre() != 0) {
				costoPadre = cs.costoByUnidadAndPeriodo(costoActual.getIdUnidadPadre(), año);
				costoPadre.setMontoactual(costoPadre.getMontoactual().add(costoActual.getMonto()));
				costoPadre = cs.guardar(costoPadre);
			}

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

	//SE ASUME POR EL MOMENTO QUE AL MOMENTO DE IMPRIMIR LA BOLETA SE DESCONTARA EL MONTO CORRESPONDIENTE DEL PRESUPUESTO
	//SE DEBE PASARA COO PARAMETRO EL SALARIO BASE + INGRESOS DEL EMPLEADO
	@PutMapping("/centro_costo/descontar/{idCosto}")
	public ResponseEntity<?> descontarCosto(@PathVariable int idUnidad,float salario) {
		Map<String, Object> respuesta = new HashMap<>();
		CentrocostosEntity costoUnidad = cs.costoByUnidadAndPeriodo(idUnidad, LocalDate.now().getYear()); 
		if (costoUnidad == null) {
			respuesta.put("mensaje", "La unidad con ID:" + idUnidad + " no existe en la DB");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		BigDecimal bDecimalSalario = new BigDecimal(Float.toString(salario));
		//DESCUENTO A LA UNIDAD CORRESPONDIENTE
		try {
			if (costoUnidad.getMontoactual().compareTo(bDecimalSalario) == -1) {
				respuesta.put("mensaje", "El salario ha descontar es mayor que el presupuesto disponible en la unidad organizacional!!");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
			}else {
				costoUnidad.setMontoactual(costoUnidad.getMontoactual().subtract(bDecimalSalario));
				costoUnidad = cs.guardar(costoUnidad);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al descontar el salario!!");
			respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El salario ha sido descontado de la unidad organizacional con exito!!");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

}