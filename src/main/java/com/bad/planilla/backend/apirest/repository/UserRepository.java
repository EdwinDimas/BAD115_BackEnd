package com.bad.planilla.backend.apirest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.UsersEntity;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<UsersEntity, Integer>{

	public UsersEntity findByUsername(String username);
	public UsersEntity findByEmail(String email);
	
	public UsersEntity findByUsernameAndEmail(String username,String email);
	
	@Query(value="CALL get_usuario(:id_user_backend)",nativeQuery=true)
	public UsersEntity get_usuario(@Param("id_user_backend") int idUser);
	
}
