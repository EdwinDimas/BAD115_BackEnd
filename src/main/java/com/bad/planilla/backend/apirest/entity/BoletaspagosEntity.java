package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "boletaspagos", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaspagosEntity {
    private int idBoletapago;
    private Date fecha;
    private BigDecimal salariobase;
    private BigDecimal salarioneto;
    private EmpleadosEntity id_empleado;
    private CalendariostrabajosEntity calendariotrabajo;
    private Collection<DetalleboletaspagosEntity> detalleBoletaPago;
    private boolean estado;

    @Id
    @Column(name = "id_boletapago", nullable = false)
    public int getIdBoletapago() {
        return idBoletapago;
    }

    public void setIdBoletapago(int idBoletapago) {
        this.idBoletapago = idBoletapago;
    }

    @Basic
    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "salariobase", nullable = false, precision = 8)
    public BigDecimal getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(BigDecimal salariobase) {
        this.salariobase = salariobase;
    }

    @Basic
    @Column(name = "salarioneto", nullable = false, precision = 8)
    public BigDecimal getSalarioneto() {
        return salarioneto;
    }

    public void setSalarioneto(BigDecimal salarioneto) {
        this.salarioneto = salarioneto;
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
        BoletaspagosEntity that = (BoletaspagosEntity) o;
        return idBoletapago == that.idBoletapago &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(salariobase, that.salariobase) &&
                Objects.equals(salarioneto, that.salarioneto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBoletapago, fecha, salariobase, salarioneto);
    }

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    public EmpleadosEntity getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(EmpleadosEntity id_empleado) {
        this.id_empleado = id_empleado;
    }


    @ManyToOne
    @JoinColumn(name = "calendariotrabajo", referencedColumnName = "calendariotrabajo")
    public CalendariostrabajosEntity getCalendariotrabajo() {
        return calendariotrabajo;
    }

    public void setCalendariotrabajo(CalendariostrabajosEntity calendariotrabajo) {
        this.calendariotrabajo = calendariotrabajo;
    }


    @OneToMany(mappedBy = "id_boletapago")
    public Collection<DetalleboletaspagosEntity> getDetalleBoletaPago() {
        return detalleBoletaPago;
    }

    public void setDetalleBoletaPago(Collection<DetalleboletaspagosEntity> detalleBoletaPago) {
        this.detalleBoletaPago = detalleBoletaPago;
    }
}
