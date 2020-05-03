package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "descuentosotros", schema = "public", catalog = "dfckhqghp2ho34")
public class DescuentosotrosEntity {
    private int idDescuentootros;
    private String acronimo;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_descuentootros", nullable = false)
    public int getIdDescuentootros() {
        return idDescuentootros;
    }

    public void setIdDescuentootros(int idDescuentootros) {
        this.idDescuentootros = idDescuentootros;
    }

    @Basic
    @Column(name = "acronimo", nullable = false, length = 20)
    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
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
        DescuentosotrosEntity that = (DescuentosotrosEntity) o;
        return idDescuentootros == that.idDescuentootros &&
                Objects.equals(acronimo, that.acronimo) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDescuentootros, acronimo, nombre);
    }
}
