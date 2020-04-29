package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "centroscosto", schema = "public", catalog = "dfckhqghp2ho34")
public class CentroCostoEntity {
    private int idCosto;
    private Integer idUnidadorganizacional;
    private BigDecimal monto;
    private BigDecimal montoactual;
    private Date periodo;
    private boolean estado;
    private UnidadOrganizacionalEntity unidadesorganizacionalesByIdUnidadorganizacional;

    @Id
    @Column(name = "id_costo")
    public int getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(int idCosto) {
        this.idCosto = idCosto;
    }

    @Basic
    @Column(name = "id_unidadorganizacional")
    public Integer getIdUnidadorganizacional() {
        return idUnidadorganizacional;
    }

    public void setIdUnidadorganizacional(Integer idUnidadorganizacional) {
        this.idUnidadorganizacional = idUnidadorganizacional;
    }

    @Basic
    @Column(name = "monto")
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "montoactual")
    public BigDecimal getMontoactual() {
        return montoactual;
    }

    public void setMontoactual(BigDecimal montoactual) {
        this.montoactual = montoactual;
    }

    @Basic
    @Column(name = "periodo")
    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
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

        CentroCostoEntity that = (CentroCostoEntity) o;

        if (idCosto != that.idCosto) return false;
        if (estado != that.estado) return false;
        if (idUnidadorganizacional != null ? !idUnidadorganizacional.equals(that.idUnidadorganizacional) : that.idUnidadorganizacional != null)
            return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (montoactual != null ? !montoactual.equals(that.montoactual) : that.montoactual != null) return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCosto;
        result = 31 * result + (idUnidadorganizacional != null ? idUnidadorganizacional.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (montoactual != null ? montoactual.hashCode() : 0);
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_unidadorganizacional", referencedColumnName = "id_unidadorganizacional")
    public UnidadOrganizacionalEntity getUnidadesorganizacionalesByIdUnidadorganizacional() {
        return unidadesorganizacionalesByIdUnidadorganizacional;
    }

    public void setUnidadesorganizacionalesByIdUnidadorganizacional(UnidadOrganizacionalEntity unidadesorganizacionalesByIdUnidadorganizacional) {
        this.unidadesorganizacionalesByIdUnidadorganizacional = unidadesorganizacionalesByIdUnidadorganizacional;
    }
}
