package com.bad.planilla.backend.apirest.services;


import com.bad.planilla.backend.apirest.entity.CatalogocomisionesEntity;
import com.bad.planilla.backend.apirest.repository.ComisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("comisionServiceImp")
public class ComisionServiceImp implements IComisionService {

    @Autowired
    private ComisionRepository com;

    @Override
    public List<CatalogocomisionesEntity> list()
    {return com.findAll(); }

    @Override
    public CatalogocomisionesEntity guardar(CatalogocomisionesEntity comision)
    {return com.save(comision); }

    @Override
    public CatalogocomisionesEntity modificar(CatalogocomisionesEntity comision) {
        return com.save(comision);
    }

    @Override
    public CatalogocomisionesEntity findById(int id)
    {return com.findByIdComision(id);}

    @Override
    public void deleteById(Long id)
    {com.deleteById(id);}
}
