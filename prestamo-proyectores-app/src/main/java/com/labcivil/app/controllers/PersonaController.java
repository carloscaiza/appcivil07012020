package com.labcivil.app.controllers;

import java.util.Map;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.labcivil.app.models.dao.IPersonaDao;
import com.labcivil.app.models.entity.Persona;
import com.labcivil.app.models.service.IPersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
//	private IPersonaDao personaDao;
	
	@RequestMapping(value= {"/listar","/"}, method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "listado de personas");
		model.addAttribute("personas", personaService.findAll());
		return "persona/listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Persona persona = new Persona();
		model.put("persona", persona);
		model.put("titulo", "Formulario de Persona");
		return "persona/form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		Persona persona = null;
		
		if(id>0) {
			persona = personaService.findOne(id);
		} else {
			return "redirect:/persona/listar";
		}
		model.put("persona", persona);
		model.put("titulo", "Editar Persona");		
		return "persona/form";
	}
	
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Persona persona, ModelMap modelMap) {
//		public String guardar(@Valid Persona persona, BindingResult result, Model model, ModelMap modelMap) {
//		if(result.hasErrors()) {
//			model.addAttribute("titulo", "Formulario de Persona");
//			return "form";
//		}
//		personaDao.save(persona);
	try {
		personaService.save(persona);
		String content = "Name: " + persona.getNombre();
		content += "<br>Apellido: " + persona.getApellido();
		content += "<br>Fecha: " + persona.getCreateAt();		
		personaService.send("leo23au@gmail.com", persona.getEmail(), "Préstamo", content);
		modelMap.put("msg", "Done!");
		
	} catch (Exception e) {
		modelMap.put("msg", e.getMessage());
	}
		return "redirect:/persona/listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			personaService.delete(id);
		}
		return "redirect:/persona/listar";
	}
}
