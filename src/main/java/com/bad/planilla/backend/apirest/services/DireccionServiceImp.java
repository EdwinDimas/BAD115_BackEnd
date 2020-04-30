package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DireccionesEntity;
import com.bad.planilla.backend.apirest.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("direccionService")
public class DireccionServiceImp implements IDireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public int guardar(DireccionesEntity direccion, int departamento, int municipio) {

        return 0;
        //return direccionRepository.guardar(direccion.getColonia(),direccion.getDescripcion(),direccion.isEstado(),departamento,municipio);
    }
}
