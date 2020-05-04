package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPuestoTrabajoService {
    public abstract List<PuestosTrabajosEntity> list();
    public abstract PuestosTrabajosEntity guardar(PuestosTrabajosEntity puestoTrabajo);
    public abstract PuestosTrabajosEntity findById(int id);
    public abstract PuestosTrabajosEntity modificar(PuestosTrabajosEntity puestoTrabajo);
    public abstract String desactivar(int id);
}
