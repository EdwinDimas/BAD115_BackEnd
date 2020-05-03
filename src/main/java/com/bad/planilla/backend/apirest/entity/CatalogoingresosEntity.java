package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catalogoingresos", schema = "public", catalog = "dfckhqghp2ho34")
public class CatalogoingresosEntity {
    private int idCatalogoingresos;
    private String acronimoIngresos;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_catalogoingresos", nullable = false)
    public int getIdCatalogoingresos() {
        return idCatalogoingresos;
    }

    public void setIdCatalogoingresos(int idCatalogoingresos) {
        this.idCatalogoingresos = idCatalogoingresos;
    }

    @Basic
    @Column(name = "acronimo_ingresos", nullable = false, length = 20)
    public String getAcronimoIngresos() {
        return acronimoIngresos;
    }

    public void setAcronimoIngresos(String acronimoIngresos) {
        this.acronimoIngresos = acronimoIngresos;
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
        CatalogoingresosEntity that = (CatalogoingresosEntity) o;
        return idCatalogoingresos == that.idCatalogoingresos &&
                Objects.equals(acronimoIngresos, that.acronimoIngresos) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatalogoingresos, acronimoIngresos, nombre);
    }
}
