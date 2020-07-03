package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.SalariosEntity;
import com.bad.planilla.backend.apirest.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salarioService")
public class SalarioServiceImp implements ISalarioService {
    @Autowired
    private SalarioRepository salarioRepository;

    @Override
    public List<SalariosEntity> list() {
        return salarioRepository.findAll();
    }

    @Override
    public SalariosEntity guardar(SalariosEntity salario) {
        return salarioRepository.save(salario);
    }

    @Override
    public SalariosEntity findById(int id) {
        return salarioRepository.findByIdSalario(id);
    }

    @Override
    public SalariosEntity modificar(SalariosEntity salario) {
        return salarioRepository.save(salario);
    }
}
