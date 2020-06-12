package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catalogodescuentos", schema = "public", catalog = "dfckhqghp2ho34")
public class CatalogodescuentosEntity {
    private int id_caralogodescuento;
    private String acronimo;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_catalogodescuento", nullable = false)
    public int getId_caralogodescuento() {
        return id_caralogodescuento;
    }

    public void setId_caralogodescuento(int id_caralogodescuento) {
        this.id_caralogodescuento = id_caralogodescuento;
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
        CatalogodescuentosEntity that = (CatalogodescuentosEntity) o;
        return id_caralogodescuento == that.id_caralogodescuento &&
                Objects.equals(acronimo, that.acronimo) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_caralogodescuento, acronimo, nombre);
    }
}
