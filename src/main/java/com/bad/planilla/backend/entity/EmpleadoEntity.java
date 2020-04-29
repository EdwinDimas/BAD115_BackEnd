package com.bad.planilla.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "empleados", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadoEntity {
    private int id;
    private Integer idGenero;
    private Integer idEstadocivil;
    private Integer idPuestotrabajo;
    private Integer empId;
    private Integer idUnidadorganizacional;
    private String primernombre;
    private String segundonombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String apellidocasada;
    private Date fechanacimiento;
    private BigDecimal salario;
    private boolean comision;
    private boolean estado;
    private Collection<BoletaPagoEntity> boletaspagosById;
    private Collection<DireccionEntity> direccionesById;
    private Collection<DocumentoEmpleadoEntity> documentosempleadosById;
    private GeneroEntity generosByIdGenero;
    private EstadoCivilEntity estadoscivilesByIdEstadocivil;
    private PuestoTrabajoEntity puestostrabajosByIdPuestotrabajo;
    private EmpleadoEntity empleadosByEmpId;
    private Collection<EmpleadoEntity> empleadosById;
    private UnidadOrganizacionalEntity unidadesorganizacionalesByIdUnidadorganizacional;
    private Collection<ProfesionEmpleadoEntity> profesionesempleadosById;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name="empleado_id_seq", sequenceName = "empleados_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_id_seq")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_genero")
    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    @Basic
    @Column(name = "id_estadocivil")
    public Integer getIdEstadocivil() {
        return idEstadocivil;
    }

    public void setIdEstadocivil(Integer idEstadocivil) {
        this.idEstadocivil = idEstadocivil;
    }

    @Basic
    @Column(name = "id_puestotrabajo")
    public Integer getIdPuestotrabajo() {
        return idPuestotrabajo;
    }

    public void setIdPuestotrabajo(Integer idPuestotrabajo) {
        this.idPuestotrabajo = idPuestotrabajo;
    }

    @Basic
    @Column(name = "emp_id")
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "id_unidadorganizacional")
    public Integer getIdUnidadorganizacional() {
        return idUnidadorganizacional;
    }

    public void setIdUnidadorganizacional(Integer idUnidadorganizacional) {
        this.idUnidadorganizacional = idUnidadorganizacional;
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
        if (idGenero != null ? !idGenero.equals(that.idGenero) : that.idGenero != null) return false;
        if (idEstadocivil != null ? !idEstadocivil.equals(that.idEstadocivil) : that.idEstadocivil != null)
            return false;
        if (idPuestotrabajo != null ? !idPuestotrabajo.equals(that.idPuestotrabajo) : that.idPuestotrabajo != null)
            return false;
        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        if (idUnidadorganizacional != null ? !idUnidadorganizacional.equals(that.idUnidadorganizacional) : that.idUnidadorganizacional != null)
            return false;
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
        result = 31 * result + (idGenero != null ? idGenero.hashCode() : 0);
        result = 31 * result + (idEstadocivil != null ? idEstadocivil.hashCode() : 0);
        result = 31 * result + (idPuestotrabajo != null ? idPuestotrabajo.hashCode() : 0);
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (idUnidadorganizacional != null ? idUnidadorganizacional.hashCode() : 0);
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

    @OneToMany(mappedBy = "empleadosById")
    public Collection<BoletaPagoEntity> getBoletaspagosById() {
        return boletaspagosById;
    }

    public void setBoletaspagosById(Collection<BoletaPagoEntity> boletaspagosById) {
        this.boletaspagosById = boletaspagosById;
    }

    @OneToMany(mappedBy = "empleadosById")
    public Collection<DireccionEntity> getDireccionesById() {
        return direccionesById;
    }

    public void setDireccionesById(Collection<DireccionEntity> direccionesById) {
        this.direccionesById = direccionesById;
    }

    @OneToMany(mappedBy = "empleadosById")
    public Collection<DocumentoEmpleadoEntity> getDocumentosempleadosById() {
        return documentosempleadosById;
    }

    public void setDocumentosempleadosById(Collection<DocumentoEmpleadoEntity> documentosempleadosById) {
        this.documentosempleadosById = documentosempleadosById;
    }

    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    public GeneroEntity getGenerosByIdGenero() {
        return generosByIdGenero;
    }

    public void setGenerosByIdGenero(GeneroEntity generosByIdGenero) {
        this.generosByIdGenero = generosByIdGenero;
    }

    @ManyToOne
    @JoinColumn(name = "id_estadocivil", referencedColumnName = "id_estadocivil")
    public EstadoCivilEntity getEstadoscivilesByIdEstadocivil() {
        return estadoscivilesByIdEstadocivil;
    }

    public void setEstadoscivilesByIdEstadocivil(EstadoCivilEntity estadoscivilesByIdEstadocivil) {
        this.estadoscivilesByIdEstadocivil = estadoscivilesByIdEstadocivil;
    }

    @ManyToOne
    @JoinColumn(name = "id_puestotrabajo", referencedColumnName = "id_puestotrabajo")
    public PuestoTrabajoEntity getPuestostrabajosByIdPuestotrabajo() {
        return puestostrabajosByIdPuestotrabajo;
    }

    public void setPuestostrabajosByIdPuestotrabajo(PuestoTrabajoEntity puestostrabajosByIdPuestotrabajo) {
        this.puestostrabajosByIdPuestotrabajo = puestostrabajosByIdPuestotrabajo;
    }

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    public EmpleadoEntity getEmpleadosByEmpId() {
        return empleadosByEmpId;
    }

    public void setEmpleadosByEmpId(EmpleadoEntity empleadosByEmpId) {
        this.empleadosByEmpId = empleadosByEmpId;
    }

    @OneToMany(mappedBy = "empleadosByEmpId")
    public Collection<EmpleadoEntity> getEmpleadosById() {
        return empleadosById;
    }

    public void setEmpleadosById(Collection<EmpleadoEntity> empleadosById) {
        this.empleadosById = empleadosById;
    }

    @ManyToOne
    @JoinColumn(name = "id_unidadorganizacional", referencedColumnName = "id_unidadorganizacional")
    public UnidadOrganizacionalEntity getUnidadesorganizacionalesByIdUnidadorganizacional() {
        return unidadesorganizacionalesByIdUnidadorganizacional;
    }

    public void setUnidadesorganizacionalesByIdUnidadorganizacional(UnidadOrganizacionalEntity unidadesorganizacionalesByIdUnidadorganizacional) {
        this.unidadesorganizacionalesByIdUnidadorganizacional = unidadesorganizacionalesByIdUnidadorganizacional;
    }

    @OneToMany(mappedBy = "empleadosById")
    public Collection<ProfesionEmpleadoEntity> getProfesionesempleadosById() {
        return profesionesempleadosById;
    }

    public void setProfesionesempleadosById(Collection<ProfesionEmpleadoEntity> profesionesempleadosById) {
        this.profesionesempleadosById = profesionesempleadosById;
    }
}
