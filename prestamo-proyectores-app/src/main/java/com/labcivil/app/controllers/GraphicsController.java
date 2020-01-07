package com.labcivil.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.labcivil.app.models.entity.Estudiante;
import com.labcivil.app.models.entity.Materia;
import com.labcivil.app.models.entity.Profesor;
import com.labcivil.app.models.entity.Proyector;
import com.labcivil.app.models.service.IEstudianteService;
import com.labcivil.app.models.service.IMateriaService;
import com.labcivil.app.models.service.IProfesorService;
import com.labcivil.app.models.service.IProyectorService;

@Controller
public class GraphicsController {
	
	@Autowired
	private IProyectorService proyectorService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IProfesorService profesorService;
	
	
	@GetMapping(value = "/graficas")
	public String graficos(Map<String, Object> model, RedirectAttributes flash) {

		model.put("titulo", "GRÁFICAS (NÚMERO DE PRÉSTAMOS)");
		return "grafico";
	}
	
	@GetMapping(value = "/cargar-proyectoresg", produces = { "application/json" })
	public @ResponseBody List<Proyector> cargarProyectores() {
		return proyectorService.findAllOrder();
	}
	
	@GetMapping(value = "/cargar-materiasg", produces = { "application/json" })
	public @ResponseBody List<Materia> cargarMaterias() {
		return materiaService.findAllOrder();
	}
	
	@GetMapping(value = "/cargar-estudiantesg", produces = { "application/json" })
	public @ResponseBody List<Estudiante> cargarEstudiantes() {
		return estudianteService.findAllOrder();
	}
	
	@GetMapping(value = "/cargar-profesoresg", produces = { "application/json" })
	public @ResponseBody List<Profesor> cargarProfesores() {
		return profesorService.findAllOrder();
	}
	
	@GetMapping(value = "/lab-civil")
	public String labCivil(Map<String, Object> model, RedirectAttributes flash) {

		model.put("titulo", "LABORATORIO DE ING. CIVIL");
		return "labcivil";
	}

}
