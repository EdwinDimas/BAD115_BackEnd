package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "boletaspagos", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaPagoEntity {
    private int idBoletapago;
    private Integer id;
    private Integer calendariotrabajo;
    private BigDecimal salarioneto;
    private BigDecimal renta;
    private Date fecha;
    private boolean estado;
    private Collection<BoletaDescuentoEntity> boletasdescuentosByIdBoletapago;
    private Collection<BoletaIngresoEntity> boletasingresosByIdBoletapago;
    private EmpleadoEntity empleadosById;
    private CalendarioTrabajoEntity calendariostrabajosByCalendariotrabajo;

    @Id
    @Column(name = "id_boletapago")
    public int getIdBoletapago() {
        return idBoletapago;
    }

    public void setIdBoletapago(int idBoletapago) {
        this.idBoletapago = idBoletapago;
    }

    @Basic
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "calendariotrabajo")
    public Integer getCalendariotrabajo() {
        return calendariotrabajo;
    }

    public void setCalendariotrabajo(Integer calendariotrabajo) {
        this.calendariotrabajo = calendariotrabajo;
    }

    @Basic
    @Column(name = "salarioneto")
    public BigDecimal getSalarioneto() {
        return salarioneto;
    }

    public void setSalarioneto(BigDecimal salarioneto) {
        this.salarioneto = salarioneto;
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
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

        BoletaPagoEntity that = (BoletaPagoEntity) o;

        if (idBoletapago != that.idBoletapago) return false;
        if (estado != that.estado) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (calendariotrabajo != null ? !calendariotrabajo.equals(that.calendariotrabajo) : that.calendariotrabajo != null)
            return false;
        if (salarioneto != null ? !salarioneto.equals(that.salarioneto) : that.salarioneto != null) return false;
        if (renta != null ? !renta.equals(that.renta) : that.renta != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBoletapago;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (calendariotrabajo != null ? calendariotrabajo.hashCode() : 0);
        result = 31 * result + (salarioneto != null ? salarioneto.hashCode() : 0);
        result = 31 * result + (renta != null ? renta.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "boletaspagosByIdBoletapago")
    public Collection<BoletaDescuentoEntity> getBoletasdescuentosByIdBoletapago() {
        return boletasdescuentosByIdBoletapago;
    }

    public void setBoletasdescuentosByIdBoletapago(Collection<BoletaDescuentoEntity> boletasdescuentosByIdBoletapago) {
        this.boletasdescuentosByIdBoletapago = boletasdescuentosByIdBoletapago;
    }

    @OneToMany(mappedBy = "boletaspagosByIdBoletapago")
    public Collection<BoletaIngresoEntity> getBoletasingresosByIdBoletapago() {
        return boletasingresosByIdBoletapago;
    }

    public void setBoletasingresosByIdBoletapago(Collection<BoletaIngresoEntity> boletasingresosByIdBoletapago) {
        this.boletasingresosByIdBoletapago = boletasingresosByIdBoletapago;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    public EmpleadoEntity getEmpleadosById() {
        return empleadosById;
    }

    public void setEmpleadosById(EmpleadoEntity empleadosById) {
        this.empleadosById = empleadosById;
    }

    @ManyToOne
    @JoinColumn(name = "calendariotrabajo", referencedColumnName = "calendariotrabajo", insertable=false, updatable=false)
    public CalendarioTrabajoEntity getCalendariostrabajosByCalendariotrabajo() {
        return calendariostrabajosByCalendariotrabajo;
    }

    public void setCalendariostrabajosByCalendariotrabajo(CalendarioTrabajoEntity calendariostrabajosByCalendariotrabajo) {
        this.calendariostrabajosByCalendariotrabajo = calendariostrabajosByCalendariotrabajo;
    }
}
