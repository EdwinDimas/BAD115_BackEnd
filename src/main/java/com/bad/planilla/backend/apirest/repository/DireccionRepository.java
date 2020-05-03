package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.DireccionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository("direccionRepository")
public interface DireccionRepository extends JpaRepository<DireccionesEntity,Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="insert into direcciones values(?1, ?2, ?3, ?4, ?5)",nativeQuery = true)
    public int guardar(String colonia, String descripcion,boolean estado, int departamento,int municipio);

}
