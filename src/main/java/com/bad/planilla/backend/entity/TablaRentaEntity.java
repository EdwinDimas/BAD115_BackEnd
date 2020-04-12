package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tablasrenta", schema = "public", catalog = "dfckhqghp2ho34")
public class TablaRentaEntity {
    private int idRenta;
    private BigDecimal desde;
    private BigDecimal hasta;
    private BigDecimal porcentajeaplicar;
    private String tiporetencion;
    private boolean estado;

    @Id
    @Column(name = "id_renta")
    public int getIdRenta() {
        return idRenta;
    }

    public void setIdRenta(int idRenta) {
        this.idRenta = idRenta;
    }

    @Basic
    @Column(name = "desde")
    public BigDecimal getDesde() {
        return desde;
    }

    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }

    @Basic
    @Column(name = "hasta")
    public BigDecimal getHasta() {
        return hasta;
    }

    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }

    @Basic
    @Column(name = "porcentajeaplicar")
    public BigDecimal getPorcentajeaplicar() {
        return porcentajeaplicar;
    }

    public void setPorcentajeaplicar(BigDecimal porcentajeaplicar) {
        this.porcentajeaplicar = porcentajeaplicar;
    }

    @Basic
    @Column(name = "tiporetencion")
    public String getTiporetencion() {
        return tiporetencion;
    }

    public void setTiporetencion(String tiporetencion) {
        this.tiporetencion = tiporetencion;
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

        TablaRentaEntity that = (TablaRentaEntity) o;

        if (idRenta != that.idRenta) return false;
        if (estado != that.estado) return false;
        if (desde != null ? !desde.equals(that.desde) : that.desde != null) return false;
        if (hasta != null ? !hasta.equals(that.hasta) : that.hasta != null) return false;
        if (porcentajeaplicar != null ? !porcentajeaplicar.equals(that.porcentajeaplicar) : that.porcentajeaplicar != null)
            return false;
        if (tiporetencion != null ? !tiporetencion.equals(that.tiporetencion) : that.tiporetencion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRenta;
        result = 31 * result + (desde != null ? desde.hashCode() : 0);
        result = 31 * result + (hasta != null ? hasta.hashCode() : 0);
        result = 31 * result + (porcentajeaplicar != null ? porcentajeaplicar.hashCode() : 0);
        result = 31 * result + (tiporetencion != null ? tiporetencion.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
