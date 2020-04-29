package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "boletasingresos", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaIngresoEntity {
    private int idEmpleadoingreso;
    private Integer idIngresos;
    private Integer idBoletapago;
    private BigDecimal monto;
    private Date fecha;
    private CatalogoIngresoEntity catalogoingresosByIdIngresos;
    private BoletaPagoEntity boletaspagosByIdBoletapago;

    @Id
    @Column(name = "id_empleadoingreso")
    public int getIdEmpleadoingreso() {
        return idEmpleadoingreso;
    }

    public void setIdEmpleadoingreso(int idEmpleadoingreso) {
        this.idEmpleadoingreso = idEmpleadoingreso;
    }

    @Basic
    @Column(name = "id_ingresos")
    public Integer getIdIngresos() {
        return idIngresos;
    }

    public void setIdIngresos(Integer idIngresos) {
        this.idIngresos = idIngresos;
    }

    @Basic
    @Column(name = "id_boletapago")
    public Integer getIdBoletapago() {
        return idBoletapago;
    }

    public void setIdBoletapago(Integer idBoletapago) {
        this.idBoletapago = idBoletapago;
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
        if (idIngresos != null ? !idIngresos.equals(that.idIngresos) : that.idIngresos != null) return false;
        if (idBoletapago != null ? !idBoletapago.equals(that.idBoletapago) : that.idBoletapago != null) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleadoingreso;
        result = 31 * result + (idIngresos != null ? idIngresos.hashCode() : 0);
        result = 31 * result + (idBoletapago != null ? idBoletapago.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_ingresos", referencedColumnName = "id_ingresos", insertable=false, updatable=false)
    public CatalogoIngresoEntity getCatalogoingresosByIdIngresos() {
        return catalogoingresosByIdIngresos;
    }

    public void setCatalogoingresosByIdIngresos(CatalogoIngresoEntity catalogoingresosByIdIngresos) {
        this.catalogoingresosByIdIngresos = catalogoingresosByIdIngresos;
    }

    @ManyToOne
    @JoinColumn(name = "id_boletapago", referencedColumnName = "id_boletapago", insertable=false, updatable=false)
    public BoletaPagoEntity getBoletaspagosByIdBoletapago() {
        return boletaspagosByIdBoletapago;
    }

    public void setBoletaspagosByIdBoletapago(BoletaPagoEntity boletaspagosByIdBoletapago) {
        this.boletaspagosByIdBoletapago = boletaspagosByIdBoletapago;
    }
}
