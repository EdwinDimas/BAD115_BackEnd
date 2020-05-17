package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.repository.EmpleadoRepository;
import com.bad.planilla.backend.apirest.entity.EmpleadosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmpleadoServiceImpl")
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository er;

    @Override
    public List<EmpleadosEntity> list() {
        return er.findAll();
    }

    @Override
    public EmpleadosEntity save(EmpleadosEntity empleado) {
        return er.save(empleado);
    }

    @Override
    public Optional<EmpleadosEntity> findById(int id_empleado) {
        return er.findByIdEmpleado(id_empleado);
    }

    @Override
    public void deleteById(int id_empleado) {
        //Se debe garantizar que este solo desactive el empleado
    }
}
