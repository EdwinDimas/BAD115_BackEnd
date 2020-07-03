package com.bad.planilla.backend.apirest.services;


import com.bad.planilla.backend.apirest.entity.BoletaspagosEntity;
import com.bad.planilla.backend.apirest.repository.BoletaDePagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boletaDePagoService")
public class BoletaDePagoServiceImp implements IBoletaDePagoService {
    @Autowired
    private BoletaDePagoRepository boletaDePagoRepository;

    @Override
    public BoletaspagosEntity guardar(BoletaspagosEntity boletaDePago) {
        return boletaDePagoRepository.save(boletaDePago);
    }

	@Override
	public BoletaspagosEntity buscarId(int id) {
		
		return boletaDePagoRepository.findById(id).orElse(null);
	}
}
