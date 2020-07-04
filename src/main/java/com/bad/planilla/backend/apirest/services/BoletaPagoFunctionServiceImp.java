package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.BoletaPagoFunctionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bad.planilla.backend.apirest.repository.BoletaPagoFunctionRepository;

import java.math.BigDecimal;

@Service("boletaPagoService")
public class BoletaPagoFunctionServiceImp implements IBoletaPagoFunctionService {

    @Autowired
    private BoletaPagoFunctionRepository boletaPagoRepository;

    @Override
    public BoletaPagoFunctionEntity obtenerBoleta(int id, int diasFaltados, BigDecimal horasFaltadas,
                                                  BigDecimal horasExtra, BigDecimal horasNocturnas, BigDecimal ventas,
                                                  BigDecimal bonos, int diasFestivos,
                                                  BigDecimal otrosDescuentos, boolean esServicioProfesional,
                                                  boolean aplicarVacaciones, String periodicidad) {
        return boletaPagoRepository.obtenerBoleta(id, diasFaltados, horasFaltadas, horasExtra,
                horasNocturnas, ventas, bonos, diasFestivos, otrosDescuentos, esServicioProfesional,
                aplicarVacaciones, periodicidad);
    }
}
