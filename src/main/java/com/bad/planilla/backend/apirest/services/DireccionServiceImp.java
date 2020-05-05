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
    public DireccionesEntity guardar(DireccionesEntity direccion) {

        //return 0;
        return direccionRepository.save(direccion);
    }

    @Override
    public DireccionesEntity buscarId(int id) {
        return direccionRepository.findByIdDireccion(id);
    }
}
