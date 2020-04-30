package com.mitocode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Especialidad;

@Repository
public interface IEspecialidadRepository extends CrudRepository <Especialidad, Integer> {

}
