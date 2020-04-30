package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "municipios", schema = "public", catalog = "dfckhqghp2ho34")
public class MunicipiosEntity {
    private int idMunicipio;
    private DepartmentosEntity id_departmento;
    private String nombre;

    @Id
    @Column(name = "id_municipio", nullable = false)
    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @ManyToOne
    @JoinColumn(name = "id_departmento", referencedColumnName = "id_departmento")
    public DepartmentosEntity getId_departmento() {
        return id_departmento;
    }

    public void setId_departmento(DepartmentosEntity id_departmento) {
        this.id_departmento = id_departmento;
    }


    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
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
        MunicipiosEntity that = (MunicipiosEntity) o;
        return idMunicipio == that.idMunicipio &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMunicipio, nombre);
    }
}
