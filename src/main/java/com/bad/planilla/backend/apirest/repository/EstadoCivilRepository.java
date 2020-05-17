package com.bad.planilla.backend.apirest.repository;


import com.bad.planilla.backend.apirest.entity.EstadoscivilesEntity;
import com.bad.planilla.backend.apirest.entity.GenerosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("estadoCivilRepository")
public interface EstadoCivilRepository extends JpaRepository<EstadoscivilesEntity, Long> {
    public EstadoscivilesEntity findByIdEstadocivil(int id_estado);
}
