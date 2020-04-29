package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "unidadesorganizacionales", schema = "public", catalog = "dfckhqghp2ho34")
public class UnidadOrganizacionalEntity {
    private int idUnidadorganizacional;
    private Integer idEmpresa;
    private Integer uniIdUnidadorganizacional;
    private String nombre;
    private boolean unidadmayor;
    private boolean estado;
    private Collection<CentroCostoEntity> centroscostosByIdUnidadorganizacional;
    private Collection<EmpleadoEntity> empleadosByIdUnidadorganizacional;
    private EmpresaEntity empresasByIdEmpresa;
    private UnidadOrganizacionalEntity unidadesorganizacionalesByUniIdUnidadorganizacional;
    private Collection<UnidadOrganizacionalEntity> unidadesorganizacionalesByIdUnidadorganizacional;

    @Id
    @Column(name = "id_unidadorganizacional")
    public int getIdUnidadorganizacional() {
        return idUnidadorganizacional;
    }

    public void setIdUnidadorganizacional(int idUnidadorganizacional) {
        this.idUnidadorganizacional = idUnidadorganizacional;
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
    @Column(name = "uni_id_unidadorganizacional")
    public Integer getUniIdUnidadorganizacional() {
        return uniIdUnidadorganizacional;
    }

    public void setUniIdUnidadorganizacional(Integer uniIdUnidadorganizacional) {
        this.uniIdUnidadorganizacional = uniIdUnidadorganizacional;
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
    @Column(name = "unidadmayor")
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

        UnidadOrganizacionalEntity that = (UnidadOrganizacionalEntity) o;

        if (idUnidadorganizacional != that.idUnidadorganizacional) return false;
        if (unidadmayor != that.unidadmayor) return false;
        if (estado != that.estado) return false;
        if (idEmpresa != null ? !idEmpresa.equals(that.idEmpresa) : that.idEmpresa != null) return false;
        if (uniIdUnidadorganizacional != null ? !uniIdUnidadorganizacional.equals(that.uniIdUnidadorganizacional) : that.uniIdUnidadorganizacional != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUnidadorganizacional;
        result = 31 * result + (idEmpresa != null ? idEmpresa.hashCode() : 0);
        result = 31 * result + (uniIdUnidadorganizacional != null ? uniIdUnidadorganizacional.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (unidadmayor ? 1 : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "unidadesorganizacionalesByIdUnidadorganizacional")
    public Collection<CentroCostoEntity> getCentroscostosByIdUnidadorganizacional() {
        return centroscostosByIdUnidadorganizacional;
    }

    public void setCentroscostosByIdUnidadorganizacional(Collection<CentroCostoEntity> centroscostosByIdUnidadorganizacional) {
        this.centroscostosByIdUnidadorganizacional = centroscostosByIdUnidadorganizacional;
    }

    @OneToMany(mappedBy = "unidadesorganizacionalesByIdUnidadorganizacional")
    public Collection<EmpleadoEntity> getEmpleadosByIdUnidadorganizacional() {
        return empleadosByIdUnidadorganizacional;
    }

    public void setEmpleadosByIdUnidadorganizacional(Collection<EmpleadoEntity> empleadosByIdUnidadorganizacional) {
        this.empleadosByIdUnidadorganizacional = empleadosByIdUnidadorganizacional;
    }

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    public EmpresaEntity getEmpresasByIdEmpresa() {
        return empresasByIdEmpresa;
    }

    public void setEmpresasByIdEmpresa(EmpresaEntity empresasByIdEmpresa) {
        this.empresasByIdEmpresa = empresasByIdEmpresa;
    }

    @ManyToOne
    @JoinColumn(name = "uni_id_unidadorganizacional", referencedColumnName = "id_unidadorganizacional")
    public UnidadOrganizacionalEntity getUnidadesorganizacionalesByUniIdUnidadorganizacional() {
        return unidadesorganizacionalesByUniIdUnidadorganizacional;
    }

    public void setUnidadesorganizacionalesByUniIdUnidadorganizacional(UnidadOrganizacionalEntity unidadesorganizacionalesByUniIdUnidadorganizacional) {
        this.unidadesorganizacionalesByUniIdUnidadorganizacional = unidadesorganizacionalesByUniIdUnidadorganizacional;
    }

    @OneToMany(mappedBy = "unidadesorganizacionalesByUniIdUnidadorganizacional")
    public Collection<UnidadOrganizacionalEntity> getUnidadesorganizacionalesByIdUnidadorganizacional() {
        return unidadesorganizacionalesByIdUnidadorganizacional;
    }

    public void setUnidadesorganizacionalesByIdUnidadorganizacional(Collection<UnidadOrganizacionalEntity> unidadesorganizacionalesByIdUnidadorganizacional) {
        this.unidadesorganizacionalesByIdUnidadorganizacional = unidadesorganizacionalesByIdUnidadorganizacional;
    }
}
