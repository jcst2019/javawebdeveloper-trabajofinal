package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.service.IConsultaMedicaService;
import com.mitocode.service.IPacienteService;

@Controller
@RequestMapping("/consultamedicapaciente")
public class ConsultaMedicaPacienteController {

	@Autowired
	private IConsultaMedicaService consultaMedicaService;

	@Autowired
	private IPacienteService pacienteService;

	@ModelAttribute("module")
	String module() {
		return "consultamedicapaciente";
	}

	@GetMapping()
	public String listarConsultaMedica(Model model) {
		model.addAttribute("listaPaciente", pacienteService.obtenerPaciente());
		return "consultamedica/listarporpaciente";
	}

	@GetMapping("/listarconsultaporpaciente/{id}")
	public String listarconsultaporpaciente(@PathVariable(value = "id") Integer idPaciente, Model model) {
		model.addAttribute("paciente", pacienteService.obtenerPorId(idPaciente));
		model.addAttribute("listaConsultaMedica", consultaMedicaService.obtenerPorIdPaciente(idPaciente));
		model.addAttribute("listaPaciente", pacienteService.obtenerPaciente());
		return "consultamedica/listarporconsultapaciente";	
	}


}
