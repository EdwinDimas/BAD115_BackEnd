package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.EmpleadosDescuentosEntity;
import com.bad.planilla.backend.apirest.repository.EmpleadoDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empleadoDescuentoService")
public class EmpleadoDescuentoImp implements IEmpleadoDescuentoService {

    @Autowired
    private EmpleadoDescuentoRepository empleadoDescuentoRepository;

    @Override
    public EmpleadosDescuentosEntity guardar(EmpleadosDescuentosEntity empleadoDescuento) {
        return empleadoDescuentoRepository.save(empleadoDescuento);
    }




}
