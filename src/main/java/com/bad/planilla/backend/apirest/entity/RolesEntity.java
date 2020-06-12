package com.bad.planilla.backend.apirest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles",schema = "public", catalog = "dfckhqghp2ho34")
@Getter
@Setter
public class RolesEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_rol",nullable=false)
	@SequenceGenerator(name="rol_id_seq",sequenceName="roles_id_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="rol_id_seq")
	private int idRol;
	
	@Column(name="nombre",nullable=false,unique=true, length=45)
	private String nombre;
	
	@Column(name="detalle",nullable=false, length=100)
	private String detalle;
	
	@Column(name = "estado")
	private boolean estado = true;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="roles_permisos")
	private Set<PermisosEntity> permisos = new HashSet<PermisosEntity>();

}
