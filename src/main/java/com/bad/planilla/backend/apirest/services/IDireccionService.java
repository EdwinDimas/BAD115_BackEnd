package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DireccionesEntity;

public interface IDireccionService {
    public abstract DireccionesEntity guardar(DireccionesEntity direccion);
    public abstract DireccionesEntity buscarId(int id);

}
