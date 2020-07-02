package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.BoletaPagoFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BoletaPagoFunctionRepository extends JpaRepository<BoletaPagoFunctionEntity, Integer>{
    @Query(value="select * from generar_boleta(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)", nativeQuery = true)
    public BoletaPagoFunctionEntity obtenerBoleta(int id, int diasFaltados, BigDecimal horasFaltadas, BigDecimal horasExtra,
                                                  BigDecimal horasNocturnas, BigDecimal ventas, BigDecimal bonos, int diasFestivos,
                                                  BigDecimal otrosDescuentos, boolean esServicioProfesional, boolean aplicarVacaciones,
                                                  String periodicidad);
}
