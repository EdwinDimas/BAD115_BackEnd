package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "puestostrabajos", schema = "public", catalog = "dfckhqghp2ho34")
public class PuestoTrabajoEntity {
    private int idPuestotrabajo;
    private String nombre;
    private String descripcion;
    private boolean estado;

    @Id
    @Column(name = "id_puestotrabajo")
    public int getIdPuestotrabajo() {
        return idPuestotrabajo;
    }

    public void setIdPuestotrabajo(int idPuestotrabajo) {
        this.idPuestotrabajo = idPuestotrabajo;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

        PuestoTrabajoEntity that = (PuestoTrabajoEntity) o;

        if (idPuestotrabajo != that.idPuestotrabajo) return false;
        if (estado != that.estado) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPuestotrabajo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
