package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "documentosidentificaciones", schema = "public", catalog = "dfckhqghp2ho34")
public class DocumentoIdentificacionEntity {
    private int idDi;
    private String acronimoDi;
    private String nombre;
    private String formatoregex;
    private boolean estado;
    private Collection<DocumentoEmpleadoEntity> documentosempleadosByIdDi;

    @Id
    @Column(name = "id_di")
    public int getIdDi() {
        return idDi;
    }

    public void setIdDi(int idDi) {
        this.idDi = idDi;
    }

    @Basic
    @Column(name = "acronimo_di")
    public String getAcronimoDi() {
        return acronimoDi;
    }

    public void setAcronimoDi(String acronimoDi) {
        this.acronimoDi = acronimoDi;
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
    @Column(name = "formatoregex")
    public String getFormatoregex() {
        return formatoregex;
    }

    public void setFormatoregex(String formatoregex) {
        this.formatoregex = formatoregex;
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

        DocumentoIdentificacionEntity that = (DocumentoIdentificacionEntity) o;

        if (idDi != that.idDi) return false;
        if (estado != that.estado) return false;
        if (acronimoDi != null ? !acronimoDi.equals(that.acronimoDi) : that.acronimoDi != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (formatoregex != null ? !formatoregex.equals(that.formatoregex) : that.formatoregex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDi;
        result = 31 * result + (acronimoDi != null ? acronimoDi.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (formatoregex != null ? formatoregex.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "documentosidentificacionesByIdDi")
    public Collection<DocumentoEmpleadoEntity> getDocumentosempleadosByIdDi() {
        return documentosempleadosByIdDi;
    }

    public void setDocumentosempleadosByIdDi(Collection<DocumentoEmpleadoEntity> documentosempleadosByIdDi) {
        this.documentosempleadosByIdDi = documentosempleadosByIdDi;
    }
}
