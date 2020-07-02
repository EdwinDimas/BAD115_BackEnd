package com.bad.planilla.backend.apirest.services;

import java.util.List;

import com.bad.planilla.backend.apirest.entity.RolesEntity;

public interface IRolService {
	public List<RolesEntity> list();
	public RolesEntity guardar(RolesEntity rol);
	public RolesEntity buscar(int id);
	public void eliminar(int id);
	public List<RolesEntity> listEstadoTrue();
}
