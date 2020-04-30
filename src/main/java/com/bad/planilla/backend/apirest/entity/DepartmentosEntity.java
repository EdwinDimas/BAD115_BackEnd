package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "departmentos", schema = "public", catalog = "dfckhqghp2ho34")
public class DepartmentosEntity {
    private int idDepartmento;
    private String nombre;
    private Collection<MunicipiosEntity> municipiosByIdDepartmento;

    @Id
    @Column(name = "id_departmento", nullable = false)
    public int getIdDepartmento() {
        return idDepartmento;
    }

    public void setIdDepartmento(int idDepartmento) {
        this.idDepartmento = idDepartmento;
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
        DepartmentosEntity that = (DepartmentosEntity) o;
        return idDepartmento == that.idDepartmento &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartmento, nombre);
    }

    @OneToMany(mappedBy = "id_departmento")
    public Collection<MunicipiosEntity> getMunicipiosByIdDepartmento() {
        return municipiosByIdDepartmento;
    }

    public void setMunicipiosByIdDepartmento(Collection<MunicipiosEntity> municipiosByIdDepartmento) {
        this.municipiosByIdDepartmento = municipiosByIdDepartmento;
    }
}
