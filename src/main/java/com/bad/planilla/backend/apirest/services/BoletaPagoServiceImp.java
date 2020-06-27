package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.BoletaPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bad.planilla.backend.apirest.repository.BoletaPagoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service("boletaPagoService")
public class BoletaPagoServiceImp implements IBoletaPagoService {

    @Autowired
    private BoletaPagoRepository boletaPagoRepository;

    @Override
    public BoletaPago obtenerBoleta(int id, int diasFaltados, BigDecimal horasFaltadas,
                                    BigDecimal horasExtra, BigDecimal horasNocturnas, BigDecimal ventas,
                                    BigDecimal bonos, int diasFestivos,
                                    BigDecimal otrosDescuentos, boolean esServicioProfesional,
                                    boolean aplicarVacaciones, String periodicidad) {
        return boletaPagoRepository.obtenerBoleta(id, diasFaltados, horasFaltadas, horasExtra,
                horasNocturnas, ventas, bonos, diasFestivos, otrosDescuentos, esServicioProfesional,
                aplicarVacaciones, periodicidad);
    }
}
