package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "profesiones", schema = "public", catalog = "dfckhqghp2ho34")
public class ProfesionEntity {
    private int idProfesion;
    private String acronimo;
    private String nombre;
    private boolean estado;
    private Collection<ProfesionEmpleadoEntity> profesionesempleadosByIdProfesion;

    @Id
    @Column(name = "id_profesion")
    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
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

        ProfesionEntity that = (ProfesionEntity) o;

        if (idProfesion != that.idProfesion) return false;
        if (estado != that.estado) return false;
        if (acronimo != null ? !acronimo.equals(that.acronimo) : that.acronimo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProfesion;
        result = 31 * result + (acronimo != null ? acronimo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "profesionesByIdProfesion")
    public Collection<ProfesionEmpleadoEntity> getProfesionesempleadosByIdProfesion() {
        return profesionesempleadosByIdProfesion;
    }

    public void setProfesionesempleadosByIdProfesion(Collection<ProfesionEmpleadoEntity> profesionesempleadosByIdProfesion) {
        this.profesionesempleadosByIdProfesion = profesionesempleadosByIdProfesion;
    }
}
