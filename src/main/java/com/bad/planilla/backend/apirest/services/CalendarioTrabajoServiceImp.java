package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.CalendariostrabajosEntity;
import com.bad.planilla.backend.apirest.repository.CalendarioTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("calendarioTrabajoService")
public class CalendarioTrabajoServiceImp implements ICalendarioTrabajoService{

    @Autowired
    private CalendarioTrabajoRepository calendarioTrabajoRepository;

    @Override
    public List<CalendariostrabajosEntity> list() {
        return calendarioTrabajoRepository.findByOrderByPeriodoDesc();
    }

    @Override
    public CalendariostrabajosEntity guardar(CalendariostrabajosEntity calendariotra) {
        return calendarioTrabajoRepository.save(calendariotra);
    }

    @Override
    public CalendariostrabajosEntity findById(int id) {
        return calendarioTrabajoRepository.findByCalendariotrabajo(id);
    }

    @Override
    public CalendariostrabajosEntity modificar(CalendariostrabajosEntity calendariotra) {
        return calendarioTrabajoRepository.save(calendariotra);
    }

    @Override
    public void eliminar(int id) {
        calendarioTrabajoRepository.deleteById(id);
    }

    @Override
    public String desactivar(int id) {
        CalendariostrabajosEntity calendarioTrabajo = calendarioTrabajoRepository.findByCalendariotrabajo(id);
        if (calendarioTrabajo.isEstado()){
            calendarioTrabajo.setEstado(false);
            calendarioTrabajo.setActivo(false);
            calendarioTrabajoRepository.save(calendarioTrabajo);
            return "Calendario desactivada";
        } else {
            return "Calendario esta desactivada";
        }
    }
    @Override
    public CalendariostrabajosEntity obtenerCalendarioDelAnio(int anio) {
        return calendarioTrabajoRepository.obtenerCalendarioDelAnio(anio);
    }
}
