package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private int idDoctor;

	@Column(name = "firstname", length = 50)
	private String nombres;

	@Column(name = "lastname", length = 100)
	private String apellidos;

	@Column(length = 8)
	private String dni;

	@Column(length = 20)
	private String cmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "especialidad")
	private Especialidad especialidad;
	
	public Doctor() {
		super();
	}

	public Doctor(int idDoctor, String nombres, String apellidos, String dni, String cmp, Especialidad especialidad) {
		super();
		this.idDoctor = idDoctor;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.cmp = cmp;
		this.especialidad = especialidad;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", cmp=" + cmp + ", especialidad=" + especialidad + "]";
	}

	

}
