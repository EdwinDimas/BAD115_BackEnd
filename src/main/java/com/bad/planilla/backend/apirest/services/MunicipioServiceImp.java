package com.bad.planilla.backend.apirest.services;

import com.bad.planilla.backend.apirest.entity.DepartmentosEntity;
import com.bad.planilla.backend.apirest.entity.MunicipiosEntity;
import com.bad.planilla.backend.apirest.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("municipioService")
public class MunicipioServiceImp implements IMunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Override
    public List<MunicipiosEntity> listMunicipios(DepartmentosEntity id) {
        List<MunicipiosEntity> municipios = municipioRepository.getMunicipiosByIdDepartamento(id);
        return municipios;
    }

    @Override
    public MunicipiosEntity findById(int id) {
        return municipioRepository.findByIdMunicipio(id);
    }
}
