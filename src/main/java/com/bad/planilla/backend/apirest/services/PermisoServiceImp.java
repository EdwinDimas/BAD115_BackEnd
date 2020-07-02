package com.bad.planilla.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bad.planilla.backend.apirest.entity.PermisosEntity;
import com.bad.planilla.backend.apirest.repository.PermisoRepository;

@Service("permisoService")
public class PermisoServiceImp implements IPermisoService {

	@Autowired
	private PermisoRepository pr;
	
	@Override
	public List<PermisosEntity> list() {
		
		return (List<PermisosEntity>) pr.findAll();
	}

}
