package com.bad.planilla.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "relationship_11", schema = "public", catalog = "dfckhqghp2ho34")
@IdClass(SalarioPuestoTrabajoEntityPK.class)
public class SalarioPuestoTrabajoEntity {
    private int idSalario;
    private int idPuestotrabajo;
    private boolean estado;
    private SalarioEntity salariosByIdSalario;
    private PuestoTrabajoEntity puestostrabajosByIdPuestotrabajo;

    @Id
    @Column(name = "id_salario")
    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    @Id
    @Column(name = "id_puestotrabajo")
    public int getIdPuestotrabajo() {
        return idPuestotrabajo;
    }

    public void setIdPuestotrabajo(int idPuestotrabajo) {
        this.idPuestotrabajo = idPuestotrabajo;
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

        SalarioPuestoTrabajoEntity that = (SalarioPuestoTrabajoEntity) o;

        if (idSalario != that.idSalario) return false;
        if (idPuestotrabajo != that.idPuestotrabajo) return false;
        if (estado != that.estado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSalario;
        result = 31 * result + idPuestotrabajo;
        result = 31 * result + (estado ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_salario", referencedColumnName = "id_salario", nullable = false, insertable=false, updatable=false)
    public SalarioEntity getSalariosByIdSalario() {
        return salariosByIdSalario;
    }

    public void setSalariosByIdSalario(SalarioEntity salariosByIdSalario) {
        this.salariosByIdSalario = salariosByIdSalario;
    }

    @ManyToOne
    @JoinColumn(name = "id_puestotrabajo", referencedColumnName = "id_puestotrabajo", nullable = false, insertable=false, updatable=false)
    public PuestoTrabajoEntity getPuestostrabajosByIdPuestotrabajo() {
        return puestostrabajosByIdPuestotrabajo;
    }

    public void setPuestostrabajosByIdPuestotrabajo(PuestoTrabajoEntity puestostrabajosByIdPuestotrabajo) {
        this.puestostrabajosByIdPuestotrabajo = puestostrabajosByIdPuestotrabajo;
    }
}
