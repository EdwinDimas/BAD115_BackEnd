package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoService extends JpaRepository<EmpleadoEntity, Long> {

}
