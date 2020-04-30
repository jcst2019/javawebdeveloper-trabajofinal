package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitocode.model.ConsultaMedica;
import com.mitocode.model.DetalleConsultaMedica;
import com.mitocode.service.IConsultaMedicaService;
import com.mitocode.service.IDoctorService;
import com.mitocode.service.IPacienteService;

@Controller
@RequestMapping("/consultamedica")
public class ConsultaMedicaController {

	@Autowired
	private IConsultaMedicaService consultaMedicaService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@ModelAttribute("module")
	String module() {
		return "consultamedica";
	}

	@GetMapping()
	public String listarConsultaMedica(Model model) {
		model.addAttribute("listaConsultaMedica", consultaMedicaService.obtenerConsultaMedica());
		return "consultamedica/listar";
	}

	@GetMapping("/nuevo")
	public String consultaMedicaView(Model model) {

		model.addAttribute("consultaMedica", new ConsultaMedica());
		model.addAttribute("listaDoctores", doctorService.obtenerDoctores());
		model.addAttribute("listaPaciente", pacienteService.obtenerPaciente());
		return "consultamedica/nuevo";
	}

	@PostMapping("/crear")
	public String crear(@Validated @ModelAttribute("consultaMedica") ConsultaMedica consultaMedica,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("listaDoctores", doctorService.obtenerDoctores());
			model.addAttribute("listaPaciente", pacienteService.obtenerPaciente());
			return "/consultamedica/nuevo";
		}

		consultaMedicaService.registrar(consultaMedica);

		return "redirect:/consultamedica";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Integer idConsultaMedica, Model model) {
		model.addAttribute("consultaMedica", consultaMedicaService.obtenerPorId(idConsultaMedica));
		model.addAttribute("listaDoctores", doctorService.obtenerDoctores());
		model.addAttribute("listaPaciente", pacienteService.obtenerPaciente());
		return "consultamedica/editar";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idConsultaMedica,
			@Validated ConsultaMedica consultaMedica, BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("listaDoctores", doctorService.obtenerDoctores());
			model.addAttribute("listaPaciente", pacienteService.obtenerPaciente());
			return "consultamedica/editar";
		}
		consultaMedicaService.actualizar(consultaMedica);
		return "redirect:/consultamedica";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idConsultaMedica) {
		consultaMedicaService.eliminar(idConsultaMedica);
		return "redirect:/consultamedica";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {

		CustomCollectionEditor DiagnoticoCollector = new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					String selectValue = (String) element;

					DetalleConsultaMedica detalleConsultaMedica= new DetalleConsultaMedica();
					detalleConsultaMedica.setDiagnostico(selectValue);
					return detalleConsultaMedica;
				}
				throw new RuntimeException("InitBinder error in element: " + element);
			}
		};

		binder.registerCustomEditor(List.class, "diagnosticos", DiagnoticoCollector);
	}
}
