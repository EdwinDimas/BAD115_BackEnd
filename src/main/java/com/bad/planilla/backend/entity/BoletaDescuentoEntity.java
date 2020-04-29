package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "boletasdescuentos", schema = "public", catalog = "dfckhqghp2ho34")
public class BoletaDescuentoEntity {
    private int idEmpleadodescuento;
    private Integer idCaralogodescuento;
    private Integer idBoletapago;
    private BigDecimal monto;
    private Date fecha;
    private boolean estado;
    private CatalogoDescuentoEntity catalogodescuentosByIdCaralogodescuento;
    private BoletaPagoEntity boletaspagosByIdBoletapago;

    @Id
    @Column(name = "id_empleadodescuento")
    public int getIdEmpleadodescuento() {
        return idEmpleadodescuento;
    }

    public void setIdEmpleadodescuento(int idEmpleadodescuento) {
        this.idEmpleadodescuento = idEmpleadodescuento;
    }

    @Basic
    @Column(name = "id_caralogodescuento")
    public Integer getIdCaralogodescuento() {
        return idCaralogodescuento;
    }

    public void setIdCaralogodescuento(Integer idCaralogodescuento) {
        this.idCaralogodescuento = idCaralogodescuento;
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
        if (idCaralogodescuento != null ? !idCaralogodescuento.equals(that.idCaralogodescuento) : that.idCaralogodescuento != null)
            return false;
        if (idBoletapago != null ? !idBoletapago.equals(that.idBoletapago) : that.idBoletapago != null) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleadodescuento;
        result = 31 * result + (idCaralogodescuento != null ? idCaralogodescuento.hashCode() : 0);
        result = 31 * result + (idBoletapago != null ? idBoletapago.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_caralogodescuento", referencedColumnName = "id_caralogodescuento")
    public CatalogoDescuentoEntity getCatalogodescuentosByIdCaralogodescuento() {
        return catalogodescuentosByIdCaralogodescuento;
    }

    public void setCatalogodescuentosByIdCaralogodescuento(CatalogoDescuentoEntity catalogodescuentosByIdCaralogodescuento) {
        this.catalogodescuentosByIdCaralogodescuento = catalogodescuentosByIdCaralogodescuento;
    }

    @ManyToOne
    @JoinColumn(name = "id_boletapago", referencedColumnName = "id_boletapago")
    public BoletaPagoEntity getBoletaspagosByIdBoletapago() {
        return boletaspagosByIdBoletapago;
    }

    public void setBoletaspagosByIdBoletapago(BoletaPagoEntity boletaspagosByIdBoletapago) {
        this.boletaspagosByIdBoletapago = boletaspagosByIdBoletapago;
    }
}
