package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "empleadoscatalogoingresos", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadoscatalogoingresosEntity {
    @Id
    @Column(name="id_empleadocatalogoingreso")
    @SequenceGenerator(name="empcatingre_id_seq",sequenceName = "empleadocatingreso_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empcatingre_id_seq")
    private int id_empleadoCatalogoIngreso;

    @ManyToOne
    @JoinColumn(name = "id_catalogoingresos", referencedColumnName = "id_catalogoingresos", nullable = false)
    private CatalogoingresosEntity id_catalogoingresos;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    private EmpleadosEntity id_empleado;

    @Basic
    @Column(name = "estado")
    private boolean estado;

    public int getId_empleadoCatalogoIngreso() {
        return id_empleadoCatalogoIngreso;
    }

    public void setId_empleadoCatalogoIngreso(int id_empleadoCatalogoIngreso) {
        this.id_empleadoCatalogoIngreso = id_empleadoCatalogoIngreso;
    }

    public CatalogoingresosEntity getId_catalogoingresos() {
        return id_catalogoingresos;
    }

    public void setId_catalogoingresos(CatalogoingresosEntity id_catalogoingresos) {
        this.id_catalogoingresos = id_catalogoingresos;
    }

    public EmpleadosEntity getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(EmpleadosEntity id_empleado) {
        this.id_empleado = id_empleado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
