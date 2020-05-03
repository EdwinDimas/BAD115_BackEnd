package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;

import java.util.List;

public interface IDepartamentoService{
    public abstract List<DepartmentosEntity> listDepartamentos();
    public abstract DepartmentosEntity findById(int id);

}
