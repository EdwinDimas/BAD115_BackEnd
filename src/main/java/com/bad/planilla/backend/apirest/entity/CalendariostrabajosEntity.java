package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "calendariostrabajos", schema = "public", catalog = "dfckhqghp2ho34")
public class CalendariostrabajosEntity {
    private int calendariotrabajo;
    private boolean activo;
    private String periocidad;
    private Collection<BoletaspagosEntity> boletaspagosByCalendariotrabajo;
    private boolean estado;
    private Integer periodo;

    @Id
    @Column(name = "calendariotrabajo", nullable = false)
    @SequenceGenerator(name = "calendariostrabajos_seq", sequenceName = "calendariostrabajos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendariostrabajos_seq")

    public int getCalendariotrabajo() {
        return calendariotrabajo;
    }

    public void setCalendariotrabajo(int calendariotrabajo) {
        this.calendariotrabajo = calendariotrabajo;
    }

    @Basic
    @Column(name = "activo", nullable = false)
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "periocidad", nullable = false, length = 10)
    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    @Basic
    @Column(name = "periodo", nullable = true)
    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
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
        CalendariostrabajosEntity that = (CalendariostrabajosEntity) o;
        return calendariotrabajo == that.calendariotrabajo &&
                activo == that.activo &&
                Objects.equals(periocidad, that.periocidad)&&
                Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendariotrabajo, activo, periocidad, periodo);
    }

    @OneToMany(mappedBy = "calendariotrabajo")
    public Collection<BoletaspagosEntity> getBoletaspagosByCalendariotrabajo() {
        return boletaspagosByCalendariotrabajo;
    }

    public void setBoletaspagosByCalendariotrabajo(Collection<BoletaspagosEntity> boletaspagosByCalendariotrabajo) {
        this.boletaspagosByCalendariotrabajo = boletaspagosByCalendariotrabajo;
    }

}
