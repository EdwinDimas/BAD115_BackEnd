package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.repository.EmpleadoRepository;
import com.bad.planilla.backend.apirest.services.EmpleadoServiceImpl;
import com.bad.planilla.backend.entity.EmpleadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bad.planilla.backend.apirest.globals.Constants;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE)
public class EmpleadoRestController {

    @Autowired
    private EmpleadoServiceImpl es;

    @GetMapping("/empleado")
    public List List(){
        return es.list();
    }

    @GetMapping("/empleado/{id}")
    public Optional<EmpleadoEntity> getEmpleadp(@PathVariable int id){
        return es.findById(id);
    }

    @PostMapping("/empleado")
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoEntity empleado){
        try {
            return new ResponseEntity<>(es.save(empleado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empleado")
    public ResponseEntity<?> modificarEmpleado(@RequestBody EmpleadoEntity empleado){
        if(empleado != null){
            return new ResponseEntity<>(es.save(empleado), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
