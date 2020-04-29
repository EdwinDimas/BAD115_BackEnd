package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "catalogoingresos", schema = "public", catalog = "dfckhqghp2ho34")
public class CatalogoIngresoEntity {
    private int idIngresos;
    private String acronimoIngresos;
    private String nombre;
    private boolean estado;
    private Collection<BoletaIngresoEntity> boletasingresosByIdIngresos;

    @Id
    @Column(name = "id_ingresos")
    public int getIdIngresos() {
        return idIngresos;
    }

    public void setIdIngresos(int idIngresos) {
        this.idIngresos = idIngresos;
    }

    @Basic
    @Column(name = "acronimo_ingresos")
    public String getAcronimoIngresos() {
        return acronimoIngresos;
    }

    public void setAcronimoIngresos(String acronimoIngresos) {
        this.acronimoIngresos = acronimoIngresos;
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

        CatalogoIngresoEntity that = (CatalogoIngresoEntity) o;

        if (idIngresos != that.idIngresos) return false;
        if (estado != that.estado) return false;
        if (acronimoIngresos != null ? !acronimoIngresos.equals(that.acronimoIngresos) : that.acronimoIngresos != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idIngresos;
        result = 31 * result + (acronimoIngresos != null ? acronimoIngresos.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "catalogoingresosByIdIngresos")
    public Collection<BoletaIngresoEntity> getBoletasingresosByIdIngresos() {
        return boletasingresosByIdIngresos;
    }

    public void setBoletasingresosByIdIngresos(Collection<BoletaIngresoEntity> boletasingresosByIdIngresos) {
        this.boletasingresosByIdIngresos = boletasingresosByIdIngresos;
    }
}
