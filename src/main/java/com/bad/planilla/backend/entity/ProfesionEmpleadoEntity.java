package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profesionesempleados", schema = "public", catalog = "dfckhqghp2ho34")
public class ProfesionEmpleadoEntity {
    private int idPe;
    private Integer id;
    private Integer idProfesion;
    private Date fechatitulacion;
    private Date fecharegistro;
    private boolean estado;
    private EmpleadoEntity empleadosById;
    private ProfesionEntity profesionesByIdProfesion;

    @Id
    @Column(name = "id_pe")
    public int getIdPe() {
        return idPe;
    }

    public void setIdPe(int idPe) {
        this.idPe = idPe;
    }

    @Basic
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_profesion")
    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
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
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idProfesion != null ? !idProfesion.equals(that.idProfesion) : that.idProfesion != null) return false;
        if (fechatitulacion != null ? !fechatitulacion.equals(that.fechatitulacion) : that.fechatitulacion != null)
            return false;
        if (fecharegistro != null ? !fecharegistro.equals(that.fecharegistro) : that.fecharegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPe;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (idProfesion != null ? idProfesion.hashCode() : 0);
        result = 31 * result + (fechatitulacion != null ? fechatitulacion.hashCode() : 0);
        result = 31 * result + (fecharegistro != null ? fecharegistro.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    public EmpleadoEntity getEmpleadosById() {
        return empleadosById;
    }

    public void setEmpleadosById(EmpleadoEntity empleadosById) {
        this.empleadosById = empleadosById;
    }

    @ManyToOne
    @JoinColumn(name = "id_profesion", referencedColumnName = "id_profesion", insertable=false, updatable=false)
    public ProfesionEntity getProfesionesByIdProfesion() {
        return profesionesByIdProfesion;
    }

    public void setProfesionesByIdProfesion(ProfesionEntity profesionesByIdProfesion) {
        this.profesionesByIdProfesion = profesionesByIdProfesion;
    }
}
