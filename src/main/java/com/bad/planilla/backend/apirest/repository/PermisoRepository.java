package com.bad.planilla.backend.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.PermisosEntity;

@Repository("permisoRepository")
public interface PermisoRepository extends CrudRepository<PermisosEntity, Integer>{

}
