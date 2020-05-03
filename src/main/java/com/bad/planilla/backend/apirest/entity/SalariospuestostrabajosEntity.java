package com.bad.planilla.backend.apirest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "salariospuestostrabajos", schema = "public", catalog = "dfckhqghp2ho34")
public class SalariospuestostrabajosEntity {

    @Id
    @Column(name="id_salariopuestotrabajo")
    @SequenceGenerator(name="salariopuestotra_id_seq",sequenceName = "salariopuestotrabajos_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "salariopuestotra_id_seq")
    private int id_salarioPuestoTrabajo;

    @ManyToOne
    @JoinColumn(name = "id_salario", referencedColumnName = "id_salario", nullable = false)
    private SalariosEntity id_salario;

    @ManyToOne
    @JoinColumn(name = "id_puestotrabajo", referencedColumnName = "id_puestotrabajo", nullable = false)
    private PuestostrabajosEntity id_puestotrabajo;

    @Basic
    @Column(name = "estado")
    private boolean estado;

    public int getId_salarioPuestoTrabajo() {
        return id_salarioPuestoTrabajo;
    }

    public void setId_salarioPuestoTrabajo(int id_salarioPuestoTrabajo) {
        this.id_salarioPuestoTrabajo = id_salarioPuestoTrabajo;
    }

    public SalariosEntity getId_salario() {
        return id_salario;
    }

    public void setId_salario(SalariosEntity id_salario) {
        this.id_salario = id_salario;
    }

    public PuestostrabajosEntity getId_puestotrabajo() {
        return id_puestotrabajo;
    }

    public void setId_puestotrabajo(PuestostrabajosEntity id_puestotrabajo) {
        this.id_puestotrabajo = id_puestotrabajo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
