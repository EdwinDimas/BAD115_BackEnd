package com.bad.planilla.backend.apirest.services;

import java.sql.Date;
import java.util.List;

import com.bad.planilla.backend.apirest.entity.CentrocostosEntity;
import com.bad.planilla.backend.apirest.entity.PlanillaDescontar;
import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;

public interface ICentroCostoService {
	
	public CentrocostosEntity findById(int id);
	public List<CentrocostosEntity> list();
	public CentrocostosEntity guardar(CentrocostosEntity costo);
	public List<CentrocostosEntity> costosHijos(int id,int periodo);
	public List<CentrocostosEntity> costosUnidadMayor(int periodo);
	public CentrocostosEntity costoByUnidadAndPeriodo(int idUnidad, int periodo);
	public List<PlanillaDescontar> getPlanillaDescontar();
}
