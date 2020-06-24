package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "empleadosdescuentos", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadosDescuentosEntity {
    private int idDescotros;
    private BigDecimal descuento;
    private BigDecimal desde;
    private BigDecimal hasta;
    private BigDecimal monto;
    private DescuentosEntity id_descuento;
    private EmpleadosEntity id_empleado;
    private boolean estado;

    @Id
    @Column(name = "id_descotros", nullable = false)
    @SequenceGenerator(name = "empleadodescuento_id_seq", sequenceName = "empleadodescuento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleadodescuento_id_seq")
    public int getIdDescotros() {
        return idDescotros;
    }

    public void setIdDescotros(int idDescotros) {
        this.idDescotros = idDescotros;
    }

    @Basic
    @Column(name = "descuento", precision = 2)
    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    @Basic
    @Column(name = "desde", precision = 2)
    public BigDecimal getDesde() {
        return desde;
    }

    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }

    @Basic
    @Column(name = "hasta", precision = 2)
    public BigDecimal getHasta() {
        return hasta;
    }

    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }

    @Basic
    @Column(name = "monto", precision = 2)
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
        EmpleadosDescuentosEntity that = (EmpleadosDescuentosEntity) o;
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
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    public DescuentosEntity getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(DescuentosEntity id_descuento) {
        this.id_descuento = id_descuento;
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
