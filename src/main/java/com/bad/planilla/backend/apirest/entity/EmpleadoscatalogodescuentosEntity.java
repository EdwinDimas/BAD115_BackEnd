package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "empleadoscatalogodescuentos", schema = "public", catalog = "dfckhqghp2ho34")
public class EmpleadoscatalogodescuentosEntity {
    @Id
    @Column(name="id_empleadocatalogodescuento")
    @SequenceGenerator(name="empcatdesc_id_seq",sequenceName = "empleadocatdescuento_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empcatdesc_id_seq")
    private int id_empleadoCatalogoDescuento;

    @ManyToOne
    @JoinColumn(name = "id_caralogodescuento", nullable = false)
    private CatalogodescuentosEntity id_caralogodescuentos;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    private EmpleadosEntity id_empleado;

    @Basic
    @Column(name = "estado")
    private boolean estado;

    public int getId_empleadoCatalogoDescuento() {
        return id_empleadoCatalogoDescuento;
    }

    public void setId_empleadoCatalogoDescuento(int id_empleadoCatalogoDescuento) {
        this.id_empleadoCatalogoDescuento = id_empleadoCatalogoDescuento;
    }

    public CatalogodescuentosEntity getId_caralogodescuentos() {
        return id_caralogodescuentos;
    }

    public void setId_caralogodescuentos(CatalogodescuentosEntity id_caralogodescuentos) {
        this.id_caralogodescuentos = id_caralogodescuentos;
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
