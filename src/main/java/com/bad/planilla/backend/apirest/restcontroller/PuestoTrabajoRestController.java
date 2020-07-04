package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;
import com.bad.planilla.backend.apirest.entity.SalariosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.PuestoTrabajoServiceImp;
import com.bad.planilla.backend.apirest.services.SalarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class PuestoTrabajoRestController {

    @Autowired
    private PuestoTrabajoServiceImp puestoTrabajoService;
    @Autowired
    private SalarioServiceImp salarioServiceImp;

    @PreAuthorize("isAuthenticated() and hasAuthority('PUESTO_TRABAJO_READ')")
    @GetMapping(value = "/puestotrabajo")
    public List<PuestosTrabajosEntity> list() {
        return puestoTrabajoService.list();
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('PUESTO_TRABAJO_CREATE')")
    @PostMapping("/puestotrabajo")
    public ResponseEntity<?> crearPuestoTrabajo(@RequestBody PuestosTrabajosEntity puestoTrabajo){
        try {
            puestoTrabajo.setEstado(true);
            return new ResponseEntity<>(puestoTrabajoService.guardar(puestoTrabajo), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('PUESTO_TRABAJO_READ')")
    @GetMapping("/puestotrabajo/{id}")
    public PuestosTrabajosEntity getPuestoTrabajo(@PathVariable int id){
        return puestoTrabajoService.findById(id);
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('PUESTO_TRABAJO_UPDATE')")
    @PutMapping("/puestotrabajo/{id}")
    public ResponseEntity<?> modificarPuestoTrabajo(@RequestBody PuestosTrabajosEntity puestoTrabajo){
        try {
            puestoTrabajo.setEstado(true);
            return new ResponseEntity<>(puestoTrabajoService.modificar(puestoTrabajo), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('PUESTO_TRABAJO_DISABLED')")
    @DeleteMapping("/puestotrabajo/{id}")
    public ResponseEntity<?> desactivar(@PathVariable int id){
        try {
            return new ResponseEntity<>( puestoTrabajoService.desactivar(id), HttpStatus.ACCEPTED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
