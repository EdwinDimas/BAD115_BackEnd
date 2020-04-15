package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.services.EmpresaServiceImp;
import com.bad.planilla.backend.apirest.services.IEmpresaService;
import com.bad.planilla.backend.entity.EmpresaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/planilla/empresa")
public class EmpresaRestController {

    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/list_empresa")
    public List<EmpresaEntity> list(){
        return empresaService.list();
    }

    @GetMapping("/ver_empresa/{id}")
    public ResponseEntity<?> buscarEmpresa(@PathVariable Long id){
        EmpresaEntity empresa = null;
        Map<String, Object> respuesta = new HashMap<>();
        try {
            empresa = empresaService.findById(id);
        }catch (DataAccessException e){
                respuesta.put("mensaje","Error al realizar la busqueda del registro con ID:"+id);
                respuesta.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(empresa==null){
            respuesta.put("mensaje","El registro con ID:"+id+" no existe en la DB");
            return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EmpresaEntity>(empresa,HttpStatus.OK);
    }

    @PostMapping("/crear_empresa")
    public ResponseEntity<?> crearEmpresa(@RequestBody EmpresaEntity empresa){
        EmpresaEntity empresaCreada=null,empresaNueva=null;
        Map<String, Object> respuesta = new HashMap<>();
        try {
            empresaCreada = empresaService.save(empresa);
        }catch (DataAccessException e){
            respuesta.put("mensaje", "Error al realizar el ingreso del registro en la DB!!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El registro ha sido creado con exito!!");
        respuesta.put("empresa", empresaCreada);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/modificar_empresa/{id}")
    public ResponseEntity<?> modificarEmpresa(@RequestBody EmpresaEntity empresa,@PathVariable Long id){
        EmpresaEntity empresaModificar = null,empresaActual = empresaService.findById(id);
        Map<String, Object> respuesta = new HashMap<>();
        if(empresaActual==null){
            respuesta.put("mensaje", "Error al obtener el registro con ID:" + id);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }

        try {
            empresaActual.setRepresentante(empresa.getRepresentante());
            empresaActual.setNit(empresa.getNit());
            empresaActual.setNic(empresa.getNic());
            empresaActual.setPaginaweb(empresa.getPaginaweb());
            empresaActual.setTelefono(empresa.getTelefono());
            empresaActual.setEmail(empresa.getTelefono());
            empresaActual.setPage(empresa.getPage());
            empresaModificar = empresaService.save(empresaActual);
        }catch (DataAccessException e){
            respuesta.put("mensaje", "Error al actualizar el registro en la DB con ID:" + id + " !!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El registro ha sido actualizado con exito!!");
        respuesta.put("empresa", empresaModificar);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

}
