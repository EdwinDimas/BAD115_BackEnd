package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.DescuentosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.DescuentoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constants.URL_BASE)
@RestController
@RequestMapping(Constants.BASE)
public class DescuentoRestController {

    @Autowired
    private DescuentoServiceImp descuentoService;

    @PreAuthorize("isAuthenticated() and hasAuthority('DESCUENTO_READ')")
    @GetMapping("/descuento")
    public List<DescuentosEntity> list() {
        return descuentoService.list();
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('DESCUENTO_CREATE')")
    @PostMapping("/descuento")
    public ResponseEntity<?> crearDescuento(@RequestBody DescuentosEntity descuento){
      try {
          descuento.setEstado(true);
          return new ResponseEntity<>(descuentoService.guardar(descuento), HttpStatus.CREATED);
      } catch (DataAccessException e){
          return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
    };

    @PreAuthorize("isAuthenticated() and hasAuthority('DESCUENTO_READ')")
    @GetMapping("/descuento/{id}")
    public DescuentosEntity getDescuento(@PathVariable int id){
      return descuentoService.findById(id);
    };

    @PreAuthorize("isAuthenticated() and hasAuthority('DESCUENTO_UPDATE')")
    @PutMapping("/descuento/{id}")
    public ResponseEntity<?> modificarDescuento(@RequestBody DescuentosEntity descuento){
        try {
            descuento.setEstado(true);
            return new ResponseEntity<>(descuentoService.guardar(descuento), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @PreAuthorize("isAuthenticated() and hasAuthority('DESCUENTO_DISABLED')")
    @DeleteMapping("/descuento/{id}")
    public ResponseEntity<?> desactivar(@PathVariable int id){
        try {
            return new ResponseEntity<>( descuentoService.desactivar(id), HttpStatus.ACCEPTED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
