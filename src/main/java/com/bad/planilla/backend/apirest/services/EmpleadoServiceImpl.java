package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.repository.EmpleadoRepository;
import com.bad.planilla.backend.entity.EmpleadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmpleadoServiceImpl")
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository er;

    @Override
    public List<EmpleadoEntity> list() {
        return er.findAll();
    }

    @Override
    public EmpleadoEntity save(EmpleadoEntity empresa) {
        return er.save(empresa);
    }

    @Override
    public Optional<EmpleadoEntity> findById(int id) {
        return er.findById(id);
    }

    @Override
    public void deleteById(int id) {
        //Se debe garantizar que este solo desactive el empleado
    }
}
