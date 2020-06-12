package com.bad.planilla.backend.apirest.services;

import java.util.List;

import com.bad.planilla.backend.apirest.entity.UsersEntity;

public interface IUserService {

	public List<UsersEntity> list();
	public UsersEntity guardar(UsersEntity user);
	public UsersEntity buscar(int id);
	public UsersEntity buscarUsername(String username);
	public UsersEntity buscarEmail(String email);
}
