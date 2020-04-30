package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Doctor;

public interface IDoctorService {
	Integer registrar(Doctor doctor);
	Integer actualizar(Doctor doctor);
	Integer eliminar(Integer idDoctor);
	Doctor obtenerPorId(Integer idDoctor);
	List<Doctor> obtenerDoctores();
	List<Doctor> obtenerPorEspecialidad(Integer idEspecialidad);
}
