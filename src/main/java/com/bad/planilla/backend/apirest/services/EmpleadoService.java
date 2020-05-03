package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.EmpleadosEntity;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    public abstract List<EmpleadosEntity> list();
    public abstract EmpleadosEntity save(EmpleadosEntity empleado);
    public abstract Optional<EmpleadosEntity> findById(int id_empleado);
    public abstract void deleteById(int id_empleado);
}
