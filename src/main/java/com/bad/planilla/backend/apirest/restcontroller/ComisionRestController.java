package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.CatalogocomisionesEntity;

import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.IComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)

public class ComisionRestController {

    @Autowired
    private IComisionService comisionService;

    @GetMapping("/comision")
    public List<CatalogocomisionesEntity> list()
    {return comisionService.list();}

    @GetMapping("/comision/{id}")
    public ResponseEntity<?> buscarComision(@PathVariable int id){
        CatalogocomisionesEntity comision = null;
        Map<String, Object> respuesta = new HashMap<>();
        try {
            comision = comisionService.findById(id);
        }catch (DataAccessException e){
            respuesta.put("mensaje","Error al realizar la busqueda del registro con ID:"+id);
            respuesta.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (comision==null){
            respuesta.put("mensaje","El registro con ID:"+id+" no existe en la DB");
            return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CatalogocomisionesEntity>(comision,HttpStatus.OK);
    }

    @PostMapping("/comision/crear")
    public ResponseEntity<?> crearComision(@RequestBody CatalogocomisionesEntity comision){
        try {
            comision.setEstado(true);
            return new ResponseEntity<>(comisionService.guardar(comision), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/comision/editar")
    public ResponseEntity<?> modificarComision(@RequestBody CatalogocomisionesEntity comision){
        try {
            comision.setEstado(true);
            return new ResponseEntity<>(comisionService.modificar(comision), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
