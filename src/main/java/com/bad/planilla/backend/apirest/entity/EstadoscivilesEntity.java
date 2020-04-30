package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadosciviles", schema = "public", catalog = "dfckhqghp2ho34")
public class EstadoscivilesEntity {
    private int idEstadocivil;
    private String acronimo;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_estadocivil", nullable = false)
    public int getIdEstadocivil() {
        return idEstadocivil;
    }

    public void setIdEstadocivil(int idEstadocivil) {
        this.idEstadocivil = idEstadocivil;
    }

    @Basic
    @Column(name = "acronimo", nullable = false, length = 20)
    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "estado")
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoscivilesEntity that = (EstadoscivilesEntity) o;
        return idEstadocivil == that.idEstadocivil &&
                Objects.equals(acronimo, that.acronimo) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstadocivil, acronimo, nombre);
    }
}
