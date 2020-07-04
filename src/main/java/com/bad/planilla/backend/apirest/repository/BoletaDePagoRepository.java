package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.BoletaspagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("boletaDePagoRepository")
public interface BoletaDePagoRepository extends JpaRepository<BoletaspagosEntity, Integer> {
}
