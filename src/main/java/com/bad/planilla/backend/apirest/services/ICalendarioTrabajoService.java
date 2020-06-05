package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.CalendariostrabajosEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  ICalendarioTrabajoService {
//    public List<CalendariostrabajosEntity>listar();
//    public Optional<CalendariostrabajosEntity>listarId(int id);
//    public int guardar(CalendariostrabajosEntity ca);
//    public void eliminar(int id);

    public abstract List<CalendariostrabajosEntity> list();
    public abstract CalendariostrabajosEntity guardar(CalendariostrabajosEntity calendariotrabajo);
    public abstract CalendariostrabajosEntity findById(int id);
    public abstract CalendariostrabajosEntity modificar(CalendariostrabajosEntity calendariotrabajo);
    public void eliminar(int id);
    public abstract String desactivar(int id);

}