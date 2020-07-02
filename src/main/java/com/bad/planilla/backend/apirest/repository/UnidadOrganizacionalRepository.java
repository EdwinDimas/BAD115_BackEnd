package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.UnidadesorganizacionalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("unidadOrganizacionalRepository")
public interface UnidadOrganizacionalRepository extends JpaRepository<UnidadesorganizacionalesEntity, Integer> {
    public UnidadesorganizacionalesEntity findByIdUnidadorganizacional(int id);
    public List<UnidadesorganizacionalesEntity> findAllByOrderByNombre();
    //@Query(value="select * from update_costo(:id_unidad,:id_unidad_padre)",nativeQuery=true)
    //public boolean updateCosto(@Param("id_unidad") int idUnidad, @Param("id_unidad_padre") int idUnidadPadre);
    @Query(value="select * from update_costo(:id_unidad,:id_unidad_padre)",nativeQuery=true)
    public boolean updateCosto(@Param("id_unidad") int idUnidad, @Param("id_unidad_padre") int idUnidadPadre);
  
    public List<UnidadesorganizacionalesEntity> findByUnidadmayorAndEstado(boolean unidad,boolean estado);
    public List<UnidadesorganizacionalesEntity> findByUnidadOrganizacionalSuperiorAndEstado(int unidad,boolean estado);
}
