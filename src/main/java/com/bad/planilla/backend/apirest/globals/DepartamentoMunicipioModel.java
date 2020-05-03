package com.bad.planilla.backend.apirest.globals;

import com.bad.planilla.backend.apirest.entity.MunicipiosEntity;

import java.util.List;

public class DepartamentoMunicipioModel {

    private int idDepartamento ;
    private String nombre;

    private List<MunicipiosEntity> municipioEntity;

    public List<MunicipiosEntity> getMunicipioEntity() {
        return municipioEntity;
    }

    public void setMunicipioEntity(List<MunicipiosEntity> municipioEntity) {
        this.municipioEntity = municipioEntity;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
