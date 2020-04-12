package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profesionesempleados", schema = "public", catalog = "dfckhqghp2ho34")
public class ProfesionEmpleadoEntity {
    private int idPe;
    private Date fechatitulacion;
    private Date fecharegistro;
    private boolean estado;

    @Id
    @Column(name = "id_pe")
    public int getIdPe() {
        return idPe;
    }

    public void setIdPe(int idPe) {
        this.idPe = idPe;
    }

    @Basic
    @Column(name = "fechatitulacion")
    public Date getFechatitulacion() {
        return fechatitulacion;
    }

    public void setFechatitulacion(Date fechatitulacion) {
        this.fechatitulacion = fechatitulacion;
    }

    @Basic
    @Column(name = "fecharegistro")
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

        ProfesionEmpleadoEntity that = (ProfesionEmpleadoEntity) o;

        if (idPe != that.idPe) return false;
        if (estado != that.estado) return false;
        if (fechatitulacion != null ? !fechatitulacion.equals(that.fechatitulacion) : that.fechatitulacion != null)
            return false;
        if (fecharegistro != null ? !fecharegistro.equals(that.fecharegistro) : that.fecharegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPe;
        result = 31 * result + (fechatitulacion != null ? fechatitulacion.hashCode() : 0);
        result = 31 * result + (fecharegistro != null ? fecharegistro.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
