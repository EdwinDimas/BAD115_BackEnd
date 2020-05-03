package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import com.bad.planilla.backend.apirest.entity.MunicipiosEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("municipioRepository")
public interface MunicipioRepository extends CrudRepository<MunicipiosEntity,Long> {

   // @Query(value = "select id_municipio, nombre from municipios where id_departmento = ?1 ",nativeQuery = true)

   // public List<MunicipiosEntity> findById_departmento(int id);
    @Query("from MunicipiosEntity m where m.id_departmento = :id ")
    public List<MunicipiosEntity> getMunicipiosByIdDepartamento(@Param("id") DepartmentosEntity id);

    @Query("from MunicipiosEntity m where m.idMunicipio = :id")
    public MunicipiosEntity findByIdMunicipio(@Param("id")int id);
}
