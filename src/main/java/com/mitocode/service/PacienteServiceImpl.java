package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.Paciente;
import com.mitocode.repository.IPacienteRepository;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Override
	public Integer registrar(Paciente paciente) {
		int status = pacienteRepository.save(paciente) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer actualizar(Paciente paciente) {
		int status = pacienteRepository.save(paciente) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idPaciente) {
		pacienteRepository.deleteById(idPaciente);
		return 1;
	}

	@Override
	public Paciente obtenerPorId(Integer idPaciente) {
		return pacienteRepository.findById(idPaciente).get();
	}

	@Override
	public List<Paciente> obtenerPaciente() {
		return (List<Paciente>) pacienteRepository.findAll();
	}

}
