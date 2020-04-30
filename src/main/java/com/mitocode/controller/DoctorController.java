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

import com.mitocode.model.Doctor;
import com.mitocode.service.IDoctorService;
import com.mitocode.service.IEspecialidadService;

@Controller
@RequestMapping("/doctores")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IEspecialidadService especialidadService;

	@ModelAttribute("module")
	String module() {
		return "doctores";
	}

	@GetMapping()
	public String listarDoctores(Model model) {
		model.addAttribute("listaDoctores", doctorService.obtenerDoctores());
		return "doctores/listar";
	}

	@GetMapping("/nuevo")
	public String doctorView(Model model) {

		model.addAttribute("doctor", new Doctor());
		model.addAttribute("listaEspecialidad", especialidadService.obtenerEspecialidad());

		return "doctores/nuevo";
	}

	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("listaTipos", especialidadService.obtenerEspecialidad());
			return "/doctores/nuevo";
		}

		doctorService.registrar(doctor);

		return "redirect:/doctores";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idDoctor, Model model) {
		model.addAttribute("doctor", doctorService.obtenerPorId(idDoctor));
		model.addAttribute("listaEspecialidad", especialidadService.obtenerEspecialidad());
		return "doctores/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idDoctor, @Validated Doctor doctor,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("listaEspecialidad", especialidadService.obtenerEspecialidad());
			return "doctores/editar";
		}
		doctorService.actualizar(doctor);
		return "redirect:/doctores";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idDoctor) {
		doctorService.eliminar(idDoctor);
		return "redirect:/doctores";
	}

}
