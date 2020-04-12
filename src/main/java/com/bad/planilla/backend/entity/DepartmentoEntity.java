package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "departmentos", schema = "public", catalog = "dfckhqghp2ho34")
public class DepartmentoEntity {
    private int idDepartmento;
    private String nombre;

    @Id
    @Column(name = "id_departmento")
    public int getIdDepartmento() {
        return idDepartmento;
    }

    public void setIdDepartmento(int idDepartmento) {
        this.idDepartmento = idDepartmento;
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

        DepartmentoEntity that = (DepartmentoEntity) o;

        if (idDepartmento != that.idDepartmento) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepartmento;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
