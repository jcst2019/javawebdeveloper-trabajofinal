package com.mitocode.service;

import java.util.List;

import com.mitocode.model.ConsultaMedica;

public interface IConsultaMedicaService {
	Integer registrar(ConsultaMedica consultaMedica);
	Integer actualizar(ConsultaMedica consultaMedica);
	Integer eliminar(Integer idConsultaMedica);
	ConsultaMedica obtenerPorId(Integer idConsultaMedica);
	List<ConsultaMedica> obtenerPorIdPaciente(Integer idPaciente);
	List<ConsultaMedica> obtenerConsultaMedica();
}
