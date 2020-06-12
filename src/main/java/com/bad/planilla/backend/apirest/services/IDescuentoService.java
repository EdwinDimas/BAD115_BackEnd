package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DescuentosEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDescuentoService {
    public abstract List<DescuentosEntity> list();
    public abstract DescuentosEntity guardar(DescuentosEntity descuento);
    public abstract DescuentosEntity findById(int id);
    public abstract DescuentosEntity modificar(DescuentosEntity descuento);
    public abstract String desactivar(int id);
}
