package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.services.EmpresaServiceImp;
import com.bad.planilla.backend.apirest.services.IEmpresaService;
import com.bad.planilla.backend.entity.EmpresaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api_empresa")
public class EmpresaRestController {

    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/list_empresas")
    public List<EmpresaEntity> list(){
        return empresaService.list();
    }


}
