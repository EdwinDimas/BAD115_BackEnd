package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "direcciones", schema = "public", catalog = "dfckhqghp2ho34")
public class DireccionEntity {
    private int idDireccion;
    private String colonia;
    private String descripcion;
    private boolean estado;

    @Id
    @Column(name = "id_direccion")
    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Basic
    @Column(name = "colonia")
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

        DireccionEntity that = (DireccionEntity) o;

        if (idDireccion != that.idDireccion) return false;
        if (estado != that.estado) return false;
        if (colonia != null ? !colonia.equals(that.colonia) : that.colonia != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDireccion;
        result = 31 * result + (colonia != null ? colonia.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
