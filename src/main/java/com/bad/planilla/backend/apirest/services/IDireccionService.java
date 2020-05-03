package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DireccionesEntity;

public interface IDireccionService {
    public abstract int guardar(DireccionesEntity direccion, int departamento, int municipio);


}
