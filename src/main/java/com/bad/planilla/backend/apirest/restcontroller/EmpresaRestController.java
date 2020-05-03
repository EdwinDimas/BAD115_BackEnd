package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import com.bad.planilla.backend.apirest.entity.DireccionesEntity;
import com.bad.planilla.backend.apirest.entity.EmpresasEntity;
import com.bad.planilla.backend.apirest.entity.MunicipiosEntity;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.globals.RegexGeneral;
import com.bad.planilla.backend.apirest.models.EmpresaModel;
import com.bad.planilla.backend.apirest.services.IDepartamentoService;
import com.bad.planilla.backend.apirest.services.IDireccionService;
import com.bad.planilla.backend.apirest.services.IEmpresaService;
import com.bad.planilla.backend.apirest.services.IMunicipioService;
import com.jfilter.filter.FieldFilterSetting;
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
public class EmpresaRestController {

    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IDepartamentoService departamentoService;

    @Autowired
    private IMunicipioService municipioService;

    @Autowired
    private IDireccionService direccionService;

    private RegexGeneral regexGeneral = new RegexGeneral();
    //@FieldFilterSetting(className = EmpresasEntity.class, fields = {"municipiosByIdDepartmento"})
    @GetMapping("/empresa")
    public List<EmpresasEntity> list(){
        return empresaService.list();
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<?> buscarEmpresa(@PathVariable int id){
        EmpresasEntity empresa = null;
        Map<String, Object> respuesta = new HashMap<>();
      //  System.out.println("ID---:"+id);
        try {
           // System.out.println("ENTRO A TRY=========================");
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

    @PostMapping("/empresa/crear")
    public ResponseEntity<?> crearEmpresa(@RequestBody EmpresaModel empresa){
        EmpresasEntity empresaCreada=null;
        EmpresasEntity empresaNueva = new EmpresasEntity();
        DireccionesEntity direccionNueva = new DireccionesEntity();
        DepartmentosEntity departmentoEntity = null;
        MunicipiosEntity municipioEntity = null;
        Map<String, Object> respuesta = new HashMap<>();

        if(!regexGeneral.testEmail(empresa.getEmail())){
            System.out.println("Paso Test Email");
            respuesta.put("mensaje", "Error al comparar formato con Email");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testNit(empresa.getNit())){
            System.out.println("Paso Test Nit");
            respuesta.put("mensaje", "Error al comparar formato con NIT");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testString(empresa.getRepresentante())){
            System.out.println("Paso Test String");
            respuesta.put("mensaje", "Error al comparar formato con cadena de caracteres");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testTelefono(empresa.getTelefono())){
            System.out.println("Paso Test Telefono");
            respuesta.put("mensaje", "Error al comparar formato con Telefono");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testPaginaWeb(empresa.getPaginaweb())){

            System.out.println("Paso Test pagina web");
            respuesta.put("mensaje", "Error al comparar formato con Pagina web");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        try {
            departmentoEntity = departamentoService.findById(empresa.getDepartamento());
            municipioEntity = municipioService.findById(empresa.getMunicipio());

            direccionNueva.setColonia(empresa.getColonia());
            direccionNueva.setDescripcion(empresa.getDescripcion());
            direccionNueva.setId_departmento(departmentoEntity);
            direccionNueva.setId_municipio(municipioEntity);
            direccionNueva.setEstado(true);
            DireccionesEntity direccionCreada = direccionService.guardar(direccionNueva);

            empresaNueva.setRepresentante(empresa.getRepresentante());
            empresaNueva.setNit(empresa.getNit());
            empresaNueva.setNic(empresa.getNic());
            empresaNueva.setPaginaweb(empresa.getPaginaweb());
            empresaNueva.setTelefono(empresa.getTelefono());
            empresaNueva.setEmail(empresa.getEmail());
            empresaNueva.setPage(empresa.getPage());
            empresaNueva.setId_direccion(direccionCreada);
            empresaNueva.setEstado(true);
            empresaCreada = empresaService.guardar(empresaNueva);

        }catch (DataAccessException e){
            respuesta.put("mensaje", "Error al realizar el ingreso del registro en la DB!!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El registro ha sido creado con exito!!");
        respuesta.put("empresa", empresaCreada);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/empresa/{idEmpresa}/{idDireccion}")
    public ResponseEntity<?> modificarEmpresa(@RequestBody EmpresaModel empresa,@PathVariable int idEmpresa,@PathVariable int idDireccion){
        EmpresasEntity empresaModificar = null,empresaActual = empresaService.findById(idEmpresa);
        DireccionesEntity direccionModificar = null,direccionActual = direccionService.buscarId(idDireccion);
        Map<String, Object> respuesta = new HashMap<>();
        if(empresaActual==null){
            respuesta.put("mensaje", "Error al obtener el registro empresa con ID:" + idEmpresa);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
        if(direccionActual==null){
            respuesta.put("mensaje", "Error al obtener el registro dirección con ID:" + idDireccion);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }

        if(!regexGeneral.testEmail(empresa.getEmail())){
            System.out.println("Paso Test Email");
            respuesta.put("mensaje", "Error al comparar formato con Email");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testNit(empresa.getNit())){
            System.out.println("Paso Test Nit");
            respuesta.put("mensaje", "Error al comparar formato con NIT");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testString(empresa.getRepresentante())){
            System.out.println("Paso Test String");
            respuesta.put("mensaje", "Error al comparar formato con cadena de caracteres");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testTelefono(empresa.getTelefono())){
            System.out.println("Paso Test Telefono");
            respuesta.put("mensaje", "Error al comparar formato con Telefono");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if(!regexGeneral.testPaginaWeb(empresa.getPaginaweb())){

            System.out.println("Paso Test pagina web");
            respuesta.put("mensaje", "Error al comparar formato con Pagina web");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        try {
            direccionActual.setColonia(empresa.getColonia());
            direccionActual.setDescripcion(empresa.getDescripcion());
            direccionActual.setId_departmento(departamentoService.findById(empresa.getDepartamento()));
            direccionActual.setId_municipio(municipioService.findById(empresa.getMunicipio()));
            direccionModificar = direccionService.guardar(direccionActual);

            empresaActual.setRepresentante(empresa.getRepresentante());
            empresaActual.setNit(empresa.getNit());
            empresaActual.setNic(empresa.getNic());
            empresaActual.setPaginaweb(empresa.getPaginaweb());
            empresaActual.setTelefono(empresa.getTelefono());
            empresaActual.setEmail(empresa.getEmail());
            empresaActual.setPage(empresa.getPage());
            empresaActual.setId_direccion(direccionModificar);
            empresaModificar = empresaService.guardar(empresaActual);

        }catch (DataAccessException e){
            respuesta.put("mensaje", "Error al actualizar el registro en la DB con ID:" + idEmpresa + " !!");
            respuesta.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El registro ha sido actualizado con exito!!");
        respuesta.put("empresa", empresaModificar);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/empresa/departamento/municipios")
    public List<DepartmentosEntity> departamentosMunicipios(){
        List<DepartmentosEntity> departmentoEntityList = departamentoService.listDepartamentos();
        if(departmentoEntityList.isEmpty()){
            departmentoEntityList=null;
        }
        return departmentoEntityList;
    }

}
