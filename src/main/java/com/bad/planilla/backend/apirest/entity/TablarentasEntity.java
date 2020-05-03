package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tablarentas", schema = "public", catalog = "dfckhqghp2ho34")
public class TablarentasEntity {
    private int idRenta;
    private BigDecimal desde;
    private BigDecimal hasta;
    private BigDecimal porcentajeaplicar;
    private String tiporetencion;
    private boolean estado;

    @Id
    @Column(name = "id_renta", nullable = false)
    public int getIdRenta() {
        return idRenta;
    }

    public void setIdRenta(int idRenta) {
        this.idRenta = idRenta;
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
    @Column(name = "porcentajeaplicar", nullable = false, precision = 2)
    public BigDecimal getPorcentajeaplicar() {
        return porcentajeaplicar;
    }

    public void setPorcentajeaplicar(BigDecimal porcentajeaplicar) {
        this.porcentajeaplicar = porcentajeaplicar;
    }

    @Basic
    @Column(name = "tiporetencion", nullable = false, length = 10)
    public String getTiporetencion() {
        return tiporetencion;
    }

    public void setTiporetencion(String tiporetencion) {
        this.tiporetencion = tiporetencion;
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
        TablarentasEntity that = (TablarentasEntity) o;
        return idRenta == that.idRenta &&
                estado == that.estado &&
                Objects.equals(desde, that.desde) &&
                Objects.equals(hasta, that.hasta) &&
                Objects.equals(porcentajeaplicar, that.porcentajeaplicar) &&
                Objects.equals(tiporetencion, that.tiporetencion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRenta, desde, hasta, porcentajeaplicar, tiporetencion, estado);
    }
}
