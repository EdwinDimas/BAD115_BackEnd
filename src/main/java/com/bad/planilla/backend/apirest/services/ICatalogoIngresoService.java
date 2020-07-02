package com.bad.planilla.backend.apirest.services;

import java.util.List;

import com.bad.planilla.backend.apirest.entity.CatalogoingresosEntity;

public interface ICatalogoIngresoService {
	
	public CatalogoingresosEntity guardar(CatalogoingresosEntity ingreso);
	public CatalogoingresosEntity buscar(int idIngreso);
	public List<CatalogoingresosEntity> list();
	public List<CatalogoingresosEntity> listTrue();

}
