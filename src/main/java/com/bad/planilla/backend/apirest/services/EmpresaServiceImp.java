package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.repository.EmpresaRepository;
import com.bad.planilla.backend.entity.EmpresaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("empresaServiceImp")
public class EmpresaServiceImp implements IEmpresaService {

    @Autowired
    private EmpresaRepository emp;

    @Override
    public List<EmpresaEntity> list() {
        return emp.findAll();
    }
}
