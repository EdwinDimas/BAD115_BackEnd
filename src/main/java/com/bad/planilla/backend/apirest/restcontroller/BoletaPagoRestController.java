package com.bad.planilla.backend.apirest.restcontroller;

import com.bad.planilla.backend.apirest.entity.BoletaPagoFunctionEntity;
import com.bad.planilla.backend.apirest.entity.BoletaspagosEntity;
import com.bad.planilla.backend.apirest.entity.DetalleboletaspagosEntity;
import com.bad.planilla.backend.apirest.globals.ConsultaBoletaPago;
import com.bad.planilla.backend.apirest.globals.Constants;
import com.bad.planilla.backend.apirest.repository.DetalleBoletaPagoRepository;
import com.bad.planilla.backend.apirest.services.BoletaDePagoServiceImp;
import com.bad.planilla.backend.apirest.services.BoletaPagoFunctionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = Constants.URL_BASE)
@RestController
@RequestMapping(Constants.BASE)
public class BoletaPagoRestController {
    @Autowired
    private BoletaPagoFunctionServiceImp boletaPagoServiceImp;

    @Autowired
    private BoletaDePagoServiceImp boletaDePagoServiceImp;

    @Autowired
    private DetalleBoletaPagoRepository detalleBoletaPagoRepository;

//   produces = MediaType.APPLICATION_JSON_VALUE
    @PreAuthorize("isAuthenticated() and hasAuthority('BOLETA_PAGO_READ')")
    @PostMapping("/obtenerboleta")
    public BoletaPagoFunctionEntity obtenerBoleta(@RequestBody ConsultaBoletaPago boletaPago){
        return boletaPagoServiceImp.obtenerBoleta(boletaPago.getId(), boletaPago.getDiasFaltados(),
                boletaPago.getHorasFaltadas(), boletaPago.getHorasExtra(),
                boletaPago.getHorasNocturnas(), boletaPago.getVentas(),
                boletaPago.getBonos(), boletaPago.getDiasFestivos(), boletaPago.getOtrosDescuentos(),
                boletaPago.isEsServicioProfesional(), boletaPago.isAplicarVacaciones(),
                boletaPago.getPeriodicidad());
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('BOLETA_PAGO_CREATE')")
    @PostMapping("/boletapago")
    public ResponseEntity<?> guardarBoleta(@RequestBody BoletaspagosEntity boletaDePago){
        try {
            BoletaspagosEntity boletaPago = boletaDePagoServiceImp.guardar(boletaDePago);
            Collection<DetalleboletaspagosEntity> detalleBoleta = boletaPago.getDetalleBoletaPago();
            for (DetalleboletaspagosEntity detalleboletaspagosEntity : detalleBoleta){
                detalleboletaspagosEntity.setIdBoletaPago(boletaPago.getIdBoletapago());
                detalleBoletaPagoRepository.save(detalleboletaspagosEntity);
            }
            return new ResponseEntity<>(boletaPago, HttpStatus.CREATED);
        } catch (DataAccessException exception) {
            return new ResponseEntity<>(exception.getCause().getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
