package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmpleadoRestController {

    //@Autowired
    private EmpleadoService es;

    @GetMapping("/api/empleado/")
    public List show(){
        System.out.println("Entrando a metodo");

        System.out.println(es.findAll());
        return es.findAll();
    }

}
