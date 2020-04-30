package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Especialidad;
import com.mitocode.repository.IEspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadRepository especialidadRepository;

	@Override
	public Integer registrar(Especialidad especialidad) {
		int status = especialidadRepository.save(especialidad) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer actualizar(Especialidad especialidad) {
		int status = especialidadRepository.save(especialidad) != null ? 1 : 0;
		return status;
	}

	@Override
	public Integer eliminar(Integer idEspecialidad) {
		especialidadRepository.deleteById(idEspecialidad);
		return 1;
	}

	@Override
	public Especialidad obtenerPorId(Integer idEspecialidad) {
		return especialidadRepository.findById(idEspecialidad).get();
	}

	@Override
	public List<Especialidad> obtenerEspecialidad() {
		return (List<Especialidad>) especialidadRepository.findAll();
	}
}
