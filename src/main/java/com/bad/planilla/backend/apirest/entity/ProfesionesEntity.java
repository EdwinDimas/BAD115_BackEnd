package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "profesiones", schema = "public", catalog = "dfckhqghp2ho34")
public class ProfesionesEntity {
    private int idProfesion;
    private String acronimo;
    private String nombre;
    private boolean estado;

    @Id
    @Column(name = "id_profesion", nullable = false)
    @SequenceGenerator(name="profesion_id_seq", sequenceName = "profesiones_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesion_id_seq")
    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
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
        ProfesionesEntity that = (ProfesionesEntity) o;
        return idProfesion == that.idProfesion &&
                Objects.equals(acronimo, that.acronimo) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesion, acronimo, nombre);
    }
}
