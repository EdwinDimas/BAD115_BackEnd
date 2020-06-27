package com.bad.planilla.backend.apirest.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "boletapagofunction", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaPago {
    @Id
    @Column(name = "total_descuentos", nullable = true)
    private BigDecimal total_descuentos;
    @Column(name = "salario_base", nullable = true)
    private BigDecimal salario_base;
    @Column(name = "salario_nominal", nullable = true)
    private BigDecimal salario_nominal;
    @Column(name = "isss", nullable = true)
    private BigDecimal isss;
    @Column(name = "afp", nullable = true)
    private BigDecimal afp;
    @Column(name = "renta", nullable = true)
    private BigDecimal renta;
    @Column(name = "costo_hora", nullable = true)
    private BigDecimal costo_hora;
    @Column(name = "isss_empleador", nullable = true)
    private BigDecimal isss_empleador;
    @Column(name = "afp_empleador", nullable = true)
    private BigDecimal afp_empleador;
    @Column(name = "vacaciones", nullable = true)
    private BigDecimal vacaciones;
    @Column(name = "salario_a_cobrar", nullable = true)
    private BigDecimal salario_a_cobrar;

//    out total_descuentos numeric,
//    out salario_base numeric,
//    out salario_nominal numeric,
//    out isss numeric,
//    out afp numeric,
//    out renta numeric,
//    out costo_hora numeric,
//    out isss_empleador numeric,
//    out afp_empleador numeric,
//    out vacaciones numeric,
//    out salario_a_cobrar numeric

    public BigDecimal getTotal_descuentos() {
        return total_descuentos;
    }

    public void setTotal_descuentos(BigDecimal total_descuentos) {
        this.total_descuentos = total_descuentos;
    }

    public BigDecimal getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(BigDecimal salario_base) {
        this.salario_base = salario_base;
    }

    public BigDecimal getSalario_nominal() {
        return salario_nominal;
    }

    public void setSalario_nominal(BigDecimal salario_nominal) {
        this.salario_nominal = salario_nominal;
    }

    public BigDecimal getIsss() {
        return isss;
    }

    public void setIsss(BigDecimal isss) {
        this.isss = isss;
    }

    public BigDecimal getAfp() {
        return afp;
    }

    public void setAfp(BigDecimal afp) {
        this.afp = afp;
    }

    public BigDecimal getRenta() {
        return renta;
    }

    public void setRenta(BigDecimal renta) {
        this.renta = renta;
    }

    public BigDecimal getCosto_hora() {
        return costo_hora;
    }

    public void setCosto_hora(BigDecimal costo_hora) {
        this.costo_hora = costo_hora;
    }

    public BigDecimal getIsss_empleador() {
        return isss_empleador;
    }

    public void setIsss_empleador(BigDecimal isss_empleador) {
        this.isss_empleador = isss_empleador;
    }

    public BigDecimal getAfp_empleador() {
        return afp_empleador;
    }

    public void setAfp_empleador(BigDecimal afp_empleador) {
        this.afp_empleador = afp_empleador;
    }

    public BigDecimal getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(BigDecimal vacaciones) {
        this.vacaciones = vacaciones;
    }

    public BigDecimal getSalario_a_cobrar() {
        return salario_a_cobrar;
    }

    public void setSalario_a_cobrar(BigDecimal salario_a_cobrar) {
        this.salario_a_cobrar = salario_a_cobrar;
    }
}
