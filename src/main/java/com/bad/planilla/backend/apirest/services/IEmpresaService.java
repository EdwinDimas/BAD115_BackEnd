package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.EmpresasEntity;

import java.util.List;

public interface IEmpresaService {
    public abstract List<EmpresasEntity> list();
    public abstract EmpresasEntity guardar(EmpresasEntity empresa);
    public abstract EmpresasEntity findById(int id);
    public abstract void deleteById(Long id);
}
