package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empleados", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadosEntity {
    private int idEmpleado;
    private Integer empleadoJefe;
    private String primernombre;
    private String segundonombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String apellidocasada;
    private Date fechanacimiento;
    private BigDecimal salario;
    private boolean comision;
    private Collection<BoletaspagosEntity> boletaPago;
    private Collection<DocumentosempleadosEntity> documentosempleado;
    private Collection<EmpleadodescuentosotrosEntity> empleadoDescuentosOtros;
    private GenerosEntity id_genero;
    private EstadoscivilesEntity id_estadocivil;
    private DireccionesEntity id_direccion;
    private PuestosTrabajosEntity id_puestotrabajo;
    private UnidadesorganizacionalesEntity id_unidadorganizacional;
    private Collection<EmpleadoscatalogodescuentosEntity> empleadoCatalogoDescuentos;
    private Collection<EmpleadoscatalogoingresosEntity> empleadoCatalogoIngresos;
    private Collection<ProfesionesempleadosEntity> profesionesEmpleado;
    private boolean estado;
    private BigDecimal prestamo;

    @Id
    @Column(name = "id_empleado", nullable = false)
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "emp_id_empleado", nullable = true)
    public Integer getEmpleadoJefe() {
        return empleadoJefe;
    }

    public void setEmpleadoJefe(Integer empleadoJefe) {
        this.empleadoJefe = empleadoJefe;
    }

    @Basic
    @Column(name = "primernombre", nullable = false, length = 50)
    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    @Basic
    @Column(name = "segundonombre", nullable = false, length = 50)
    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    @Basic
    @Column(name = "apellidopaterno", nullable = false, length = 50)
    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    @Basic
    @Column(name = "apellidomaterno", nullable = false, length = 50)
    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    @Basic
    @Column(name = "apellidocasada", nullable = false, length = 50)
    public String getApellidocasada() {
        return apellidocasada;
    }

    public void setApellidocasada(String apellidocasada) {
        this.apellidocasada = apellidocasada;
    }

    @Basic
    @Column(name = "fechanacimiento", nullable = false)
    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Basic
    @Column(name = "salario", nullable = false, precision = 2)
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Basic
    @Column(name = "comision", nullable = false)
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

    @Basic
    @Column(name = "prestamo", nullable = false, precision = 2)
    public BigDecimal getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(BigDecimal prestamo) {
        this.prestamo =prestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosEntity that = (EmpleadosEntity) o;
        return idEmpleado == that.idEmpleado &&
                comision == that.comision &&
                Objects.equals(empleadoJefe, that.empleadoJefe) &&
                Objects.equals(primernombre, that.primernombre) &&
                Objects.equals(segundonombre, that.segundonombre) &&
                Objects.equals(apellidopaterno, that.apellidopaterno) &&
                Objects.equals(apellidomaterno, that.apellidomaterno) &&
                Objects.equals(apellidocasada, that.apellidocasada) &&
                Objects.equals(fechanacimiento, that.fechanacimiento) &&
                Objects.equals(salario, that.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, empleadoJefe, primernombre, segundonombre, apellidopaterno, apellidomaterno, apellidocasada, fechanacimiento, salario, comision);
    }

    @OneToMany(mappedBy = "id_empleado")
    public Collection<BoletaspagosEntity> getBoletaPago() {
        return boletaPago;
    }

    public void setBoletaPago(Collection<BoletaspagosEntity> boletaPago) {
        this.boletaPago = boletaPago;
    }

    @OneToMany(mappedBy = "id_empleado")
    public Collection<DocumentosempleadosEntity> getDocumentosempleado() {
        return documentosempleado;
    }

    public void setDocumentosempleado(Collection<DocumentosempleadosEntity> documentosempleado) {
        this.documentosempleado = documentosempleado;
    }

    @OneToMany(mappedBy = "id_empleado")
    public Collection<EmpleadodescuentosotrosEntity> getEmpleadoDescuentosOtros() {
        return empleadoDescuentosOtros;
    }

    public void setEmpleadoDescuentosOtros(Collection<EmpleadodescuentosotrosEntity> empleadoDescuentosOtros) {
        this.empleadoDescuentosOtros = empleadoDescuentosOtros;
    }

    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    public GenerosEntity getId_genero() {
        return id_genero;
    }

    public void setId_genero(GenerosEntity id_genero) {
        this.id_genero = id_genero;
    }

    @ManyToOne
    @JoinColumn(name = "id_estadocivil", referencedColumnName = "id_estadocivil")
    public EstadoscivilesEntity getId_estadocivil() {
        return id_estadocivil;
    }

    public void setId_estadocivil(EstadoscivilesEntity id_estadocivil) {
        this.id_estadocivil = id_estadocivil;
    }

    @ManyToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    public DireccionesEntity getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(DireccionesEntity id_direccion) {
        this.id_direccion = id_direccion;
    }

    @ManyToOne
    @JoinColumn(name = "id_puestotrabajo", referencedColumnName = "id_puestotrabajo")
    public PuestosTrabajosEntity getId_puestotrabajo() {
        return id_puestotrabajo;
    }

    public void setId_puestotrabajo(PuestosTrabajosEntity id_puestotrabajo) {
        this.id_puestotrabajo = id_puestotrabajo;
    }

    @ManyToOne
    @JoinColumn(name = "id_unidadorganizacional", referencedColumnName = "id_unidadorganizacional")
    public UnidadesorganizacionalesEntity getId_unidadorganizacional() {
        return id_unidadorganizacional;
    }

    public void setId_unidadorganizacional(UnidadesorganizacionalesEntity id_unidadorganizacional) {
        this.id_unidadorganizacional = id_unidadorganizacional;
    }

    @OneToMany(mappedBy = "id_empleado")
    public Collection<EmpleadoscatalogodescuentosEntity> getEmpleadoCatalogoDescuentos() {
        return empleadoCatalogoDescuentos;
    }

    public void setEmpleadoCatalogoDescuentos(Collection<EmpleadoscatalogodescuentosEntity> empleadoCatalogoDescuentos) {
        this.empleadoCatalogoDescuentos = empleadoCatalogoDescuentos;
    }

    @OneToMany(mappedBy = "id_empleado")
    public Collection<EmpleadoscatalogoingresosEntity> getEmpleadoCatalogoIngresos() {
        return empleadoCatalogoIngresos;
    }

    public void setEmpleadoCatalogoIngresos(Collection<EmpleadoscatalogoingresosEntity> empleadoCatalogoIngresos) {
        this.empleadoCatalogoIngresos = empleadoCatalogoIngresos;
    }

    @OneToMany(mappedBy = "id_empleado")
    public Collection<ProfesionesempleadosEntity> getProfesionesEmpleado() {
        return profesionesEmpleado;
    }

    public void setProfesionesEmpleado(Collection<ProfesionesempleadosEntity> profesionesEmpleado) {
        this.profesionesEmpleado = profesionesEmpleado;
    }
}
