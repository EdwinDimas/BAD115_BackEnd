package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;
import com.bad.planilla.backend.apirest.repository.PuestoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("puestoTrabajoService")
public class PuestoTrabajoServiceImp implements IPuestoTrabajoService {

    @Autowired
    private PuestoTrabajoRepository puestoTrabajoRepository;

    @Override
    public List<PuestosTrabajosEntity> list() {
        return puestoTrabajoRepository.findAll();
    }

    @Override
    public PuestosTrabajosEntity guardar(PuestosTrabajosEntity puestoTrabajo) {
        return puestoTrabajoRepository.save(puestoTrabajo);
    }

    @Override
    public PuestosTrabajosEntity findById(int id) {
        return puestoTrabajoRepository.findByIdPuestotrabajo(id);
    }

    @Override
    public PuestosTrabajosEntity modificar(PuestosTrabajosEntity puestoTrabajo) {
        return puestoTrabajoRepository.save(puestoTrabajo);
    }

    @Override
    public String desactivar(int id) {
        PuestosTrabajosEntity puestoTrabajo = puestoTrabajoRepository.findByIdPuestotrabajo(id);
        if(puestoTrabajo.isEstado()) {
            puestoTrabajo.setEstado(false);
            puestoTrabajoRepository.save(puestoTrabajo);
            return "Puesto de trabajo desactivado";
        } else { return "El Puesto de trabajo fue desactivado previamente"; }
    }
}
