package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "catalogocomisiones", schema = "public", catalog = "dfckhqghp2ho34")
public class CatalogocomisionesEntity {
    private int idComision;
    private BigDecimal desde;
    private BigDecimal hasta;
    private BigDecimal porcentajecomision;
    private boolean estado;

    @Id
    @Column(name = "id_comision", nullable = false)
    public int getIdComision() {
        return idComision;
    }

    public void setIdComision(int idComision) {
        this.idComision = idComision;
    }

    @Basic
    @Column(name = "desde", nullable = false, precision = 2)
    public BigDecimal getDesde() {
        return desde;
    }

    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }

    @Basic
    @Column(name = "hasta", nullable = false, precision = 2)
    public BigDecimal getHasta() {
        return hasta;
    }

    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }

    @Basic
    @Column(name = "porcentajecomision", nullable = false, precision = 2)
    public BigDecimal getPorcentajecomision() {
        return porcentajecomision;
    }

    public void setPorcentajecomision(BigDecimal porcentajecomision) {
        this.porcentajecomision = porcentajecomision;
    }

    @Basic
    @Column(name = "estado", nullable = false)
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
        CatalogocomisionesEntity that = (CatalogocomisionesEntity) o;
        return idComision == that.idComision &&
                estado == that.estado &&
                Objects.equals(desde, that.desde) &&
                Objects.equals(hasta, that.hasta) &&
                Objects.equals(porcentajecomision, that.porcentajecomision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComision, desde, hasta, porcentajecomision, estado);
    }
}
