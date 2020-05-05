package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.ProfesionesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProfesionService {
    public abstract List<ProfesionesEntity> list();
    public abstract ProfesionesEntity guardar(ProfesionesEntity profesion);
    public abstract ProfesionesEntity findById(int id);
    public abstract ProfesionesEntity modificar(ProfesionesEntity profesion);

}
