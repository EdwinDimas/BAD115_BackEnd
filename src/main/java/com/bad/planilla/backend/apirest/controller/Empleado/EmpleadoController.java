package com.bad.planilla.backend.apirest.controller.Empleado;

import com.bad.planilla.backend.entity.EmpleadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService es;


    @GetMapping("/api/empleado/")
    public List show(){
        return es.findAll();
    }

}
