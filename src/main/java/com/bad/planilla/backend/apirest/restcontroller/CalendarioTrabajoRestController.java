package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.CalendariostrabajosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.ICalendarioTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class CalendarioTrabajoRestController {

    @Autowired
    private ICalendarioTrabajoService calendarioTrabajoService;

    @GetMapping("/periocidad")
    public List<CalendariostrabajosEntity>list(){
        return calendarioTrabajoService.list();
    }

    //Crear
    @PostMapping("/periocidad")
    public ResponseEntity<?> crearCalendarioTrabajo(@RequestBody CalendariostrabajosEntity calendarioTrabajo){
        try{
            calendarioTrabajo.setEstado(true);
            return new ResponseEntity<>(calendarioTrabajoService.guardar(calendarioTrabajo), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    //Mostrar
    @GetMapping("/periocidad/{id}")
    public CalendariostrabajosEntity getCalendarioTrabajo(@PathVariable int id){
        return calendarioTrabajoService.findById(id);
    }
//    //Editar
    @PutMapping("/periocidad/{id}")
    public ResponseEntity<?>  modificarCalendarioTrabajo(@RequestBody CalendariostrabajosEntity calendarioTrabajo){
        try{
            calendarioTrabajo.setEstado(true);
            return new ResponseEntity<>(calendarioTrabajoService.modificar(calendarioTrabajo), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    //Desactivar
    @DeleteMapping("/periocidad/{id}")
    public ResponseEntity<?> desacactivar(@PathVariable int id){
        try {
            return new ResponseEntity<>(calendarioTrabajoService.desactivar(id),HttpStatus.ACCEPTED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/periodicidad/{anio}")
    public CalendariostrabajosEntity  obtenerCalendarioDelAnio(@PathVariable int anio){
            return calendarioTrabajoService.obtenerCalendarioDelAnio(anio);
    }
}
