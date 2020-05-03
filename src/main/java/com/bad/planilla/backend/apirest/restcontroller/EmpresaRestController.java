package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import com.bad.planilla.backend.apirest.entity.DireccionesEntity;
import com.bad.planilla.backend.apirest.entity.EmpresasEntity;
import com.bad.planilla.backend.apirest.entity.MunicipiosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.globals.DepartamentoMunicipioModel;
import com.bad.planilla.backend.apirest.models.EmpresaModel;
import com.bad.planilla.backend.apirest.services.IDepartamentoService;
import com.bad.planilla.backend.apirest.services.IDireccionService;
import com.bad.planilla.backend.apirest.services.IEmpresaService;
import com.bad.planilla.backend.apirest.services.IMunicipioService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = { Constants.URL_BASE})
@RestController
@RequestMapping(Constants.BASE)
public class EmpresaRestController {

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IDepartamentoService departamentoService;

    @Autowired
    private IMunicipioService municipioService;

    @Autowired
    private IDireccionService direccionService;

    @GetMapping("/empresa")
    public List<EmpresasEntity> list(){
        return empresaService.list();
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<?> buscarEmpresa(@PathVariable int id){
        EmpresasEntity empresa = null;
        Map<String, Object> respuesta = new HashMap<>();
        System.out.println("ID---:"+id);
        try {
            System.out.println("ENTRO A TRY=========================");
            empresa = empresaService.findById(id);
            System.out.println(empresa);
        }catch (DataAccessException e){
                respuesta.put("mensaje","Error al realizar la busqueda del registro con ID:"+id);
                respuesta.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(empresa==null){
            respuesta.put("mensaje","El registro con ID:"+id+" no existe en la DB");
            return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EmpresasEntity>(empresa,HttpStatus.OK);
    }

    @PostMapping("/empresa")
    public ResponseEntity<?> crearEmpresa(@RequestBody EmpresaModel empresa){
        int empresaCreada=0;
        EmpresasEntity empresaNueva = new EmpresasEntity();
        DireccionesEntity direccionNueva = new DireccionesEntity();
        DepartmentosEntity departmentoEntity = null;
        MunicipiosEntity municipioEntity = null;
        int direccionCreada = 0;
        Map<String, Object> respuesta = new HashMap<>();
        try {
//            departmentoEntity = departamentoService.findById(empresa.getDepartamento());
//            municipioEntity = municipioService.findById(empresa.getMunicipio());
            direccionNueva.setColonia(empresa.getColonia());
            direccionNueva.setDescripcion(empresa.getDescripcion());
            //direccionNueva.setEstado(true);
            direccionCreada = direccionService.guardar(direccionNueva,empresa.getDepartamento(),empresa.getMunicipio());

            empresaNueva.setRepresentante(empresa.getRepresentante());
            empresaNueva.setNit(empresa.getNit());
            empresaNueva.setNit(empresa.getNic());
            empresaNueva.setPaginaweb(empresa.getPaginaweb());
            empresaNueva.setTelefono(empresa.getTelefono());
            empresaNueva.setEmail(empresa.getEmail());
            empresaNueva.setPage(empresa.getPage());
            empresaCreada = empresaService.guardar(empresaNueva,direccionCreada);
            System.out.println("VALOR DE RETORNO AL CREAR EMPRESA:"+empresaCreada);
            if(empresaCreada==0){

                respuesta.put("mensaje", "Error al realizar el ingreso del registro en la DB!!");
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (DataAccessException e){
            respuesta.put("mensaje", "Error al realizar el ingreso del registro en la DB!!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El registro ha sido creado con exito!!");
        respuesta.put("empresa", empresaCreada);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/empresa/{id}")
    public ResponseEntity<?> modificarEmpresa(@RequestBody EmpresasEntity empresa,@PathVariable int id){
        EmpresasEntity empresaModificar = null,empresaActual = empresaService.findById(id);
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
            //empresaModificar = empresaService.save(empresaActual);
        }catch (DataAccessException e){
            respuesta.put("mensaje", "Error al actualizar el registro en la DB con ID:" + id + " !!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El registro ha sido actualizado con exito!!");
        respuesta.put("empresa", empresaModificar);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/empresa/departamento/municipios")
    public List<DepartamentoMunicipioModel> departamentosMunicipios(){
        List<JSONObject> totalJson= new ArrayList<JSONObject>();
        JSONObject total = new JSONObject();
        List<DepartmentosEntity> departmentoEntityList = departamentoService.listDepartamentos();
       // MunicipioEntity[] municipios={};
        List<DepartamentoMunicipioModel> lista = new ArrayList<DepartamentoMunicipioModel>();

        for(DepartmentosEntity departmentoEntity:departmentoEntityList){
            DepartamentoMunicipioModel dato = new DepartamentoMunicipioModel();
            //JSONObject departamentoJson = new JSONObject();
           // municipios= municipioService.listMunicipios(departmentoEntity.getIdDepartmento());
         //   System.out.println(municipios);
         //   dato.setDepartmentoEntity(departmentoEntity);
            dato.setIdDepartamento(departmentoEntity.getIdDepartmento());
            dato.setNombre(departmentoEntity.getNombre());
            dato.setMunicipioEntity(municipioService.listMunicipios(departmentoEntity));
          //  departamentoJson.put("municipios",municipios);
           // departamentoJson.put("departamento",departmentoEntity.getNombre());
            //System.out.println(departamentoJson);
         //   totalJson.add(departamentoJson);
        //    municipios = null;
            lista.add(dato);
        }
       // total.put("")
      //  System.out.println(totalJson);
      //  System.out.println(totalJson);
        //return new ResponseEntity<JSONObject>(lista,HttpStatus.OK);
        for (DepartmentosEntity departamento: departmentoEntityList) {
            System.out.println("Departamento:"+departamento.getNombre());
            System.out.println("Municipios---------------------------------------");
            for (MunicipiosEntity municipio: departamento.getMunicipiosByIdDepartmento()) {
                System.out.println(municipio.getNombre());
            }
        }

        return lista;
    }

}
