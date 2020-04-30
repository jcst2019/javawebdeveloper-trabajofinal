package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Especialidad;

public interface IEspecialidadService {
	Integer registrar(Especialidad especialidad);
	Integer actualizar(Especialidad especialidad);
	Integer eliminar(Integer idEspecialidad);
	Especialidad obtenerPorId(Integer idEspecialidad);
	List<Especialidad> obtenerEspecialidad();
}
