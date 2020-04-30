package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "documentosempleados", schema = "public", catalog = "dfckhqghp2ho34")
public class DocumentosempleadosEntity {
    private int idDocumentoempleado;
    private String numerodocumento;
    private Date fecharegistro;
    private EmpleadosEntity id_empleado;
    private DocumentosidentificacionesEntity id_di;
    private boolean estado;

    @Id
    @Column(name = "id_documentoempleado", nullable = false)
    public int getIdDocumentoempleado() {
        return idDocumentoempleado;
    }

    public void setIdDocumentoempleado(int idDocumentoempleado) {
        this.idDocumentoempleado = idDocumentoempleado;
    }

    @Basic
    @Column(name = "numerodocumento", nullable = false, length = 20)
    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
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
        DocumentosempleadosEntity that = (DocumentosempleadosEntity) o;
        return idDocumentoempleado == that.idDocumentoempleado &&
                Objects.equals(numerodocumento, that.numerodocumento) &&
                Objects.equals(fecharegistro, that.fecharegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDocumentoempleado, numerodocumento, fecharegistro);
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
    @JoinColumn(name = "id_di", referencedColumnName = "id_di")
    public DocumentosidentificacionesEntity getId_di() {
        return id_di;
    }

    public void setId_di(DocumentosidentificacionesEntity id_di) {
        this.id_di = id_di;
    }
}
