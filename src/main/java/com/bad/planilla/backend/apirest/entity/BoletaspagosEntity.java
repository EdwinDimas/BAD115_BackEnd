package com.bad.planilla.backend.apirest.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

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
    private BigDecimal salarioBase;
    private BigDecimal salarioNeto;
    private EmpleadosEntity id_empleado;
    private CalendariostrabajosEntity calendario_trabajo;
    private Collection<DetalleboletaspagosEntity> detalleBoletaPago;
    private boolean estado;
    private int idEmpleado;
    private int idCalendario;

    @Id
    @Column(name = "id_boletapago", nullable = false)
    @SequenceGenerator(name = "boletapago_id_seq", sequenceName = "boletapago_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boletapago_id_seq")
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
    @Column(name = "salario_base", nullable = true, precision = 8)
    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }


    @Basic
    @Column(name = "salario_neto", nullable = true, precision = 8)
    public BigDecimal getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(BigDecimal salarioNeto) {
        this.salarioNeto = salarioNeto;
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
                Objects.equals(salarioBase, that.salarioBase) &&
                Objects.equals(salarioNeto, that.salarioNeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBoletapago, fecha, salarioBase, salarioNeto);
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
    @JoinColumn(name = "calendario_trabajo", referencedColumnName = "calendariotrabajo")
    public CalendariostrabajosEntity getCalendariotrabajo() {
        return calendario_trabajo;
    }

    public void setCalendariotrabajo(CalendariostrabajosEntity calendario_trabajo) {
        this.calendario_trabajo = calendario_trabajo;
    }


    @OneToMany(mappedBy = "id_boletapago")
    public Collection<DetalleboletaspagosEntity> getDetalleBoletaPago() {
        return detalleBoletaPago;
    }

    public void setDetalleBoletaPago(Collection<DetalleboletaspagosEntity> detalleBoletaPago) {
        this.detalleBoletaPago = detalleBoletaPago;
    }

    @Basic
    @Column(name = "id_emp")
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "id_calendario")
    public int getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }
}
