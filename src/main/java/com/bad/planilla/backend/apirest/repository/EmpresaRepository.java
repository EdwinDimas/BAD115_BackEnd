package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.EmpresasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("empresaRepository")
public interface EmpresaRepository extends JpaRepository<EmpresasEntity,Long> {
    public EmpresasEntity findByIdEmpresa(int id);

//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query(value ="insert into empresas values(?1,?2,?3,?4,?5,?6,?7,?8)" ,nativeQuery = true)
//    public int guardar(String representante, String nit, String nic, String paginaweb,String telefono, String email, String page,int direccion);
}
