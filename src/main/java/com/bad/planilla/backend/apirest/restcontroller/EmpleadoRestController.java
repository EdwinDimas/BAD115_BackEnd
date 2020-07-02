package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.EstadoscivilesEntity;
import com.bad.planilla.backend.apirest.entity.GenerosEntity;
import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;
import com.bad.planilla.backend.apirest.repository.EmpleadoRepository;
import com.bad.planilla.backend.apirest.repository.EstadoCivilRepository;
import com.bad.planilla.backend.apirest.repository.GeneroRepository;
import com.bad.planilla.backend.apirest.repository.PuestoTrabajoRepository;
import com.bad.planilla.backend.apirest.services.EmpleadoServiceImpl;
import com.bad.planilla.backend.apirest.entity.EmpleadosEntity;
import com.bad.planilla.backend.apirest.services.IPuestoTrabajoService;
import com.bad.planilla.backend.apirest.services.PuestoTrabajoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.bad.planilla.backend.apirest.globals.Constants;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class EmpleadoRestController {

    @Autowired
    private EmpleadoServiceImpl es;

    @Autowired
    private PuestoTrabajoServiceImp pts;

    @Autowired
    private GeneroRepository gr;

    @Autowired
    private PuestoTrabajoRepository pdtr;

    @Autowired
    private EstadoCivilRepository ecr;

    @PreAuthorize("isAuthenticated() and hasAuthority('EMPLEADO_READ')")
    @GetMapping("/empleado")
    public List List(){
        return es.list();
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('EMPLEADO_READ')")
    @GetMapping("/empleado/{id}")
    public Optional<EmpleadosEntity> getEmpleadp(@PathVariable int id){
        return es.findById(id);
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('EMPLEADO_CREATE')")
    @PostMapping("/empleado/{id_genero}/{id_estadocivil}/{id_puestotrabajo}")
    public ResponseEntity<?> crearEmpleado(
            @RequestBody EmpleadosEntity empleado,
            @PathVariable int id_genero,
            @PathVariable int id_estadocivil,
            @PathVariable int id_puestotrabajo) {
        empleado.setEstado(true);
        return crearActualizarEmpleado(id_genero, id_estadocivil, id_puestotrabajo, empleado);
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('EMPLEADO_UPDATE')")
    @PutMapping("/empleado/{id_genero}/{id_estadocivil}/{id_puestotrabajo}")
    public ResponseEntity<?> modificarEmpleado(
            @RequestBody EmpleadosEntity empleado,
            @PathVariable int id_genero,
            @PathVariable int id_estadocivil,
            @PathVariable int id_puestotrabajo){
        return crearActualizarEmpleado(id_genero, id_estadocivil, id_puestotrabajo, empleado);
    }

    private ResponseEntity<?> crearActualizarEmpleado(int id_genero, int id_estadocivil, int id_puestotrabajo, EmpleadosEntity empleado){
        try {
            GenerosEntity genero = gr.findByIdGenero(id_genero);
            EstadoscivilesEntity estado = ecr.findByIdEstadocivil(id_estadocivil);
            PuestosTrabajosEntity puesto = pts.findById(id_puestotrabajo);
            if(genero != null) empleado.setId_genero(genero);
            if(estado != null) empleado.setId_estadocivil(estado);
            if(puesto != null) empleado.setId_puestotrabajo(puesto);
            return new ResponseEntity<>(es.save(empleado), HttpStatus.CREATED);
        }catch (DataAccessException | NullPointerException e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('ESTADO_CIVIL_READ')")
    @GetMapping("/estadocivil")
    public List listarEstadosCiviles(){return ecr.findAll(); }

    @PreAuthorize("isAuthenticated() and hasAuthority('GENERO_READ')")
    @GetMapping("/genero")
    public List listarGeneros(){return gr.findAll();}

    @PreAuthorize("isAuthenticated() and hasAuthority('PUESTO_TRABAJO_READ')")
    @GetMapping("/puestostrabajo")
    public List listarPuestosDeTrabajo(){return pdtr.findAllByOrderByNombre(); }



}
