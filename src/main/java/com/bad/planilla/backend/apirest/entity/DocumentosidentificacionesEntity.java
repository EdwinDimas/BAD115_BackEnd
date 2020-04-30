package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "documentosidentificaciones", schema = "public", catalog = "dfckhqghp2ho34")
public class DocumentosidentificacionesEntity {
    private int idDi;
    private String acronimoDi;
    private String nombre;
    private String formatoregex;
    private boolean estado;

    @Id
    @Column(name = "id_di", nullable = false)
    public int getIdDi() {
        return idDi;
    }

    public void setIdDi(int idDi) {
        this.idDi = idDi;
    }

    @Basic
    @Column(name = "acronimo_di", nullable = false, length = 20)
    public String getAcronimoDi() {
        return acronimoDi;
    }

    public void setAcronimoDi(String acronimoDi) {
        this.acronimoDi = acronimoDi;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "formatoregex", nullable = false, length = 100)
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
        DocumentosidentificacionesEntity that = (DocumentosidentificacionesEntity) o;
        return idDi == that.idDi &&
                Objects.equals(acronimoDi, that.acronimoDi) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(formatoregex, that.formatoregex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDi, acronimoDi, nombre, formatoregex);
    }
}
