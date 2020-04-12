package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "catalogodescuentos", schema = "public", catalog = "dfckhqghp2ho34")
public class CatalogoDescuentoEntity {
    private int idCaralogodescuento;
    private String acronimo;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_caralogodescuento")
    public int getIdCaralogodescuento() {
        return idCaralogodescuento;
    }

    public void setIdCaralogodescuento(int idCaralogodescuento) {
        this.idCaralogodescuento = idCaralogodescuento;
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

        CatalogoDescuentoEntity that = (CatalogoDescuentoEntity) o;

        if (idCaralogodescuento != that.idCaralogodescuento) return false;
        if (estado != that.estado) return false;
        if (acronimo != null ? !acronimo.equals(that.acronimo) : that.acronimo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCaralogodescuento;
        result = 31 * result + (acronimo != null ? acronimo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
