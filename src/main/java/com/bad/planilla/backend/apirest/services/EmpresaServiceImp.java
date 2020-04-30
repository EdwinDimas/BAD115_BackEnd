package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.EmpresasEntity;
import com.bad.planilla.backend.apirest.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("empresaServiceImp")
public class EmpresaServiceImp implements IEmpresaService {

    @Autowired
    private EmpresaRepository emp;

    @Override
    public List<EmpresasEntity> list() {
        return emp.findAll();
    }

    @Override
    public int guardar(EmpresasEntity empresa, int direccion) {

        return emp.guardar(empresa.getRepresentante(),empresa.getNit(),empresa.getNic(),empresa.getPaginaweb(),empresa.getTelefono(),empresa.getEmail(),empresa.getPage(),direccion);
    }

    @Override
    public EmpresasEntity findById(int id) {

        return emp.findByIdEmpresa(id);
        //return emp.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        emp.deleteById(id);
    }
}
