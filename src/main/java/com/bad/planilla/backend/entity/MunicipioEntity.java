package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "municipios", schema = "public", catalog = "dfckhqghp2ho34")
public class MunicipioEntity {
    private int idMunicipio;
    private Integer idDepartmento;
    private String nombre;
    private Collection<DireccionEntity> direccionesByIdMunicipio;
    private DepartmentoEntity departmentosByIdDepartmento;

    @Id
    @Column(name = "id_municipio")
    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Basic
    @Column(name = "id_departmento")
    public Integer getIdDepartmento() {
        return idDepartmento;
    }

    public void setIdDepartmento(Integer idDepartmento) {
        this.idDepartmento = idDepartmento;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MunicipioEntity that = (MunicipioEntity) o;

        if (idMunicipio != that.idMunicipio) return false;
        if (idDepartmento != null ? !idDepartmento.equals(that.idDepartmento) : that.idDepartmento != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMunicipio;
        result = 31 * result + (idDepartmento != null ? idDepartmento.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "municipiosByIdMunicipio")
    public Collection<DireccionEntity> getDireccionesByIdMunicipio() {
        return direccionesByIdMunicipio;
    }

    public void setDireccionesByIdMunicipio(Collection<DireccionEntity> direccionesByIdMunicipio) {
        this.direccionesByIdMunicipio = direccionesByIdMunicipio;
    }

    @ManyToOne
    @JoinColumn(name = "id_departmento", referencedColumnName = "id_departmento", insertable=false, updatable=false)
    public DepartmentoEntity getDepartmentosByIdDepartmento() {
        return departmentosByIdDepartmento;
    }

    public void setDepartmentosByIdDepartmento(DepartmentoEntity departmentosByIdDepartmento) {
        this.departmentosByIdDepartmento = departmentosByIdDepartmento;
    }
}
