package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.CatalogocomisionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("comisionRepository")
public interface ComisionRepository extends JpaRepository<CatalogocomisionesEntity, Long> {
    public CatalogocomisionesEntity findByIdComision(int id);
}
