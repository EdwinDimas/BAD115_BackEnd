package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("departamentoRepository")
public interface DepartamentoRepository extends CrudRepository<DepartmentosEntity,Long> {

    @Query("from DepartmentosEntity d where d.idDepartmento = :id ")
    public DepartmentosEntity findByIdDepartmento(@Param("id")int id);
}
