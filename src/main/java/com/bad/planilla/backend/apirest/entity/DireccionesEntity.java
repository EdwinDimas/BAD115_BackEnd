package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "direcciones", schema = "public", catalog = "dfckhqghp2ho34")
public class DireccionesEntity {
    private int idDireccion;
    private String colonia;
    private String descripcion;
    private DepartmentosEntity id_departmento;
    private MunicipiosEntity id_municipio;
    private boolean estado;

    @Id
    @Column(name = "id_direccion", nullable = false)
    @SequenceGenerator(name="direccion_id_seq",sequenceName = "direcciones_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "direccion_id_seq")
    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Basic
    @Column(name = "colonia", nullable = false, length = 50)
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        DireccionesEntity that = (DireccionesEntity) o;
        return idDireccion == that.idDireccion &&
                Objects.equals(colonia, that.colonia) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, colonia, descripcion);
    }

    @ManyToOne
    @JoinColumn(name = "id_departmento", referencedColumnName = "id_departmento")
    public DepartmentosEntity getId_departmento() {
        return id_departmento;
    }

    public void setId_departmento(DepartmentosEntity id_departmento) {
        this.id_departmento = id_departmento;
    }

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    public MunicipiosEntity getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(MunicipiosEntity id_municipio) {
        this.id_municipio = id_municipio;
    }
}
