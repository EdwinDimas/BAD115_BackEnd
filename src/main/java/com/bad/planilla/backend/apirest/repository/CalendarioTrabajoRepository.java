package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.CalendariostrabajosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("calendarioTrabajoRepository")
public interface CalendarioTrabajoRepository extends JpaRepository<CalendariostrabajosEntity, Integer> {
    public CalendariostrabajosEntity findByCalendariotrabajo(int id);
    public List<CalendariostrabajosEntity> findByOrderByPeriocidad(); ;
    @Query(value = "SELECT * FROM calendariostrabajos where periodo = ?1", nativeQuery = true)
    public CalendariostrabajosEntity obtenerCalendarioDelAnio(int anio);

}
