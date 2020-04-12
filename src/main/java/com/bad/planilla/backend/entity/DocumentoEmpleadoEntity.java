package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "documentosempleados", schema = "public", catalog = "dfckhqghp2ho34")
public class DocumentoEmpleadoEntity {
    private int idDocumentoempleado;
    private String numerodocumento;
    private Date fecharegistro;
    private boolean estado;

    @Id
    @Column(name = "id_documentoempleado")
    public int getIdDocumentoempleado() {
        return idDocumentoempleado;
    }

    public void setIdDocumentoempleado(int idDocumentoempleado) {
        this.idDocumentoempleado = idDocumentoempleado;
    }

    @Basic
    @Column(name = "numerodocumento")
    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
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

        DocumentoEmpleadoEntity that = (DocumentoEmpleadoEntity) o;

        if (idDocumentoempleado != that.idDocumentoempleado) return false;
        if (estado != that.estado) return false;
        if (numerodocumento != null ? !numerodocumento.equals(that.numerodocumento) : that.numerodocumento != null)
            return false;
        if (fecharegistro != null ? !fecharegistro.equals(that.fecharegistro) : that.fecharegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDocumentoempleado;
        result = 31 * result + (numerodocumento != null ? numerodocumento.hashCode() : 0);
        result = 31 * result + (fecharegistro != null ? fecharegistro.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
