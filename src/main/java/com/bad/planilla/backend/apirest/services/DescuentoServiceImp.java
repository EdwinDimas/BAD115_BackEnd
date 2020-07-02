package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DescuentosEntity;
import com.bad.planilla.backend.apirest.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("descuentoService")
public class DescuentoServiceImp implements IDescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;

    @Override
    public List<DescuentosEntity> list(){
        return descuentoRepository.findAllByAcronimo();
    };

    @Override
    public DescuentosEntity guardar(DescuentosEntity descuento){
        return descuentoRepository.save(descuento);
    };

    @Override
    public DescuentosEntity findById(int id){
        return descuentoRepository.findByIdDescuento(id);
    };

    @Override
    public DescuentosEntity modificar(DescuentosEntity descuento){
        return descuentoRepository.save(descuento);
    };

    @Override
    public String desactivar(int id) {
        DescuentosEntity descuento = descuentoRepository.findByIdDescuento(id);
        if(descuento.isEstado()) {
            descuento.setEstado(false);
            descuentoRepository.save(descuento);
            return "Descuento desactivado";
        } else {
            return "El descuento fue desactivado previamente";
        }
    }
}
