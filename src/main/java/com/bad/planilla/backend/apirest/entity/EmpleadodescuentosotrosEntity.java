package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "empleadodescuentosotros", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadodescuentosotrosEntity {
    private int idDescotros;
    private BigDecimal descuento;
    private BigDecimal desde;
    private BigDecimal hasta;
    private BigDecimal monto;
    private DescuentosotrosEntity id_descuentootros;
    private EmpleadosEntity id_empleado;
    private boolean estado;

    @Id
    @Column(name = "id_descotros", nullable = false)
    public int getIdDescotros() {
        return idDescotros;
    }

    public void setIdDescotros(int idDescotros) {
        this.idDescotros = idDescotros;
    }

    @Basic
    @Column(name = "descuento", nullable = false, precision = 2)
    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
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
    @Column(name = "monto", nullable = false, precision = 2)
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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
        EmpleadodescuentosotrosEntity that = (EmpleadodescuentosotrosEntity) o;
        return idDescotros == that.idDescotros &&
                Objects.equals(descuento, that.descuento) &&
                Objects.equals(desde, that.desde) &&
                Objects.equals(hasta, that.hasta) &&
                Objects.equals(monto, that.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDescotros, descuento, desde, hasta, monto);
    }

    @ManyToOne
    @JoinColumn(name = "id_descuentootros", referencedColumnName = "id_descuentootros")
    public DescuentosotrosEntity getId_descuentootros() {
        return id_descuentootros;
    }

    public void setId_descuentootros(DescuentosotrosEntity id_descuentootros) {
        this.id_descuentootros = id_descuentootros;
    }

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    public EmpleadosEntity getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(EmpleadosEntity id_empleado) {
        this.id_empleado = id_empleado;
    }
}
