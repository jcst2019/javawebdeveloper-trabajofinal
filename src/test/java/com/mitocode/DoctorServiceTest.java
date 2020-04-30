package com.mitocode;

import org.springframework.util.Assert;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mitocode.model.Doctor;
import com.mitocode.model.Especialidad;
import com.mitocode.service.IDoctorService;

@SpringBootTest
@ContextConfiguration
public class DoctorServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(DoctorServiceTest.class);

	@Autowired
	private IDoctorService doctorService;

	@Test
	public void insert() {
		// Insertando Doctor 1
		Doctor doctor1 = new Doctor();
		doctor1.setNombres("Juan Carlos");
		doctor1.setApellidos("Solar Torres");
		doctor1.setDni("43032393");
		doctor1.setCmp("12345678");
		Especialidad especialidad1 = new Especialidad();
		especialidad1.setIdEspecialidad(2);
		doctor1.setEspecialidad(especialidad1);
		logger.info(doctor1.toString());
		int status1 = doctorService.registrar(doctor1);
		Assert.state(status1 == 1, "Insert failed");
		Assert.state(doctor1.getIdDoctor() > 0, "Insert failed 2");

		// Insertando Doctor 2
		Doctor doctor2 = new Doctor();
		doctor2.setNombres("Claudio Victor");
		doctor2.setApellidos("Solar Torres");
		doctor2.setDni("42022292");
		doctor2.setCmp("87654321");
		Especialidad especialidad2 = new Especialidad();
		especialidad2.setIdEspecialidad(1);
		doctor2.setEspecialidad(especialidad2);
		logger.info(doctor2.toString());
		int status2 = doctorService.registrar(doctor2);
		Assert.state(status2 == 1, "Insert failed");
		Assert.state(doctor2.getIdDoctor() > 0, "Insert failed 2");
	}

	@Test
	public void update() {
		// Actualizando Doctor 1
		Doctor doctor1 = new Doctor();
		doctor1.setIdDoctor(1);
		doctor1.setNombres("Paul ");
		doctor1.setApellidos("Solar Torres");
		doctor1.setDni("44444444");
		doctor1.setCmp("12345678");
		Especialidad especialidad1 = new Especialidad();
		especialidad1.setIdEspecialidad(1);
		doctor1.setEspecialidad(especialidad1);
		logger.info(doctor1.toString());
		int status1 = doctorService.actualizar(doctor1);
		Assert.state(status1 == 1, "Update failed");

	}
	@Test
	public void delete() {
		int idDoctor = 3;
		int status = doctorService.eliminar(idDoctor);
		Assert.state(status == 1, "Deletion failed");
	}
	@Test
	public void listarPorID() {
		int idDoctor = 1;
		Doctor doctor3 =  doctorService.obtenerPorId(idDoctor);
		logger.info(doctor3.toString());
		Assert.notNull(doctor3, "doctor3 is null");
	}
	@Test
	public void listarAll() {
		List<Doctor> list = doctorService.obtenerDoctores();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.isNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
	}

}
