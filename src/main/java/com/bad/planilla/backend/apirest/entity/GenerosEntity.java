package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "generos", schema = "public", catalog = "dfckhqghp2ho34")
public class GenerosEntity {
    private int idGenero;
    private String acronimo;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_genero", nullable = false)
    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
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
        GenerosEntity that = (GenerosEntity) o;
        return idGenero == that.idGenero &&
                Objects.equals(acronimo, that.acronimo) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenero, acronimo, nombre);
    }
}
