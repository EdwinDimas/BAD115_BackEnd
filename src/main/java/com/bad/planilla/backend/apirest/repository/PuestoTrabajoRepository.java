package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.PuestosTrabajosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("puestoTrabajoRepository")
public interface PuestoTrabajoRepository extends JpaRepository<PuestosTrabajosEntity, Integer> {
    public PuestosTrabajosEntity findByIdPuestotrabajo(int id);
    public List<PuestosTrabajosEntity> findAllByOrderByNombre();
}
