package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.BoletaspagosEntity;

public interface IBoletaDePagoService {
    public abstract BoletaspagosEntity guardar(BoletaspagosEntity boletaDePago);
    public abstract BoletaspagosEntity buscarId(int id);
}
