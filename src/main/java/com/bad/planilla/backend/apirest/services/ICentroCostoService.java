package com.bad.planilla.backend.apirest.services;

import java.util.List;

import com.bad.planilla.backend.apirest.entity.CentrocostosEntity;

public interface ICentroCostoService {
	
	public CentrocostosEntity findById(int id);
	public List<CentrocostosEntity> list();
	public CentrocostosEntity guardar(CentrocostosEntity costo);
	public List<CentrocostosEntity> costosHijos(int id);
	public List<CentrocostosEntity> costosUnidadMayor();
	
}
