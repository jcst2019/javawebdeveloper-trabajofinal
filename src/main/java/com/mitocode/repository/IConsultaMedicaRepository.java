package com.mitocode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitocode.model.ConsultaMedica;

@Repository
public interface IConsultaMedicaRepository extends CrudRepository<ConsultaMedica, Integer>{

	@Query(value="SELECT * FROM consulta_medica WHERE id_paciente = :idPaciente", nativeQuery = true)
	List<ConsultaMedica> obtenerConsulaPorPaciente(@Param("idPaciente") Integer idPaciente);
}
