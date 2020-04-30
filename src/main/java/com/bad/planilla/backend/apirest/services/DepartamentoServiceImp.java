package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import com.bad.planilla.backend.apirest.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departamentoService")
public class DepartamentoServiceImp implements IDepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<DepartmentosEntity> listDepartamentos() {
        return (List<DepartmentosEntity>) departamentoRepository.findAll();
    }

    @Override
    public DepartmentosEntity findById(int id) {
        return null;
    }
}
