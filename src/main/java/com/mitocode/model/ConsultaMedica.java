package com.mitocode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ConsultaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private int idConsultaMedica;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createDate")
	private LocalDate fechaRegistro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDoctor")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;

	public ConsultaMedica() {
		super();
	}

	public ConsultaMedica(int idConsultaMedica, LocalDate fechaRegistro, Doctor doctor, Paciente paciente) {
		super();
		this.idConsultaMedica = idConsultaMedica;
		this.fechaRegistro = fechaRegistro;
		this.doctor = doctor;
		this.paciente = paciente;
	}

	public int getIdConsultaMedica() {
		return idConsultaMedica;
	}

	public void setIdConsultaMedica(int idConsultaMedica) {
		this.idConsultaMedica = idConsultaMedica;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "ConsultaMedica [idConsultaMedica=" + idConsultaMedica + ", fechaRegistro=" + fechaRegistro + ", doctor="
				+ doctor + ", paciente=" + paciente + "]";
	}
}
