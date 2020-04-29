package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "estadosciviles", schema = "public", catalog = "dfckhqghp2ho34")
public class EstadoCivilEntity {
    private int idEstadocivil;
    private String acronimo;
    private String nombre;
    private boolean estado;
    private Collection<EmpleadoEntity> empleadosByIdEstadocivil;

    @Id
    @Column(name = "id_estadocivil")
    public int getIdEstadocivil() {
        return idEstadocivil;
    }

    public void setIdEstadocivil(int idEstadocivil) {
        this.idEstadocivil = idEstadocivil;
    }

    @Basic
    @Column(name = "acronimo")
    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
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

        EstadoCivilEntity that = (EstadoCivilEntity) o;

        if (idEstadocivil != that.idEstadocivil) return false;
        if (estado != that.estado) return false;
        if (acronimo != null ? !acronimo.equals(that.acronimo) : that.acronimo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstadocivil;
        result = 31 * result + (acronimo != null ? acronimo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoscivilesByIdEstadocivil")
    public Collection<EmpleadoEntity> getEmpleadosByIdEstadocivil() {
        return empleadosByIdEstadocivil;
    }

    public void setEmpleadosByIdEstadocivil(Collection<EmpleadoEntity> empleadosByIdEstadocivil) {
        this.empleadosByIdEstadocivil = empleadosByIdEstadocivil;
    }
}
