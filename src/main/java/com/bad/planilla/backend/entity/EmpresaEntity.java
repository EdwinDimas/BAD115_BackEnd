package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "empresas", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpresaEntity {
    private int idEmpresa;
    private String representante;
    private String nit;
    private String nic;
    private String paginaweb;
    private String telefono;
    private String email;
    private String page;
    private Collection<DireccionEntity> direccionesByIdEmpresa;
    private Collection<UnidadOrganizacionalEntity> unidadesorganizacionalesByIdEmpresa;

    @Id
    @Column(name = "id_empresa")
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "representante")
    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Basic
    @Column(name = "nit")
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Basic
    @Column(name = "nic")
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Basic
    @Column(name = "paginaweb")
    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "page")
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpresaEntity that = (EmpresaEntity) o;

        if (idEmpresa != that.idEmpresa) return false;
        if (representante != null ? !representante.equals(that.representante) : that.representante != null)
            return false;
        if (nit != null ? !nit.equals(that.nit) : that.nit != null) return false;
        if (nic != null ? !nic.equals(that.nic) : that.nic != null) return false;
        if (paginaweb != null ? !paginaweb.equals(that.paginaweb) : that.paginaweb != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (page != null ? !page.equals(that.page) : that.page != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpresa;
        result = 31 * result + (representante != null ? representante.hashCode() : 0);
        result = 31 * result + (nit != null ? nit.hashCode() : 0);
        result = 31 * result + (nic != null ? nic.hashCode() : 0);
        result = 31 * result + (paginaweb != null ? paginaweb.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (page != null ? page.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "empresasByIdEmpresa")
    public Collection<DireccionEntity> getDireccionesByIdEmpresa() {
        return direccionesByIdEmpresa;
    }

    public void setDireccionesByIdEmpresa(Collection<DireccionEntity> direccionesByIdEmpresa) {
        this.direccionesByIdEmpresa = direccionesByIdEmpresa;
    }

    @OneToMany(mappedBy = "empresasByIdEmpresa")
    public Collection<UnidadOrganizacionalEntity> getUnidadesorganizacionalesByIdEmpresa() {
        return unidadesorganizacionalesByIdEmpresa;
    }

    public void setUnidadesorganizacionalesByIdEmpresa(Collection<UnidadOrganizacionalEntity> unidadesorganizacionalesByIdEmpresa) {
        this.unidadesorganizacionalesByIdEmpresa = unidadesorganizacionalesByIdEmpresa;
    }
}
