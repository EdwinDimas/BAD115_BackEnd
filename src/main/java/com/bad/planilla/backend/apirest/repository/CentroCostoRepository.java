package com.bad.planilla.backend.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.CentrocostosEntity;
@Repository("centroCostoRepository")
public interface CentroCostoRepository extends JpaRepository<CentrocostosEntity, Long> {
	
	public CentrocostosEntity findByIdCosto(int id);
	
	public List<CentrocostosEntity> findByIdUnidadPadre(int id);
	
	@Query(value="select * from centrocostos where idUnidadPadre is null",nativeQuery=true)
	public List<CentrocostosEntity> findByUnidadMayor();
}
