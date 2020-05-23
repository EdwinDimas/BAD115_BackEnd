package com.bad.planilla.backend.apirest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bad.planilla.backend.apirest.entity.CentrocostosEntity;
import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
@Repository("centroCostoRepository")
public interface CentroCostoRepository extends JpaRepository<CentrocostosEntity, Long> {
	
	public CentrocostosEntity findByIdCosto(int id);
	
	@Query(value="select * from centrocostos where id_unidadpadre = ?1 and periodo = ?2 and estado = true",nativeQuery=true)
	public List<CentrocostosEntity> findByIdUnidadPadre(int id,int periodo);
	
	@Query(value="select * from centrocostos where id_unidadpadre = 0 and periodo = ?1 and estado = true",nativeQuery=true)
	public List<CentrocostosEntity> findByUnidadMayor(int periodo);
	
	@Query(value="select * from centrocostos where id_unidadorganizacional = ?1 and periodo = ?2 and estado = true",nativeQuery=true)
	public CentrocostosEntity findByUnidadAndPeriodo(int idUnidad, int periodo);
}
