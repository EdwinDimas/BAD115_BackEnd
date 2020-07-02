package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "centrocostos", schema = "public", catalog = "dfckhqghp2ho34")
public class CentrocostosEntity {
    private int idCosto;
    private BigDecimal monto;
    private BigDecimal montoactual;
    private int periodo;
    private UnidadesorganizacionalesEntity id_unidadorganizacional;
    private int idUnidadPadre;
    private boolean estado;

    @Id
    @Column(name = "id_costo", nullable = false) 
    @SequenceGenerator(name="centrocosto_id_seq",sequenceName = "centrocostos_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "centrocosto_id_seq")
    public int getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(int idCosto) {
        this.idCosto = idCosto;
    }

    @Basic
    @Column(name = "monto", nullable = false, precision = 2)
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "montoactual", nullable = false, precision = 2)
    public BigDecimal getMontoactual() {
        return montoactual;
    }

    public void setMontoactual(BigDecimal montoactual) {
        this.montoactual = montoactual;
    }

    @Basic
    @Column(name = "periodo", nullable = false)
    public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
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
    
    
    @Basic
    @Column(name="id_unidadpadre")
    public int getIdUnidadPadre() {
		return idUnidadPadre;
	}

	public void setIdUnidadPadre(int idUnidadPadre) {
		this.idUnidadPadre = idUnidadPadre;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentrocostosEntity that = (CentrocostosEntity) o;
        return idCosto == that.idCosto &&
                Objects.equals(monto, that.monto) &&
                Objects.equals(montoactual, that.montoactual) &&
                Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCosto, monto, montoactual, periodo);
    }

    @ManyToOne
    @JoinColumn(name = "id_unidadorganizacional", referencedColumnName = "id_unidadorganizacional")
    public UnidadesorganizacionalesEntity getId_unidadorganizacional() {
        return id_unidadorganizacional;
    }

    public void setId_unidadorganizacional(UnidadesorganizacionalesEntity id_unidadorganizacional) {
        this.id_unidadorganizacional = id_unidadorganizacional;
    }
}
