package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.BoletaPagoFunctionEntity;

import java.math.BigDecimal;

public interface IBoletaPagoFunctionService {
    public BoletaPagoFunctionEntity obtenerBoleta(
            int id, int diasFaltados, BigDecimal horasFaltadas, BigDecimal horasExtra,
            BigDecimal horasNocturnas, BigDecimal ventas, BigDecimal bonos, int diasFestivos,
            BigDecimal otrosDescuentos, boolean esServicioProfesional, boolean aplicarVacaciones,
            String periodicidad);
}
