package com.mitocode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitocode.model.ConsultaMedica;
import com.mitocode.model.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {
	
	@Query(value="SELECT * FROM doctor WHERE especialidad = :idEspecialidad", nativeQuery = true)
	List<Doctor> obtenerConsultaPorEspecialidad(@Param("idEspecialidad") Integer idEspecialidad);
}
