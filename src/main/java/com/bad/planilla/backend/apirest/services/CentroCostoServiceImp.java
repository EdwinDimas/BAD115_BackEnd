package com.bad.planilla.backend.apirest.services;

import java.sql.Date;
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
	public List<CentrocostosEntity> costosHijos(int id,int periodo) {
		
		return ccr.findByIdUnidadPadre(id,periodo);
	}

	@Override
	public List<CentrocostosEntity> costosUnidadMayor(int periodo) {
		
		return ccr.findByUnidadMayor(periodo);
	}

	@Override
	public CentrocostosEntity costoByUnidadAndPeriodo(int idUnidad, int periodo) {
		
		return ccr.findByUnidadAndPeriodo(idUnidad,periodo);
	}
}
