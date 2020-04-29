package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.entity.EmpleadoEntity;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    public abstract List<EmpleadoEntity> list();
    public abstract EmpleadoEntity save(EmpleadoEntity empresa);
    public abstract Optional<EmpleadoEntity> findById(int id);
    public abstract void deleteById(int id);
}
