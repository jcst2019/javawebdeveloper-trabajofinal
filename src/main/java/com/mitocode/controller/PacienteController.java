package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private IPacienteService pacienteService;
	
	@ModelAttribute("module")
	String module() {
		return "pacientes";
	}
	@GetMapping()
	public String listarPacientes(Model model) {
		model.addAttribute("listaPacientes", pacienteService.obtenerPaciente());
		return "pacientes/listar";
	}

	@GetMapping("/nuevo")
	public String pacienteView(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "pacientes/nuevo";
	}

	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("paciente") Paciente paciente, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "/pacientes/nuevo";
		}

		pacienteService.registrar(paciente);

		return "redirect:/pacientes";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idPaciente, Model model) {
		model.addAttribute("paciente", pacienteService.obtenerPorId(idPaciente));
		return "pacientes/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idPaciente, @Validated Paciente paciente,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			return "pacientes/editar";
		}
		pacienteService.actualizar(paciente);
		return "redirect:/pacientes";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idPaciente) {
		pacienteService.eliminar(idPaciente);
		return "redirect:/pacientes";
	}
	
}
