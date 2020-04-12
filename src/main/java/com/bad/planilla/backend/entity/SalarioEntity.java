package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "salarios", schema = "public", catalog = "dfckhqghp2ho34")
public class SalarioEntity {
    private int idSalario;
    private BigDecimal desde;
    private BigDecimal hasta;
    private boolean estado;

    @Id
    @Column(name = "id_salario")
    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
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

        SalarioEntity that = (SalarioEntity) o;

        if (idSalario != that.idSalario) return false;
        if (estado != that.estado) return false;
        if (desde != null ? !desde.equals(that.desde) : that.desde != null) return false;
        if (hasta != null ? !hasta.equals(that.hasta) : that.hasta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSalario;
        result = 31 * result + (desde != null ? desde.hashCode() : 0);
        result = 31 * result + (hasta != null ? hasta.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
