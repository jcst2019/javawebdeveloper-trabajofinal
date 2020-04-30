package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Doctor;
import com.mitocode.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorRepository doctorRepository;

	@Override
	public Integer registrar(Doctor doctor) {
		int status = doctorRepository.save(doctor) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer actualizar(Doctor doctor) {
		int status = doctorRepository.save(doctor) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idDoctor) {
		doctorRepository.deleteById(idDoctor);
		return 1;
	}

	@Override
	public Doctor obtenerPorId(Integer idDoctor) {
		return doctorRepository.findById(idDoctor).get();
	}

	@Override
	public List<Doctor> obtenerDoctores() {
		return (List<Doctor>) doctorRepository.findAll();
	}

	@Override
	public List<Doctor> obtenerPorEspecialidad(Integer idEspecialidad) {
		
			return (List<Doctor>) doctorRepository.obtenerConsultaPorEspecialidad(idEspecialidad);

	}

}
