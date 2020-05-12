package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("unidadOrganizacional")
public interface UnidadOrganizacionalRepository extends JpaRepository<UnidadesorganizacionalesEntity, Integer> {
    public UnidadesorganizacionalesEntity findByIdUnidadorganizacional(int id);
    public List<UnidadesorganizacionalesEntity> findAllByOrderByNombre();
}
