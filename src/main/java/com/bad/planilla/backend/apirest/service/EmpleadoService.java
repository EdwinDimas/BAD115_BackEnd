package com.bad.planilla.backend.apirest.service;

import com.bad.planilla.backend.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoService extends JpaRepository<EmpleadoEntity, Long> {

}
