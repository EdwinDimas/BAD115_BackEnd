package com.bad.planilla.backend.apirest.repository;

import com.bad.planilla.backend.apirest.entity.DescuentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("descuentoRepository")
public interface DescuentoRepository extends JpaRepository<DescuentosEntity, Integer> {
    public DescuentosEntity findByIdDescuento(int id);
    @Query(value = "select * from descuentos order by acronimo", nativeQuery = true)
    public List<DescuentosEntity> findAllByAcronimo();
}
