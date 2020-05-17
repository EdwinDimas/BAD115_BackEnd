package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "unidadesorganizacionales", schema = "public", catalog = "dfckhqghp2ho34")
public class UnidadesorganizacionalesEntity {
    private int idUnidadorganizacional;
    private Integer unidadOrganizacionalSuperior;
    private String nombre;
    private boolean unidadmayor;
    private EmpresasEntity id_empresa;
    private boolean estado;

    @Id
    @Column(name = "id_unidadorganizacional", nullable = false)
    public int getIdUnidadorganizacional() {
        return idUnidadorganizacional;
    }
    //Aun no unidadesorganizacionales
    @SequenceGenerator(name = "unidadesorganizacionales_id_seq", sequenceName = "unidadesorganizacionales_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidadesorganizacionales_id_seq")
    public void setIdUnidadorganizacional(int idUnidadorganizacional) {
        this.idUnidadorganizacional = idUnidadorganizacional;
    }

    @Basic
    @Column(name = "uni_id_unidadorganizacional", nullable = true)
    public Integer getUnidadOrganizacionalSuperior() {
        return unidadOrganizacionalSuperior;
    }

    public void setUnidadOrganizacionalSuperior(Integer unidadOrganizacionalSuperior) {
        this.unidadOrganizacionalSuperior = unidadOrganizacionalSuperior;
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
    @Column(name = "unidadmayor", nullable = false)
    public boolean isUnidadmayor() {
        return unidadmayor;
    }

    public void setUnidadmayor(boolean unidadmayor) {
        this.unidadmayor = unidadmayor;
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
        UnidadesorganizacionalesEntity that = (UnidadesorganizacionalesEntity) o;
        return idUnidadorganizacional == that.idUnidadorganizacional &&
                unidadmayor == that.unidadmayor &&
                Objects.equals(unidadOrganizacionalSuperior, that.unidadOrganizacionalSuperior) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUnidadorganizacional, unidadOrganizacionalSuperior, nombre, unidadmayor);
    }

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    public EmpresasEntity getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(EmpresasEntity id_empresa) {
        this.id_empresa = id_empresa;
    }
}
