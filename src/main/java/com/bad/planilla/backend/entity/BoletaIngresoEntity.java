package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "boletasingresos", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaIngresoEntity {
    private int idEmpleadoingreso;
    private BigDecimal monto;
    private Date fecha;

    @Id
    @Column(name = "id_empleadoingreso")
    public int getIdEmpleadoingreso() {
        return idEmpleadoingreso;
    }

    public void setIdEmpleadoingreso(int idEmpleadoingreso) {
        this.idEmpleadoingreso = idEmpleadoingreso;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoletaIngresoEntity that = (BoletaIngresoEntity) o;

        if (idEmpleadoingreso != that.idEmpleadoingreso) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleadoingreso;
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}
