package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.EmpleadosDescuentosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.EmpleadoDescuentoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = Constants.URL_BASE)
@RestController
@RequestMapping(Constants.BASE)
public class EmpleadoDescuentoRestController {
    @Autowired
    private EmpleadoDescuentoImp empleadoDescuentoImp;

    @PreAuthorize("isAuthenticated() and hasAuthority('EMPLEADO_DESCUENTO_CREATE')")
    @PostMapping("/empleadosdescuento")
    public ResponseEntity<?> crearActualizarEmpleadoDescuento(@RequestBody EmpleadosDescuentosEntity empleadoDescuentos){
        try{
            return new ResponseEntity<>(empleadoDescuentoImp.guardar(empleadoDescuentos), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };
}
