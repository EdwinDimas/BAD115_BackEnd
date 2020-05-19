package com.bad.planilla.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bad.planilla.backend.apirest.entity.CentrocostosEntity;
import com.bad.planilla.backend.apirest.repository.CentroCostoRepository;
@Service("centroCostoService")
public class CentroCostoServiceImp implements ICentroCostoService{
	
	@Autowired
	private CentroCostoRepository ccr;

	@Override
	public CentrocostosEntity findById(int id) {
		
		return ccr.findByIdCosto(id);
	}

	@Override
	public List<CentrocostosEntity> list() {
		
		return ccr.findAll();
	}

	@Override
	public CentrocostosEntity guardar(CentrocostosEntity costo) {
		
		return ccr.save(costo);
	}

	@Override
	public List<CentrocostosEntity> costosHijos(int id) {
		
		return ccr.findByIdUnidadPadre(id);
	}

	@Override
	public List<CentrocostosEntity> costosUnidadMayor() {
		
		return ccr.findByUnidadMayor();
	}
}
