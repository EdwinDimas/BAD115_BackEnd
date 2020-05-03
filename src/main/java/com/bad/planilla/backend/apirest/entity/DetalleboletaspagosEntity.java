package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "detalleboletaspagos", schema = "public", catalog = "dfckhqghp2ho34")
public class DetalleboletaspagosEntity {
    private int idDetalleBoleta;
    private int movimientoId;
    private String tipoMovimiento;
    private BigDecimal preciohora;
    private BigDecimal horas;
    private BigDecimal monto;
    private BoletaspagosEntity id_boletapago;
    private boolean estado;

    @Id
    @Column(name = "id_detalle_boleta", nullable = false)
    public int getIdDetalleBoleta() {
        return idDetalleBoleta;
    }

    public void setIdDetalleBoleta(int idDetalleBoleta) {
        this.idDetalleBoleta = idDetalleBoleta;
    }

    @Basic
    @Column(name = "movimiento_id", nullable = false)
    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    @Basic
    @Column(name = "tipo_movimiento", nullable = false, length = 20)
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @Basic
    @Column(name = "preciohora", nullable = false, precision = 2)
    public BigDecimal getPreciohora() {
        return preciohora;
    }

    public void setPreciohora(BigDecimal preciohora) {
        this.preciohora = preciohora;
    }

    @Basic
    @Column(name = "horas", nullable = false, precision = 2)
    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
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
        DetalleboletaspagosEntity that = (DetalleboletaspagosEntity) o;
        return idDetalleBoleta == that.idDetalleBoleta &&
                movimientoId == that.movimientoId &&
                Objects.equals(tipoMovimiento, that.tipoMovimiento) &&
                Objects.equals(preciohora, that.preciohora) &&
                Objects.equals(horas, that.horas) &&
                Objects.equals(monto, that.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetalleBoleta, movimientoId, tipoMovimiento, preciohora, horas, monto);
    }

    @ManyToOne
    @JoinColumn(name = "id_boletapago", referencedColumnName = "id_boletapago")
    public BoletaspagosEntity getId_boletapago() {
        return id_boletapago;
    }

    public void setId_boletapago(BoletaspagosEntity id_boletapago) {
        this.id_boletapago = id_boletapago;
    }
}
