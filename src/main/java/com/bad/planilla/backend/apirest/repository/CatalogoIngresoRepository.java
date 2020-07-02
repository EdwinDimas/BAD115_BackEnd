package com.bad.planilla.backend.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.CatalogoingresosEntity;
@Repository("catalogoIngresoRepository")
public interface CatalogoIngresoRepository extends CrudRepository<CatalogoingresosEntity, Integer>{

	public CatalogoingresosEntity findByIdCatalogoingresos(int id);
	
	@Query(value="select * from list_ingreso_true;",nativeQuery=true)
	public List<CatalogoingresosEntity> listIngresoTrue();
	
}
