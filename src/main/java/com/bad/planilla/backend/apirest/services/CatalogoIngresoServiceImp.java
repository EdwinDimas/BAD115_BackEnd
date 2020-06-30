package com.bad.planilla.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bad.planilla.backend.apirest.entity.CatalogoingresosEntity;
import com.bad.planilla.backend.apirest.repository.CatalogoIngresoRepository;

@Service("catalogoIngresoService")
public class CatalogoIngresoServiceImp implements ICatalogoIngresoService {
	
	@Autowired
	private CatalogoIngresoRepository cr;

	@Override
	public CatalogoingresosEntity guardar(CatalogoingresosEntity ingreso) {
		
		return cr.save(ingreso);
	}

	@Override
	public CatalogoingresosEntity buscar(int idIngreso) {
		
		return cr.findByIdCatalogoingresos(idIngreso);
	}

	@Override
	public List<CatalogoingresosEntity> list() {
		
		return (List<CatalogoingresosEntity>) cr.findAll();
	}

	@Override
	public List<CatalogoingresosEntity> listTrue() {
		
		return cr.listIngresoTrue();
	}

}
