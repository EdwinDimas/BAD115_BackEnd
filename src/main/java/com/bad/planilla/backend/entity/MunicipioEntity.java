package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "municipios", schema = "public", catalog = "dfckhqghp2ho34")
public class MunicipioEntity {
    private int idMunicipio;
    private String nombre;

    @Id
    @Column(name = "id_municipio")
    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MunicipioEntity that = (MunicipioEntity) o;

        if (idMunicipio != that.idMunicipio) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMunicipio;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
