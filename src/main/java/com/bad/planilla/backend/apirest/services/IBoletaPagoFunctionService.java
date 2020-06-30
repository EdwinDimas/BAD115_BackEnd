package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.BoletaPago;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface IBoletaPagoFunctionService {
    public BoletaPago obtenerBoleta(
            int id, int diasFaltados, BigDecimal horasFaltadas, BigDecimal horasExtra,
            BigDecimal horasNocturnas, BigDecimal ventas, BigDecimal bonos, int diasFestivos,
            BigDecimal otrosDescuentos, boolean esServicioProfesional, boolean aplicarVacaciones,
            String periodicidad);
}
