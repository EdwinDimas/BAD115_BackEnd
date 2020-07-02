package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.IEmpresaService;
import com.bad.planilla.backend.apirest.services.IUnidadOrganizacionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class UnidadOrganizacionalRestController {

    @Autowired
    private IUnidadOrganizacionalService unidadOrganizacionalService;
    @Autowired
    private IEmpresaService empresaService;

    //Mostrar lista
    @PreAuthorize("isAuthenticated() and hasAuthority('UNIDAD_ORGANIZACIONAL_READ')")
    @GetMapping("/departamentos")
    public List<UnidadesorganizacionalesEntity>list(){
        return unidadOrganizacionalService.list();
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('UNIDAD_ORGANIZACIONAL_CREATE')")
    @PostMapping("/departamentos")
    public ResponseEntity<?> crearUnidadorganizacional(@RequestBody UnidadesorganizacionalesEntity  unidadOrganizacional){

        try {
            unidadOrganizacional.setEstado(true);
            return new ResponseEntity<>(unidadOrganizacionalService.guardar(unidadOrganizacional), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mostrar
    @PreAuthorize("isAuthenticated() and hasAuthority('UNIDAD_ORGANIZACIONAL_READ')")
    @GetMapping("/departamentos/{id}")
    public UnidadesorganizacionalesEntity getUnidadorganizacional(@PathVariable int id){
        return unidadOrganizacionalService.findById(id);
    }
    //Editar
    @PreAuthorize("isAuthenticated() and hasAuthority('UNIDAD_ORGANIZACIONAL_UPDATE')")
    @PutMapping("/departamentos/{id}")
    public ResponseEntity<?> modificarUnidadorganizacional(@RequestBody UnidadesorganizacionalesEntity unidadOrganizacional){
        try {
            unidadOrganizacional.setEstado(true);
            return new ResponseEntity<>(unidadOrganizacionalService.modificar(unidadOrganizacional), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Desactivar
    @PreAuthorize("isAuthenticated() and hasAuthority('UNIDAD_ORGANIZACIONAL_DISABLED')")
    @DeleteMapping("/departamentos/{id}")
    public ResponseEntity<?> desactivar(@PathVariable int id){
        try {
            return new ResponseEntity<>( unidadOrganizacionalService.desactivar(id), HttpStatus.ACCEPTED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(e.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
