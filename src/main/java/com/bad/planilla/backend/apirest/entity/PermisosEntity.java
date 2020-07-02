package com.bad.planilla.backend.apirest.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="permisos")
@Getter
@Setter
@JsonIgnoreProperties(value = { "roles" })
public class PermisosEntity {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_permiso",nullable=false)
	@SequenceGenerator(name="permiso_id_seq",sequenceName="permisos_id_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="permiso_id_seq")
	private int idPermiso;
	
	@Column(nullable=false,length=100,unique=true,name="nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "permisos",fetch = FetchType.LAZY)
	private Set<RolesEntity> roles;

}
