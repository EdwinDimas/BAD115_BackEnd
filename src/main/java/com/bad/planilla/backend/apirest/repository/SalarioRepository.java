package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.SalariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioRepository extends JpaRepository<SalariosEntity, Integer> {
    public SalariosEntity findByIdSalario(int id);
}
