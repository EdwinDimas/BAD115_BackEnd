package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import com.bad.planilla.backend.apirest.entity.MunicipiosEntity;

import java.util.List;

public interface IMunicipioService {
    public abstract List<MunicipiosEntity> listMunicipios(DepartmentosEntity id);
    public abstract MunicipiosEntity findById(int id);
}
