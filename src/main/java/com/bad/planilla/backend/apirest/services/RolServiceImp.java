package com.bad.planilla.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bad.planilla.backend.apirest.entity.RolesEntity;
import com.bad.planilla.backend.apirest.repository.RolRepository;

@Service("rolService")
public class RolServiceImp implements IRolService{

	@Autowired
	private RolRepository rr;
	
	@Override
	public List<RolesEntity> list() {
		
		return (List<RolesEntity>) rr.findAll();
	}

	@Override
	public RolesEntity guardar(RolesEntity rol) {
		
		return rr.save(rol);
	}

	@Override
	public RolesEntity buscar(int id) {
		
		return rr.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		rr.deleteById(id);
		
	}

	@Override
	public List<RolesEntity> listEstadoTrue() {

		return rr.buscarEstadoTrue();
	}

}
