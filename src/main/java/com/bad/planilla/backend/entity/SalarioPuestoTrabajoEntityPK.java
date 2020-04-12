package com.bad.planilla.backend.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SalarioPuestoTrabajoEntityPK implements Serializable {
    private int idSalario;
    private int idPuestotrabajo;

    @Column(name = "id_salario")
    @Id
    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    @Column(name = "id_puestotrabajo")
    @Id
    public int getIdPuestotrabajo() {
        return idPuestotrabajo;
    }

    public void setIdPuestotrabajo(int idPuestotrabajo) {
        this.idPuestotrabajo = idPuestotrabajo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalarioPuestoTrabajoEntityPK that = (SalarioPuestoTrabajoEntityPK) o;

        if (idSalario != that.idSalario) return false;
        if (idPuestotrabajo != that.idPuestotrabajo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSalario;
        result = 31 * result + idPuestotrabajo;
        return result;
    }
}
