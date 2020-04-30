package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.ConsultaMedica;
import com.mitocode.repository.IConsultaMedicaRepository;

@Service
public class ConsultaMedicaImpl implements IConsultaMedicaService {
	
	@Autowired
	private IConsultaMedicaRepository consultaMedicaRepository;

	@Override
	public Integer registrar(ConsultaMedica consultaMedica) {
		int status = consultaMedicaRepository.save(consultaMedica) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer actualizar(ConsultaMedica consultaMedica) {
		int status = consultaMedicaRepository.save(consultaMedica) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idConsultaMedica) {
		consultaMedicaRepository.deleteById(idConsultaMedica);
		return 1;
	}

	@Override
	public ConsultaMedica obtenerPorId(Integer idConsultaMedica) {
		return consultaMedicaRepository.findById(idConsultaMedica).get();
	}

	@Override
	public List<ConsultaMedica> obtenerConsultaMedica() {
		return (List<ConsultaMedica>) consultaMedicaRepository.findAll();
	}
	
	public List<ConsultaMedica> obtenerPorIdPaciente(Integer idDoctor) {
		return (List<ConsultaMedica>) consultaMedicaRepository.obtenerConsulaPorPaciente(idDoctor);
	}

}
