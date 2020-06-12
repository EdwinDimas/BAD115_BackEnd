package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.EmpleadosDescuentosEntity;
import org.springframework.stereotype.Service;

@Service
public interface IEmpleadoDescuentoService {
    public abstract EmpleadosDescuentosEntity guardar(EmpleadosDescuentosEntity empleadoDescuento);
}
