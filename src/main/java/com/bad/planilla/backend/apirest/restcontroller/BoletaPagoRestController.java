package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.BoletaPago;
import com.bad.planilla.backend.apirest.globals.ConsultaBoletaPago;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.services.BoletaPagoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = Constants.URL_BASE)
@RestController
@RequestMapping(Constants.BASE)
public class BoletaPagoRestController {
    @Autowired
    private BoletaPagoServiceImp boletaPagoServiceImp;

//   produces = MediaType.APPLICATION_JSON_VALUE
    @PostMapping("/obtenerboleta")
    public BoletaPago obtenerBoleta(@RequestBody ConsultaBoletaPago boletaPago){
        return boletaPagoServiceImp.obtenerBoleta(boletaPago.getId(), boletaPago.getDiasFaltados(),
                boletaPago.getHorasFaltadas(), boletaPago.getHorasExtra(),
                boletaPago.getHorasNocturnas(), boletaPago.getVentas(),
                boletaPago.getBonos(), boletaPago.getDiasFestivos(), boletaPago.getOtrosDescuentos(),
                boletaPago.isEsServicioProfesional(), boletaPago.isAplicarVacaciones(),
                boletaPago.getPeriodicidad());
    }
}
