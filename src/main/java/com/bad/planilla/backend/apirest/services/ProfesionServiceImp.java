package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.ProfesionesEntity;
import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;
import com.bad.planilla.backend.apirest.repository.ProfesionRepository;
import com.bad.planilla.backend.apirest.repository.PuestoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("profesionService")
public class ProfesionServiceImp implements IProfesionService {

    @Autowired
    private ProfesionRepository profesionRepository;

    @Override
    public List<ProfesionesEntity> list() {
        return profesionRepository.findAll();
    }

    @Override
    public ProfesionesEntity guardar(ProfesionesEntity profesion) {
        return profesionRepository.save(profesion);
    }

    @Override
    public ProfesionesEntity findById(int id) {
        return profesionRepository.findByIdProfesion(id);
    }

    @Override
    public ProfesionesEntity modificar(ProfesionesEntity profesion) {
        return profesionRepository.save(profesion);
    }
}
