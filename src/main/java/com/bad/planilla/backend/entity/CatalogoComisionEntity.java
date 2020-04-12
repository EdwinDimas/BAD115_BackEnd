package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "catalogocomisiones", schema = "public", catalog = "dfckhqghp2ho34")
public class CatalogoComisionEntity {
    private int idComision;
    private BigDecimal desde;
    private BigDecimal hasta;
    private BigDecimal porcentajecomision;
    private boolean estado;

    @Id
    @Column(name = "id_comision")
    public int getIdComision() {
        return idComision;
    }

    public void setIdComision(int idComision) {
        this.idComision = idComision;
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
    @Column(name = "porcentajecomision")
    public BigDecimal getPorcentajecomision() {
        return porcentajecomision;
    }

    public void setPorcentajecomision(BigDecimal porcentajecomision) {
        this.porcentajecomision = porcentajecomision;
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

        CatalogoComisionEntity that = (CatalogoComisionEntity) o;

        if (idComision != that.idComision) return false;
        if (estado != that.estado) return false;
        if (desde != null ? !desde.equals(that.desde) : that.desde != null) return false;
        if (hasta != null ? !hasta.equals(that.hasta) : that.hasta != null) return false;
        if (porcentajecomision != null ? !porcentajecomision.equals(that.porcentajecomision) : that.porcentajecomision != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idComision;
        result = 31 * result + (desde != null ? desde.hashCode() : 0);
        result = 31 * result + (hasta != null ? hasta.hashCode() : 0);
        result = 31 * result + (porcentajecomision != null ? porcentajecomision.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
