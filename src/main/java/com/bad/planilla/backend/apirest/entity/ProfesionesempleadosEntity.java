package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "profesionesempleados", schema = "public", catalog = "dfckhqghp2ho34")
public class ProfesionesempleadosEntity {
    private int idPe;
    private Date fechatitulacion;
    private Date fecharegistro;
    private EmpleadosEntity id_empleado;
    private ProfesionesEntity id_profesion;
    private boolean estado;

    @Id
    @Column(name = "id_pe", nullable = false)
    public int getIdPe() {
        return idPe;
    }

    public void setIdPe(int idPe) {
        this.idPe = idPe;
    }

    @Basic
    @Column(name = "fechatitulacion", nullable = false)
    public Date getFechatitulacion() {
        return fechatitulacion;
    }

    public void setFechatitulacion(Date fechatitulacion) {
        this.fechatitulacion = fechatitulacion;
    }

    @Basic
    @Column(name = "fecharegistro", nullable = false)
    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
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
        ProfesionesempleadosEntity that = (ProfesionesempleadosEntity) o;
        return idPe == that.idPe &&
                Objects.equals(fechatitulacion, that.fechatitulacion) &&
                Objects.equals(fecharegistro, that.fecharegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPe, fechatitulacion, fecharegistro);
    }

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    public EmpleadosEntity getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(EmpleadosEntity id_empleado) {
        this.id_empleado = id_empleado;
    }

    @ManyToOne
    @JoinColumn(name = "id_profesion", referencedColumnName = "id_profesion")
    public ProfesionesEntity getId_profesion() {
        return id_profesion;
    }

    public void setId_profesion(ProfesionesEntity id_profesion) {
        this.id_profesion = id_profesion;
    }
}
