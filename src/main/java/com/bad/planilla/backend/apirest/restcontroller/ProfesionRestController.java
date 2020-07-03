package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.ProfesionesEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.ProfesionServiceImp;
import com.bad.planilla.backend.apirest.services.PuestoTrabajoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class ProfesionRestController {

    @Autowired
    private ProfesionServiceImp profesionService;

    @GetMapping("/profesion")
    public List<ProfesionesEntity> list() {return profesionService.list();}

    @GetMapping("/profesion/{id}")
    public ProfesionesEntity getProfesion(@PathVariable int id) {return profesionService.findById(id);}

    @PostMapping("/profesion/crear")
    public ResponseEntity<?> crearProfesion(@RequestBody ProfesionesEntity profesion)
    {
        try{
            profesion.setEstado(true);
            return new ResponseEntity<>(profesionService.guardar(profesion), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/profesion/{id}")
    public ResponseEntity<?> modificarProfesion(@RequestBody ProfesionesEntity profesion)
    {
        try{
            return new ResponseEntity<>(profesionService.modificar(profesion), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

