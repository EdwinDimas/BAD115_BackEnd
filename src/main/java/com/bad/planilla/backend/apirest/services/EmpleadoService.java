package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.EmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoService extends JpaRepository<EmpleadosEntity, Long> {

}
