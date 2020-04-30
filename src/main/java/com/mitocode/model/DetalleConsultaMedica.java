package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DetalleConsultaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private int idDetConsultaMedica;
	
	@Column(name = "diagnostic")
	private String diagnostico;
	
	@Column(name = "treatment")
	private String tratamiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idConsultaMedica")
	@JsonIgnore
	private ConsultaMedica consultaMedica;

	public DetalleConsultaMedica() {
		super();
	}

	public DetalleConsultaMedica(int idDetConsultaMedica, String diagnostico, String tratamiento,
			ConsultaMedica consultaMedica) {
		super();
		this.idDetConsultaMedica = idDetConsultaMedica;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.consultaMedica = consultaMedica;
	}

	public int getIdDetConsultaMedica() {
		return idDetConsultaMedica;
	}

	public void setIdDetConsultaMedica(int idDetConsultaMedica) {
		this.idDetConsultaMedica = idDetConsultaMedica;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public ConsultaMedica getConsultaMedica() {
		return consultaMedica;
	}

	public void setConsultaMedica(ConsultaMedica consultaMedica) {
		this.consultaMedica = consultaMedica;
	}

	@Override
	public String toString() {
		return "DetalleConsultaMedica [idDetConsultaMedica=" + idDetConsultaMedica + ", diagnostico=" + diagnostico
				+ ", tratamiento=" + tratamiento + ", consultaMedica=" + consultaMedica + "]";
	}
	
	
	
}
