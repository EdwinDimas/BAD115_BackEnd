package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "empresas", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpresasEntity {
    private int idEmpresa;
    private String representante;
    private String nit;
    private String nic;
    private String paginaweb;
    private String telefono;
    private String email;
    private String page;
    private DireccionesEntity id_direccion;
    private boolean estado;

    @Id
    @Column(name = "id_empresa", nullable = false)
    @SequenceGenerator(name="empresa_id_seq",sequenceName = "empresas_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empresa_id_seq")
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "representante", nullable = false, length = 100)
    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Basic
    @Column(name = "nit", nullable = false, length = 20)
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Basic
    @Column(name = "nic", nullable = false, length = 20)
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Basic
    @Column(name = "paginaweb", nullable = false, length = 100)
    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    @Basic
    @Column(name = "telefono", nullable = false, length = 15)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "page", nullable = false, length = 50)
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
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
        EmpresasEntity that = (EmpresasEntity) o;
        return idEmpresa == that.idEmpresa &&
                Objects.equals(representante, that.representante) &&
                Objects.equals(nit, that.nit) &&
                Objects.equals(nic, that.nic) &&
                Objects.equals(paginaweb, that.paginaweb) &&
                Objects.equals(telefono, that.telefono) &&
                Objects.equals(email, that.email) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, representante, nit, nic, paginaweb, telefono, email, page);
    }

    @ManyToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    public DireccionesEntity getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(DireccionesEntity id_direccion) {
        this.id_direccion = id_direccion;
    }
}
