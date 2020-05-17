package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "salarios", schema = "public", catalog = "dfckhqghp2ho34")
public class SalariosEntity {
    private int idSalario;
    private BigDecimal desde;
    private BigDecimal hasta;
    private boolean estado;

    @Id
    @Column(name = "id_salario", nullable = false)
    @SequenceGenerator(name="salarios_id_seq",sequenceName = "salarios_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "salarios_id_seq")
    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
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
        SalariosEntity that = (SalariosEntity) o;
        return idSalario == that.idSalario &&
                Objects.equals(desde, that.desde) &&
                Objects.equals(hasta, that.hasta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSalario, desde, hasta);
    }
}
