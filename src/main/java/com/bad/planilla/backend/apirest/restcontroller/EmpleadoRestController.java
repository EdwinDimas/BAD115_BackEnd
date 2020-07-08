package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.*;
import com.bad.planilla.backend.apirest.repository.*;
import com.bad.planilla.backend.apirest.services.DireccionServiceImp;
import com.bad.planilla.backend.apirest.services.EmpleadoServiceImpl;
import com.bad.planilla.backend.apirest.services.IPuestoTrabajoService;
import com.bad.planilla.backend.apirest.services.PuestoTrabajoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.bad.planilla.backend.apirest.globals.Constants;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class EmpleadoRestController {

    @Autowired
    private EmpleadoServiceImpl es;

    @Autowired
    private DireccionServiceImp ds;

    @Autowired
    private PuestoTrabajoServiceImp pts;

    @Autowired
    private GeneroRepository gr;

    @Autowired
    private PuestoTrabajoRepository pdtr;

    @Autowired
    private EstadoCivilRepository ecr;

    @Autowired
    private MunicipioRepository mr;

    @Autowired
    private DepartamentoRepository dr;

    @Autowired
    private DireccionRepository dir;

    static class EmpleadoYDireccion {
        public EmpleadosEntity empleado;
        public DireccionesEntity direccion;
    }

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
    @PostMapping("/empleado/{id_genero}/{id_estadocivil}/{id_puestotrabajo}/{id_municipio}")
    public ResponseEntity<?> crearEmpleado(
            @RequestBody EmpleadoYDireccion empleadoYDireccion,
            @PathVariable int id_genero,
            @PathVariable int id_estadocivil,
            @PathVariable int id_puestotrabajo,
            @PathVariable int id_municipio) {
        empleadoYDireccion.empleado.setEstado(true);
        return crearActualizarEmpleado(id_genero, id_estadocivil, id_puestotrabajo, id_municipio, empleadoYDireccion.empleado, empleadoYDireccion.direccion);
    }

   @PreAuthorize("isAuthenticated() and hasAuthority('EMPLEADO_UPDATE')")
    @PutMapping("/empleado/{id_genero}/{id_estadocivil}/{id_puestotrabajo}/{id_municipio}")
    public ResponseEntity<?> modificarEmpleado(
            @RequestBody EmpleadoYDireccion empleadoYDireccion,
            @PathVariable int id_genero,
            @PathVariable int id_estadocivil,
            @PathVariable int id_puestotrabajo,
            @PathVariable int id_municipio){
        Optional<EmpleadosEntity> emp = es.findById(empleadoYDireccion.empleado.getIdEmpleado());
        DireccionesEntity direcccion_actual = emp.get().getId_direccion();
        direcccion_actual.setColonia(empleadoYDireccion.direccion.getColonia());
        direcccion_actual.setDescripcion(empleadoYDireccion.direccion.getDescripcion());


        return crearActualizarEmpleado(id_genero, id_estadocivil, id_puestotrabajo, id_municipio, empleadoYDireccion.empleado, direcccion_actual);
    }

    private ResponseEntity<?> crearActualizarEmpleado(int id_genero, int id_estadocivil, int id_puestotrabajo, int id_municipio, EmpleadosEntity empleado, DireccionesEntity direccion){
        try {
            GenerosEntity genero = gr.findByIdGenero(id_genero);
            EstadoscivilesEntity estado = ecr.findByIdEstadocivil(id_estadocivil);
            PuestosTrabajosEntity puesto = pts.findById(id_puestotrabajo);
            if(genero != null) empleado.setId_genero(genero);
            if(estado != null) empleado.setId_estadocivil(estado);
            if(puesto != null) empleado.setId_puestotrabajo(puesto);
            empleado.setTomarVacaciones(false);

            empleado.setSalario( puesto.getId_salario().getDesde());
            direccion.setEstado(true);
            direccion.setId_municipio(mr.findByIdMunicipio(id_municipio));
            direccion.setId_departmento(direccion.getId_municipio().getId_departmento());
            ds.guardar(direccion);
            empleado.setId_direccion(direccion);

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
