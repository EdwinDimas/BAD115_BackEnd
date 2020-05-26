package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.CalendariostrabajosEntity;
import com.bad.planilla.backend.apirest.repository.CalendarioTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("calendarioTrabajoServicd")
public class CalendarioTrabajoServiceImp implements ICalendarioTrabajoService{

    @Autowired
    private CalendarioTrabajoRepository calendarioTrabajoRepository;


    @Override
    public List<CalendariostrabajosEntity> list() {
        return null;
    }

    @Override
    public CalendariostrabajosEntity guardar(CalendariostrabajosEntity calendariotra) {
        return null;
    }

    @Override
    public CalendariostrabajosEntity findById(int id) {
        return null;
    }

    @Override
    public CalendariostrabajosEntity modificar(CalendariostrabajosEntity calendariotra) {
        return null;
    }

    @Override
    public String desactivar(int id) {
        return null;
    }
}
