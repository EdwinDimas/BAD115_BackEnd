package com.bad.planilla.backend.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.RolesEntity;

@Repository("rolRepository")
public interface RolRepository extends CrudRepository<RolesEntity, Integer>{

	@Query(value="select * from roles where estado = true",nativeQuery=true)
	public List<RolesEntity> buscarEstadoTrue();
}
