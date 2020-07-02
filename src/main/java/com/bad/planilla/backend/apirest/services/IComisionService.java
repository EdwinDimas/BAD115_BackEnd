package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.CatalogocomisionesEntity;
import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;

import java.util.List;

public interface IComisionService {
    public abstract List<CatalogocomisionesEntity> list();
    public abstract CatalogocomisionesEntity guardar(CatalogocomisionesEntity comision);
    public abstract CatalogocomisionesEntity findById(int id);
    public abstract CatalogocomisionesEntity modificar(CatalogocomisionesEntity comision);

    public abstract void deleteById(Long id);
}