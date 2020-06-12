package com.bad.planilla.backend.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.UsersEntity;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<UsersEntity, Integer>{

	public UsersEntity findByUsername(String username);
	public UsersEntity findByEmail(String email);
}
