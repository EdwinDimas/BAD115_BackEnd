package com.bad.planilla.backend.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.bad.planilla.backend.apirest.entity.PlanillaDescontar;

public interface PlanillaRepository extends CrudRepository<PlanillaDescontar, Integer> {

}
