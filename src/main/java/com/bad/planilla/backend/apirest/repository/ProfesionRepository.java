package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.ProfesionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("profesionRepository")
public interface ProfesionRepository extends JpaRepository<ProfesionesEntity, Integer> {
    public ProfesionesEntity findByIdProfesion(int id);

}
