package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.DetalleboletaspagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("detalleBoletaPagoRepository")
public interface DetalleBoletaPagoRepository extends JpaRepository<DetalleboletaspagosEntity, Integer> {
}
