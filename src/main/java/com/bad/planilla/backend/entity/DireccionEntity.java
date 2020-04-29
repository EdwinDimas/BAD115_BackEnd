package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "direcciones", schema = "public", catalog = "dfckhqghp2ho34")
public class DireccionEntity {
    private int idDireccion;
    private Integer id;
    private Integer idDepartmento;
    private Integer idMunicipio;
    private Integer idEmpresa;
    private String colonia;
    private String descripcion;
    private boolean estado;
    private EmpleadoEntity empleadosById;
    private DepartmentoEntity departmentosByIdDepartmento;
    private MunicipioEntity municipiosByIdMunicipio;
    private EmpresaEntity empresasByIdEmpresa;

    @Id
    @Column(name = "id_direccion")
    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Basic
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "id_municipio")
    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Basic
    @Column(name = "id_empresa")
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "colonia")
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Basic
    @Column(name = "descripcion")
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

        DireccionEntity that = (DireccionEntity) o;

        if (idDireccion != that.idDireccion) return false;
        if (estado != that.estado) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idDepartmento != null ? !idDepartmento.equals(that.idDepartmento) : that.idDepartmento != null)
            return false;
        if (idMunicipio != null ? !idMunicipio.equals(that.idMunicipio) : that.idMunicipio != null) return false;
        if (idEmpresa != null ? !idEmpresa.equals(that.idEmpresa) : that.idEmpresa != null) return false;
        if (colonia != null ? !colonia.equals(that.colonia) : that.colonia != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDireccion;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (idDepartmento != null ? idDepartmento.hashCode() : 0);
        result = 31 * result + (idMunicipio != null ? idMunicipio.hashCode() : 0);
        result = 31 * result + (idEmpresa != null ? idEmpresa.hashCode() : 0);
        result = 31 * result + (colonia != null ? colonia.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    public EmpleadoEntity getEmpleadosById() {
        return empleadosById;
    }

    public void setEmpleadosById(EmpleadoEntity empleadosById) {
        this.empleadosById = empleadosById;
    }

    @ManyToOne
    @JoinColumn(name = "id_departmento", referencedColumnName = "id_departmento")
    public DepartmentoEntity getDepartmentosByIdDepartmento() {
        return departmentosByIdDepartmento;
    }

    public void setDepartmentosByIdDepartmento(DepartmentoEntity departmentosByIdDepartmento) {
        this.departmentosByIdDepartmento = departmentosByIdDepartmento;
    }

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    public MunicipioEntity getMunicipiosByIdMunicipio() {
        return municipiosByIdMunicipio;
    }

    public void setMunicipiosByIdMunicipio(MunicipioEntity municipiosByIdMunicipio) {
        this.municipiosByIdMunicipio = municipiosByIdMunicipio;
    }

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    public EmpresaEntity getEmpresasByIdEmpresa() {
        return empresasByIdEmpresa;
    }

    public void setEmpresasByIdEmpresa(EmpresaEntity empresasByIdEmpresa) {
        this.empresasByIdEmpresa = empresasByIdEmpresa;
    }
}
