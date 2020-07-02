package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.SalariosEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISalarioService {
    public abstract List<SalariosEntity> list();
    public abstract SalariosEntity guardar(SalariosEntity salario);
    public abstract SalariosEntity findById(int id);
    public abstract SalariosEntity modificar(SalariosEntity salario);
}
