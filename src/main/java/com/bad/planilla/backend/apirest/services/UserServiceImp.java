package com.bad.planilla.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bad.planilla.backend.apirest.entity.UsersEntity;
import com.bad.planilla.backend.apirest.repository.UserRepository;

@Service("userService")
public class UserServiceImp implements IUserService{
	
	@Autowired
	private UserRepository ur;

	@Override
	public List<UsersEntity> list() {
		
		return (List<UsersEntity>) ur.findAll();
	}

	@Override
	public UsersEntity guardar(UsersEntity user) {
		
		return ur.save(user);
	}

	@Override
	public UsersEntity buscar(int id) {
		
		return ur.findById(id).orElse(null);
	}

	@Override
	public UsersEntity buscarUsername(String username) {
		
		return ur.findByUsername(username);
	}

	@Override
	public UsersEntity buscarEmail(String email) {
		
		return ur.findByEmail(email);
	}

}
