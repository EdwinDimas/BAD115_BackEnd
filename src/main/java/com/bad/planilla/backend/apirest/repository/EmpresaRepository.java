package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("empresaRepository")
public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Long> {
    public EmpresaEntity findByIdEmpresa(int id);
}
