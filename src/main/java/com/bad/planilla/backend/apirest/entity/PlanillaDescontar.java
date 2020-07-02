package com.bad.planilla.backend.apirest.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="planilla_descontar")
public class PlanillaDescontar {
	@Id
	@Column(name="id_boletapago")
	private int id_boletapago;
	@Column(name="id_unidadorganizacional")
	private int id_unidadorganizacional;
	@Column(name="nombre")
	private String nombre;
	@Column(name="id_empleado")
	private int id_empleado;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="periocidad")
	private String periodicidad;
	@Column(name="periodo")
	private int periodo;
	@Column(name="pago")
	private BigDecimal pago;
	@Column(name="pagado")
	private boolean pagado;
	public int getId_boletapago() {
		return id_boletapago;
	}
	public int getId_unidadorganizacional() {
		return id_unidadorganizacional;
	}
	public String getNombre() {
		return nombre;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
	public int getPeriodo() {
		return periodo;
	}
	public BigDecimal getPago() {
		return pago;
	}
	public boolean isPagado() {
		return pagado;
	}
	
}
