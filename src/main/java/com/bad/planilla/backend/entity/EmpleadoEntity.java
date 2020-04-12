package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "empleados", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadoEntity {
    private int id;
    private String primernombre;
    private String segundonombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String apellidocasada;
    private Date fechanacimiento;
    private BigDecimal salario;
    private boolean comision;
    private boolean estado;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "primernombre")
    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    @Basic
    @Column(name = "segundonombre")
    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    @Basic
    @Column(name = "apellidopaterno")
    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    @Basic
    @Column(name = "apellidomaterno")
    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    @Basic
    @Column(name = "apellidocasada")
    public String getApellidocasada() {
        return apellidocasada;
    }

    public void setApellidocasada(String apellidocasada) {
        this.apellidocasada = apellidocasada;
    }

    @Basic
    @Column(name = "fechanacimiento")
    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Basic
    @Column(name = "salario")
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Basic
    @Column(name = "comision")
    public boolean isComision() {
        return comision;
    }

    public void setComision(boolean comision) {
        this.comision = comision;
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

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (id != that.id) return false;
        if (comision != that.comision) return false;
        if (estado != that.estado) return false;
        if (primernombre != null ? !primernombre.equals(that.primernombre) : that.primernombre != null) return false;
        if (segundonombre != null ? !segundonombre.equals(that.segundonombre) : that.segundonombre != null)
            return false;
        if (apellidopaterno != null ? !apellidopaterno.equals(that.apellidopaterno) : that.apellidopaterno != null)
            return false;
        if (apellidomaterno != null ? !apellidomaterno.equals(that.apellidomaterno) : that.apellidomaterno != null)
            return false;
        if (apellidocasada != null ? !apellidocasada.equals(that.apellidocasada) : that.apellidocasada != null)
            return false;
        if (fechanacimiento != null ? !fechanacimiento.equals(that.fechanacimiento) : that.fechanacimiento != null)
            return false;
        if (salario != null ? !salario.equals(that.salario) : that.salario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (primernombre != null ? primernombre.hashCode() : 0);
        result = 31 * result + (segundonombre != null ? segundonombre.hashCode() : 0);
        result = 31 * result + (apellidopaterno != null ? apellidopaterno.hashCode() : 0);
        result = 31 * result + (apellidomaterno != null ? apellidomaterno.hashCode() : 0);
        result = 31 * result + (apellidocasada != null ? apellidocasada.hashCode() : 0);
        result = 31 * result + (fechanacimiento != null ? fechanacimiento.hashCode() : 0);
        result = 31 * result + (salario != null ? salario.hashCode() : 0);
        result = 31 * result + (comision ? 1 : 0);
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }
}
