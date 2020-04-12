package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "boletasdescuentos", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaDescuentoEntity {
    private int idEmpleadodescuento;
    private BigDecimal monto;
    private Date fecha;
    private boolean estado;

    @Id
    @Column(name = "id_empleadodescuento")
    public int getIdEmpleadodescuento() {
        return idEmpleadodescuento;
    }

    public void setIdEmpleadodescuento(int idEmpleadodescuento) {
        this.idEmpleadodescuento = idEmpleadodescuento;
    }

    @Basic
    @Column(name = "monto")
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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

        BoletaDescuentoEntity that = (BoletaDescuentoEntity) o;

        if (idEmpleadodescuento != that.idEmpleadodescuento) return false;
        if (estado != that.estado) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleadodescuento;
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
