package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "calendariostrabajos", schema = "public", catalog = "dfckhqghp2ho34")
public class CalendarioTrabajoEntity {
    private int calendariotrabajo;
    private Date desde;
    private Date hasta;
    private boolean activo;
    private String periocidad;
    private Boolean estado;
    private Collection<BoletaPagoEntity> boletaspagosByCalendariotrabajo;

    @Id
    @Column(name = "calendariotrabajo")
    public int getCalendariotrabajo() {
        return calendariotrabajo;
    }

    public void setCalendariotrabajo(int calendariotrabajo) {
        this.calendariotrabajo = calendariotrabajo;
    }

    @Basic
    @Column(name = "desde")
    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    @Basic
    @Column(name = "hasta")
    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    @Basic
    @Column(name = "activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "periocidad")
    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    @Basic
    @Column(name = "estado")
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarioTrabajoEntity that = (CalendarioTrabajoEntity) o;

        if (calendariotrabajo != that.calendariotrabajo) return false;
        if (activo != that.activo) return false;
        if (desde != null ? !desde.equals(that.desde) : that.desde != null) return false;
        if (hasta != null ? !hasta.equals(that.hasta) : that.hasta != null) return false;
        if (periocidad != null ? !periocidad.equals(that.periocidad) : that.periocidad != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = calendariotrabajo;
        result = 31 * result + (desde != null ? desde.hashCode() : 0);
        result = 31 * result + (hasta != null ? hasta.hashCode() : 0);
        result = 31 * result + (activo ? 1 : 0);
        result = 31 * result + (periocidad != null ? periocidad.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "calendariostrabajosByCalendariotrabajo")
    public Collection<BoletaPagoEntity> getBoletaspagosByCalendariotrabajo() {
        return boletaspagosByCalendariotrabajo;
    }

    public void setBoletaspagosByCalendariotrabajo(Collection<BoletaPagoEntity> boletaspagosByCalendariotrabajo) {
        this.boletaspagosByCalendariotrabajo = boletaspagosByCalendariotrabajo;
    }
}
