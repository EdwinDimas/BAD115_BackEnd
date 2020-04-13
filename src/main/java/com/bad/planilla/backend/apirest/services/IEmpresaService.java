package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.entity.EmpresaEntity;

import java.util.List;

public interface IEmpresaService {
    public abstract List<EmpresaEntity> list();
}
