package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "puestostrabajos", schema = "public", catalog = "dfckhqghp2ho34")
public class PuestosTrabajosEntity {
    private int idPuestotrabajo;
    private String nombre;
    private String descripcion;
    private Collection<SalariosPuestosTrabajosEntity> salarioPuestoTrabajo;
    private boolean estado;

    @Id
    @Column(name = "id_puestotrabajo", nullable = false)
    @SequenceGenerator(name = "puestostrabajos_id_seq", sequenceName = "puestostrabajos_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "puestostrabajos_id_seq")
    public int getIdPuestotrabajo() {
        return idPuestotrabajo;
    }

    public void setIdPuestotrabajo(int idPuestotrabajo) {
        this.idPuestotrabajo = idPuestotrabajo;
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
    @Column(name = "descripcion", nullable = false, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "estado")



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuestosTrabajosEntity that = (PuestosTrabajosEntity) o;
        return idPuestotrabajo == that.idPuestotrabajo &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPuestotrabajo, nombre, descripcion);
    }

    @OneToMany(mappedBy = "id_puestotrabajo")
    public Collection<SalariosPuestosTrabajosEntity> getSalarioPuestoTrabajo() {
        return salarioPuestoTrabajo;
    }

    public void setSalarioPuestoTrabajo(Collection<SalariosPuestosTrabajosEntity> salarioPuestoTrabajo) {
        this.salarioPuestoTrabajo = salarioPuestoTrabajo;
    }
}
