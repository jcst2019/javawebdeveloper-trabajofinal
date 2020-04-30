package com.mitocode.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.service.IConsultaMedicaService;
import com.mitocode.service.IDoctorService;
import com.mitocode.service.IEspecialidadService;
import com.mitocode.service.IPacienteService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IEspecialidadService especialidadService;
	
	@Autowired
	private IConsultaMedicaService consultaMedicaService;

	@ModelAttribute("module")
	String module() {
		return "reportes";
	}

	@GetMapping()
	public String reportForm() {
		return "reportes";
	}

	@GetMapping("/listar")
	public String listarEspecialidades(Model model) {
		model.addAttribute("listaEspecialidades", especialidadService.obtenerEspecialidad());
		return "reportes/listar";
	}

	// Listar Historia Clínica
	@GetMapping("/listarhc")
	public String listarHistoriaClinica(Model model) {
		model.addAttribute("listaPacientes", pacienteService.obtenerPaciente());
		return "reportes/listarhc";
	}

	@GetMapping("/reporte01/{id}")
	public ResponseEntity<byte[]> reporte01(@PathVariable(value = "id") Integer idEspecilaidad)
			throws JRException, IOException {

		JasperReport report = JasperCompileManager
				.compileReport("src/main/resources/reportes/ReporteMedicoEspecialidad.jrxml");
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
				doctorService.obtenerPorEspecialidad(idEspecilaidad));
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("parametro1", "Hola Mundo");
		JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
		byte[] data = JasperExportManager.exportReportToPdf(print);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename= " + "reportedoctorxespecialidad.pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(data.length).body(data);
	}
	
	@GetMapping("/reporte02/{id}")
	public ResponseEntity<byte[]> reporte02(@PathVariable(value = "id") Integer idPaciente)
			throws JRException, IOException {

		JasperReport report = JasperCompileManager
				.compileReport("src/main/resources/reportes/ReporteHistoriaClinica.jrxml");
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
				consultaMedicaService.obtenerPorIdPaciente(idPaciente));
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("parametro1", "Hola Mundo");
		JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
		byte[] data = JasperExportManager.exportReportToPdf(print);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename= " + "reportedoctorxespecialidad.pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(data.length).body(data);
	}

}
