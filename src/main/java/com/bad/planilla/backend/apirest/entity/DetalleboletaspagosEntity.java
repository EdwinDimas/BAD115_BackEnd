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
    private boolean serviciosProfesionales;
    private BigDecimal renta;
    private BigDecimal isss;
    private BigDecimal isssEmpleador;
    private BigDecimal afp;
    private BigDecimal afpEmpleador;
    private BigDecimal pago;
    private BigDecimal otrosDescuentos;
    private int idBoletaPago;
    private BigDecimal horasExtra;
    private BigDecimal horasNocturnidad;
    private BigDecimal totalVentas;
    private BigDecimal bonos;
    private int diasFestivos;
    private boolean vacaciones;
    private BigDecimal comida;
    private int diasPerdidos;
    private BigDecimal horasADescontar;

    @Id
    @Column(name = "id_detalle_boleta", nullable = false)
    @SequenceGenerator(name = "detalleboletaspago_id_seq", sequenceName = "detalleboletaspago_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleboletaspago_id_seq")
    public int getIdDetalleBoleta() {
        return idDetalleBoleta;
    }

    public void setIdDetalleBoleta(int idDetalleBoleta) {
        this.idDetalleBoleta = idDetalleBoleta;
    }

    @Basic
    @Column(name = "movimiento_id", nullable = true)
    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    @Basic
    @Column(name = "tipo_movimiento", nullable = true, length = 20)
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @Basic
    @Column(name = "preciohora", nullable = true, precision = 2)
    public BigDecimal getPreciohora() {
        return preciohora;
    }

    public void setPreciohora(BigDecimal preciohora) {
        this.preciohora = preciohora;
    }

    @Basic
    @Column(name = "horas", nullable = true, precision = 2)
    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    @Basic
    @Column(name = "monto", nullable = true, precision = 2)
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

    @Basic
    @Column(name = "servicios_profesionales")
    public boolean isServiciosProfesionales() {
        return serviciosProfesionales;
    }

    public void setServiciosProfesionales(boolean serviciosProfesionales) {
        this.serviciosProfesionales = serviciosProfesionales;
    }

    @Basic
    @Column(name = "renta")
    public BigDecimal getRenta() {
        return renta;
    }

    public void setRenta(BigDecimal renta) {
        this.renta = renta;
    }

    @Basic
    @Column(name = "isss")
    public BigDecimal getIsss() {
        return isss;
    }

    public void setIsss(BigDecimal isss) {
        this.isss = isss;
    }

    @Basic
    @Column(name = "isss_empleador")
    public BigDecimal getIsssEmpleador() {
        return isssEmpleador;
    }

    public void setIsssEmpleador(BigDecimal isssEmpleador) {
        this.isssEmpleador = isssEmpleador;
    }

    @Basic
    @Column(name = "afp")
    public BigDecimal getAfp() {
        return afp;
    }

    public void setAfp(BigDecimal afp) {
        this.afp = afp;
    }

    @Basic
    @Column(name = "afp_empleador")
    public BigDecimal getAfpEmpleador() {
        return afpEmpleador;
    }

    public void setAfpEmpleador(BigDecimal afpEmpleador) {
        this.afpEmpleador = afpEmpleador;
    }

    @Basic
    @Column(name = "pago")
    public BigDecimal getPago() {
        return pago;
    }

    public void setPago(BigDecimal pago) {
        this.pago = pago;
    }

    @Basic
    @Column(name = "otros_descuentos")
    public BigDecimal getOtrosDescuentos() {
        return otrosDescuentos;
    }

    public void setOtrosDescuentos(BigDecimal otrosDescuentos) {
        this.otrosDescuentos = otrosDescuentos;
    }

    @Basic
    @Column(name = "id_boleta_pago")
    public int getIdBoletaPago() {
        return idBoletaPago;
    }

    public void setIdBoletaPago(int idBoletaPago) {
        this.idBoletaPago = idBoletaPago;
    }

    @Basic
    @Column(name = "horas_extra")
    public BigDecimal getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(BigDecimal horasExtra) {
        this.horasExtra = horasExtra;
    }

    @Basic
    @Column(name = "horas_nocturnidad")
    public BigDecimal getHorasNocturnidad() {
        return horasNocturnidad;
    }

    public void setHorasNocturnidad(BigDecimal horasNocturnidad) {
        this.horasNocturnidad = horasNocturnidad;
    }

    @Basic
    @Column(name = "total_ventas")
    public BigDecimal getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(BigDecimal totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Basic
    @Column(name = "bonos")
    public BigDecimal getBonos() {
        return bonos;
    }

    public void setBonos(BigDecimal bonos) {
        this.bonos = bonos;
    }

    @Basic
    @Column(name = "dias_festivos")
    public int getDiasFestivos() {
        return diasFestivos;
    }

    public void setDiasFestivos(int diasFestivos) {
        this.diasFestivos = diasFestivos;
    }

    @Basic
    @Column(name = "vacaciones")
    public boolean isVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(boolean vacaciones) {
        this.vacaciones = vacaciones;
    }

    @Basic
    @Column(name = "comida")
    public BigDecimal getComida() {
        return comida;
    }

    public void setComida(BigDecimal comida) {
        this.comida = comida;
    }

    @Basic
    @Column(name = "dias_perdidos")
    public int getDiasPerdidos() {
        return diasPerdidos;
    }

    public void setDiasPerdidos(int diasPerdidos) {
        this.diasPerdidos = diasPerdidos;
    }

    @Basic
    @Column(name = "horas_a_descontar")
    public BigDecimal getHorasADescontar() {
        return horasADescontar;
    }

    public void setHorasADescontar(BigDecimal horasADescontar) {
        this.horasADescontar = horasADescontar;
    }
}
