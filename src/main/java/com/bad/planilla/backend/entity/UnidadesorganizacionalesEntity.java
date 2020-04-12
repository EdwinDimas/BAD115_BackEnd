package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "unidadesorganizacionales", schema = "public", catalog = "dfckhqghp2ho34")
public class UnidadesorganizacionalesEntity {
    private int idUnidadorganizacional;
    private String nombre;
    private boolean unidadmayor;
    private boolean estado;

    @Id
    @Column(name = "id_unidadorganizacional")
    public int getIdUnidadorganizacional() {
        return idUnidadorganizacional;
    }

    public void setIdUnidadorganizacional(int idUnidadorganizacional) {
        this.idUnidadorganizacional = idUnidadorganizacional;
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
    @Column(name = "unidadmayor")
    public boolean isUnidadmayor() {
        return unidadmayor;
    }

    public void setUnidadmayor(boolean unidadmayor) {
        this.unidadmayor = unidadmayor;
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

        UnidadesorganizacionalesEntity that = (UnidadesorganizacionalesEntity) o;

        if (idUnidadorganizacional != that.idUnidadorganizacional) return false;
        if (unidadmayor != that.unidadmayor) return false;
        if (estado != that.estado) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUnidadorganizacional;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (unidadmayor ? 1 : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
