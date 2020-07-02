package com.bad.planilla.backend.apirest.globals;

import java.math.BigDecimal;

public class ConsultaBoletaPago {
    private int id;
    private int diasFaltados;
    private BigDecimal horasFaltadas;
    private BigDecimal horasExtra;
    private BigDecimal horasNocturnas;
    private BigDecimal ventas;
    private BigDecimal bonos;
    private int diasFestivos;
    private BigDecimal otrosDescuentos;
    private boolean esServicioProfesional;
    private boolean aplicarVacaciones;
    private String periodicidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiasFaltados() {
        return diasFaltados;
    }

    public void setDiasFaltados(int diasFaltados) {
        this.diasFaltados = diasFaltados;
    }

    public BigDecimal getHorasFaltadas() {
        return horasFaltadas;
    }

    public void setHorasFaltadas(BigDecimal horasFaltadas) {
        this.horasFaltadas = horasFaltadas;
    }

    public BigDecimal getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(BigDecimal horasExtra) {
        this.horasExtra = horasExtra;
    }

    public BigDecimal getHorasNocturnas() {
        return horasNocturnas;
    }

    public void setHorasNocturnas(BigDecimal horasNocturnas) {
        this.horasNocturnas = horasNocturnas;
    }

    public BigDecimal getVentas() {
        return ventas;
    }

    public void setVentas(BigDecimal ventas) {
        this.ventas = ventas;
    }

    public BigDecimal getBonos() {
        return bonos;
    }

    public void setBonos(BigDecimal bonos) {
        this.bonos = bonos;
    }

    public int getDiasFestivos() {
        return diasFestivos;
    }

    public void setDiasFestivos(int diasFestivos) {
        this.diasFestivos = diasFestivos;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public BigDecimal getOtrosDescuentos() {
        return otrosDescuentos;
    }

    public void setOtrosDescuentos(BigDecimal otrosDescuentos) {
        this.otrosDescuentos = otrosDescuentos;
    }

    public boolean isEsServicioProfesional() {
        return esServicioProfesional;
    }

    public void setEsServicioProfesional(boolean esServicioProfesional) {
        this.esServicioProfesional = esServicioProfesional;
    }

    public boolean isAplicarVacaciones() {
        return aplicarVacaciones;
    }

    public void setAplicarVacaciones(boolean aplicarVacaciones) {
        this.aplicarVacaciones = aplicarVacaciones;
    }
}
