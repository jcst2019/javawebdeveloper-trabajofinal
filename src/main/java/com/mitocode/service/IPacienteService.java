package com.mitocode.service;

import java.util.List;
import com.mitocode.model.Paciente;

public interface IPacienteService {
	Integer registrar(Paciente paciente);
	Integer actualizar(Paciente paciente);
	Integer eliminar(Integer idPaciente);
	Paciente obtenerPorId(Integer idPaciente);
	List<Paciente> obtenerPaciente();
}
