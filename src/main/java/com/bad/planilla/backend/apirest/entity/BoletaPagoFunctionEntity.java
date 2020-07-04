package com.bad.planilla.backend.apirest.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "boletapagofunction", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaPagoFunctionEntity {
    @Id
    @Column(name = "total_descuentos", nullable = true)
    private BigDecimal totalDescuentos;
    @Column(name="pk_empleado")
    private int key;
    @Column(name = "salario_base", nullable = true)
    private BigDecimal salarioBase;
    @Column(name = "salario_nominal", nullable = true)
    private BigDecimal salarioNominal;
    @Column(name = "isss", nullable = true)
    private BigDecimal isss;
    @Column(name = "afp", nullable = true)
    private BigDecimal afp;
    @Column(name = "renta", nullable = true)
    private BigDecimal renta;
    @Column(name = "costo_hora", nullable = true)
    private BigDecimal costoHora;
    @Column(name = "isss_empleador", nullable = true)
    private BigDecimal isssEmpleador;
    @Column(name = "afp_empleador", nullable = true)
    private BigDecimal afpEmpleador;
    @Column(name = "vacaciones", nullable = true)
    private BigDecimal vacaciones;
    @Column(name = "salario_a_cobrar", nullable = true)
    private BigDecimal salarioACobrar;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BigDecimal getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(BigDecimal totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public BigDecimal getSalarioNominal() {
        return salarioNominal;
    }

    public void setSalarioNominal(BigDecimal salarioNominal) {
        this.salarioNominal = salarioNominal;
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

    public BigDecimal getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(BigDecimal costoHora) {
        this.costoHora = costoHora;
    }

    public BigDecimal getIsssEmpleador() {
        return isssEmpleador;
    }

    public void setIsssEmpleador(BigDecimal isssEmpleador) {
        this.isssEmpleador = isssEmpleador;
    }

    public BigDecimal getAfpEmpleador() {
        return afpEmpleador;
    }

    public void setAfpEmpleador(BigDecimal afpEmpleador) {
        this.afpEmpleador = afpEmpleador;
    }

    public BigDecimal getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(BigDecimal vacaciones) {
        this.vacaciones = vacaciones;
    }

    public BigDecimal getSalarioACobrar() {
        return salarioACobrar;
    }

    public void setSalarioACobrar(BigDecimal salarioACobrar) {
        this.salarioACobrar = salarioACobrar;
    }
}
