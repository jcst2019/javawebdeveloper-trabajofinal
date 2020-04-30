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
import com.mitocode.model.Especialidad;
import com.mitocode.service.IEspecialidadService;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService especialidadService;

	@ModelAttribute("module")
	String module() {
		return "especialidades";
	}

	@GetMapping()
	public String listarEspecialidades(Model model) {
		model.addAttribute("listaEspecialidades", especialidadService.obtenerEspecialidad());
		return "especialidades/listar";
	}

	@GetMapping("/nuevo")
	public String especialidadesView(Model model) {

		model.addAttribute("especialidades", new Especialidad());
		return "especialidades/nuevo";
	}

	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("especialidades") Especialidad especialidad, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "/especialidades/nuevo";
		}

		especialidadService.registrar(especialidad);

		return "redirect:/especialidades";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idEspecialidad, Model model) {
		model.addAttribute("especialidades", especialidadService.obtenerPorId(idEspecialidad));
		return "especialidades/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idEspecialidad, @Validated Especialidad especialidad,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			return "especialidades/editar";
		}
		especialidadService.actualizar(especialidad);
		return "redirect:/especialidades";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idEspecialidad) {
		especialidadService.eliminar(idEspecialidad);
		return "redirect:/especialidades";
	}

}
