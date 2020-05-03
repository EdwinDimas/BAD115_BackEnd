package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.GenerosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("generoRepository")
public interface GeneroRepository extends JpaRepository<GenerosEntity, Long> {

    public GenerosEntity findByIdGenero(int id_genero);
}
