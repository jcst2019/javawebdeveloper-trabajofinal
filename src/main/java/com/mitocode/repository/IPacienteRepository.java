package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Paciente;
@Repository
public interface IPacienteRepository extends CrudRepository<Paciente, Integer>  {

}
