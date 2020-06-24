package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.EmpleadosDescuentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("empleadoDescuentoRepository")
public interface EmpleadoDescuentoRepository extends JpaRepository<EmpleadosDescuentosEntity, Integer> {
}
