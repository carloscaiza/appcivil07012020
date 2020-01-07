package com.labcivil.app.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.labcivil.app.models.entity.Estudiante;
import com.labcivil.app.models.entity.Materia;
import com.labcivil.app.models.entity.Prestamo;
import com.labcivil.app.models.entity.Profesor;
import com.labcivil.app.models.entity.Proyector;
import com.labcivil.app.models.entity.Registro;
import com.labcivil.app.models.service.IEstudianteService;
import com.labcivil.app.models.service.IMateriaService;
import com.labcivil.app.models.service.IPrestamoService;
import com.labcivil.app.models.service.IProfesorService;
import com.labcivil.app.models.service.IProyectorService;

@Controller
@SessionAttributes("prestamo")
public class PrestamoController {

	@Autowired
	private IPrestamoService prestamoService;

	@Autowired
	private IProyectorService proyectorService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IProfesorService profesorService;
	
	private String dateStart = "";
	private String dateEnd = "";
	private String date = "";
	private String timeStart = "";
	private String timeEnd = "";		

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Prestamo prestamo = prestamoService.findOne(id);

		if (prestamo == null) {
			flash.addFlashAttribute("error", "El prestamo  no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("prestamo", prestamo);
		model.put("titulo", "Detalle prestamo: " + prestamo.getId());
		return "ver";
	}

	@RequestMapping(value = { "/listar", "/" }, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Prestamos");
//		model.addAttribute("prestamos", prestamoService.findAll());
//		model.addAttribute("prestamos", prestamoService.findAllP());

		model.addAttribute("prestamos", prestamoService.findAllEstadoTer());
		model.addAttribute("prestamos1", prestamoService.findAllEstadoAct());
		
//		for(Prestamo prestamos : prestamoService.findAllP() ){
//			System.out.println(prestamos.toString());
//		}
		return "listar";
	}
	
	@RequestMapping(value = "/sendFecha")
	public String sendDate(Model model,
			@RequestParam(value = "fechaIn", required = false) String fechaIn,
			@RequestParam(value = "fechaFn", required = false) String fechaFn ){
		
		dateStart = fechaIn;
		dateEnd = fechaFn;
		
		model.addAttribute("titulo", "Listado de Prestamos por fecha");		
//		System.out.println(fechaIn);
//		System.out.println(fechaFn);
		return "sendFecha";
	}

	@RequestMapping(value = "/listadoFecha", method = RequestMethod.GET)
	public String listarDate(Model model) throws ParseException {

		model.addAttribute("titulo", "Listado de Prestamos por fecha");
		
		if(dateStart!=null && dateEnd!=null) {
			model.addAttribute("prestamos", prestamoService.findAllBetween(new SimpleDateFormat("yyyy-MM-dd").parse(dateStart),new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd)));
//			model.addAttribute("prestamos", prestamoService.findAllEstadoTer());
//			model.addAttribute("prestamos, prestamoService.findAllBetween(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-04"),new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-04")));
		}
		
//		for(Prestamo prestamos : prestamoService.findAllP() ){
//		for(Prestamo prestamos : prestamoService.findAllBetween(new SimpleDateFormat("yyyy-MM-dd").parse(fechaIn),new SimpleDateFormat("yyyy-MM-dd").parse(fechaFn))){
//			System.out.println(prestamos.toString());
//		}
		return "listadoFecha";
	}
	
	
	@RequestMapping(value = "/sendHora")
	public String sendTime(Model model,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "horaIn", required = false) String horaIn,
			@RequestParam(value = "horaFn", required = false) String horaFn ){			
		
		date = fecha;
		timeStart = horaIn;
		timeEnd = horaFn;
		
		model.addAttribute("titulo", "Listado de Prestamos por Fecha y Hora");		
//		System.out.println(fecha);
//		System.out.println(horaIn);
//		System.out.println(horaFn);
		return "sendHora";
	}
	
	@RequestMapping(value = "/listadoHora", method = RequestMethod.GET)
	public String listarTime(Model model) throws ParseException {

		model.addAttribute("titulo", "Listado de Prestamos por fecha y hora");
		
		if(date != null && timeStart!=null && timeEnd!=null) {
//			model.addAttribute("prestamos", prestamoService.findAllBetween(new SimpleDateFormat("yyyy-MM-dd").parse(dateStart),new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd)));
			model.addAttribute("prestamos", prestamoService.findAllBetweenTime(new SimpleDateFormat("yyyy-MM-dd").parse(date), new SimpleDateFormat("HH:mm").parse(timeStart), new SimpleDateFormat("HH:mm").parse(timeEnd)));
		}
		return "listadoHora";
	}
	
//	@RequestMapping(value = {"/listar","/"}, method = RequestMethod.GET)
//	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//
//		Pageable pageRequest = PageRequest.of(page, 5);
//
//		Page<Prestamo> prestamos = prestamoService.findAll(pageRequest);
//
//		PageRender<Prestamo> pageRender = new PageRender<>("/listar", prestamos);
//
//		model.addAttribute("titulo", "Listado de Prestamos");
//		model.addAttribute("prestamos", prestamos);
//		model.addAttribute("page", pageRender);
//		return "listar";
//	}

	@GetMapping(value = "/cargar-registros/{term}", produces = { "application/json" })
	public @ResponseBody List<Registro> cargarRegistros(@PathVariable String term) {
		return prestamoService.findByObservacion(term);
	}

	@GetMapping(value = "/cargar-proyectores/{term}", produces = { "application/json" })
	public @ResponseBody List<Proyector> cargarProyectores(@PathVariable String term) {
		return prestamoService.findByEstatusAndAlta(term);
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Prestamo prestamo = new Prestamo();
		model.put("prestamo", prestamo);
		model.put("titulo", "Formulario de Prestamo");
		return "form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Prestamo prestamo, BindingResult result, Model model,
			@RequestParam(name = "buscar_registro_id", required = false) Long regId,
			@RequestParam(name = "buscar_proyector_id", required = false) Long proyId,
			@RequestParam(name = "registro_emailEs") String emailEs,
			@RequestParam(name = "cableH", required = false) String cableH,
			@RequestParam(name = "parlante", required = false) String parlante,
			@RequestParam(name = "extension", required = false) String extension,
			@RequestParam(name = "regleta", required = false) String regleta,
			@RequestParam(name = "puntero", required = false) String puntero, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Prestamos");
			return "form";
		}

		Registro registro = prestamoService.findRegistroById(regId);
		Proyector proyector = prestamoService.findProyectorById(proyId);
		
		Long idMat = registro.getMateria().getId();
		Long idEst = registro.getEstudiante().getId();
		Long idProf = registro.getProfesor().getId();
		
		Materia materia = materiaService.findOne(idMat);
		materia.setNumprestamo(materia.getNumprestamo()+1);
		materiaService.save(materia);
		
		Estudiante estudiante = estudianteService.findOne(idEst);
		estudiante.setNumprestamo(estudiante.getNumprestamo()+1);
		estudianteService.save(estudiante);
		
		Profesor profesor = profesorService.findOne(idProf);
		profesor.setNumprestamo(profesor.getNumprestamo()+1);
		profesorService.save(profesor);
		
		
		String estatus = "Ocupado";
		proyector.setEstatus(estatus);
		proyectorService.save(proyector);
		
		String accesorios = "";
		if (cableH == null) {
			cableH = "";
		} else {
			accesorios = accesorios + cableH + ". ";
		}
		if (parlante == null) {
			parlante = "";
		} else {
			accesorios = accesorios + parlante + ". ";
		}
		if (extension == null) {
			extension = "";
		}else {
			accesorios = accesorios +extension +". ";
		}
		if (regleta == null) {
			regleta = "";
		}else {
			accesorios = accesorios +regleta +". ";
		}
		if (puntero == null) {
			puntero = "";
		}else {
			accesorios = accesorios +puntero +". ";
		}
		//accesorios = cableH + ", " + parlante + ", " + extension + ", " + regleta + ", " + puntero;

		prestamo.setObservacion(accesorios);

		prestamo.setRegistro(registro);
		prestamo.setProyector(proyector);

		try {
			prestamoService.save(prestamo);
			status.setComplete();
			flash.addFlashAttribute("success", "Prestamo creado con éxito");
			
			String content = "<b>Detalle de Préstamo</b><br><b>Estudiante: </b>" + prestamo.getRegistro().getEstudiante().getNombre() +" "+prestamo.getRegistro().getEstudiante().getApellido();
			content += "<br><b>Docente: </b>" + prestamo.getRegistro().getProfesor().getNombre() +" "+prestamo.getRegistro().getProfesor().getApellido();
			content += "<br><b>Fecha: </b>" + prestamo.getCreatePr();
			content += "<br><b>Alta Proyector: </b>" + prestamo.getProyector().getAlta();
			content += "<br><b>Materia: </b>" + prestamo.getRegistro().getMateria().getNombre();
			content += "<br><b>Accesorios: </b>" + prestamo.getObservacion();
			prestamoService.send("leo23au@gmail.com", emailEs, "Préstamo Proyector", content);
			model.addAttribute("msg", "Done!");
			
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
		}

//		prestamoService.save(prestamo);
//		status.setComplete();
//		flash.addFlashAttribute("success", "Prestamo creado con éxito");
		return "redirect:/listar";

	}

	@RequestMapping(value = "/form1/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Prestamo prestamo = null;

		if (id > 0) {
			prestamo = prestamoService.findOne(id);				
			if (prestamo == null) {
				flash.addFlashAttribute("error", "El ID del préstamo no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del préstamo no puede ser cero!");
			return "redirect:/listar";
		}

		Long idPro = prestamo.getProyector().getId();
		model.put("idPro", idPro);
		model.put("prestamo", prestamo);
		model.put("titulo", "Editar Prestamo");
		return "form1";
	}

	@PostMapping("/form1")
	public String guardar1(@Valid Prestamo prestamo, BindingResult result, Model model,
			@RequestParam(name = "idPro", required = false) Long idPro, 
			@RequestParam(name = "horaFn", required = false) String horaFn,
			RedirectAttributes flash, SessionStatus status) throws ParseException {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Prestamos");
			return "form";
		}
		
		Date horaInicioP=null;
		Date horaFinalP=null;
		
		horaInicioP = prestamo.getHoraIn();
		horaFinalP = new SimpleDateFormat("HH:mm").parse(horaFn);		
		
	    Date difference = getDifferenceBetwenDates(horaInicioP, horaFinalP);
//	    System.out.println(new SimpleDateFormat("HH:mm:ss").format(difference));
	    
	    long milliseconds = difference.getTime();
	    int segundos = (int) (milliseconds / 1000) % 60;
	    int minutos = (int) ((milliseconds / (1000 * 60)) % 60);
	    int hora = (int) (((milliseconds / (1000 * 60 * 60)) % 24)-5);
	    
//	    System.out.println("HORA: "+ hora);
//	    System.out.println("MINUTOS: "+ minutos);
//	    System.out.println("SEGUNDOS: "+ segundos);
	    	    
		Proyector proyector = prestamoService.findProyectorById(idPro);
		String horaUsed = proyector.getHoursUsed();
		String[] horaU = horaUsed.split(":");
		
		int segundosU =  Integer.parseInt(horaU[2]);
		int minutosU = Integer.parseInt(horaU[1]);
		int horasU = Integer.parseInt(horaU[0]);
		
//		System.out.println("-------------------------------");
//	    System.out.println("HORAUSED: "+ horasU);
//	    System.out.println("MINUTOSUSED: "+ minutosU);
//	    System.out.println("SEGUNDOSUSED: "+ segundosU);
//	    System.out.println("-------------------------------");
			    
	    int segundosum = segundos + segundosU;
	    int minutosum = minutos + minutosU;
	    int horasum = hora+horasU;
	    if (segundosum >=60 && minutosum<=60) {
	    	segundosum = segundosum-60;
	    	minutosum = minutosum+1;
	    }
	    
	    if (minutosum >=60 ) {
	    	minutosum = minutosum-60;
	    	horasum = horasum+1;
	    }
	    
//	    System.out.println("HORASUM: "+ horasum);
//	    System.out.println("MINUTOSSUM: "+ minutosum);
//	    System.out.println("SEGUNDOSSUM: "+ segundosum);
	    
	    String horaSuma=Integer.toString(horasum);
	    String minutoSuma=Integer.toString(minutosum);
	    String segundoSuma=Integer.toString(segundosum);
	    String horaSumaFinal="";
//	    String horaSumaFinal=horaSuma+":"+minutoSuma+":"+segundoSuma;
	    
	    if("0".equals(segundoSuma) || "1".equals(segundoSuma) || "2".equals(segundoSuma) || "3".equals(segundoSuma)
	    		|| "4".equals(segundoSuma) || "5".equals(segundoSuma) || "6".equals(segundoSuma) || "7".equals(segundoSuma)
	    		|| "8".equals(segundoSuma) || "9".equals(segundoSuma)){
	    	segundoSuma = "0"+segundoSuma;
	    }
	    
	    if("0".equals(minutoSuma) || "1".equals(minutoSuma) || "2".equals(minutoSuma) || "3".equals(minutoSuma)
	    		|| "4".equals(minutoSuma) || "5".equals(minutoSuma) || "6".equals(minutoSuma) || "7".equals(minutoSuma)
	    		|| "8".equals(minutoSuma) || "9".equals(minutoSuma)) {
	    	minutoSuma = "0"+minutoSuma;
	    }
	    
	    if("0".equals(horaSuma) || "1".equals(horaSuma) || "2".equals(horaSuma) || "3".equals(horaSuma)
	    		|| "4".equals(horaSuma) || "5".equals(horaSuma) || "6".equals(horaSuma) || "7".equals(horaSuma)
	    		|| "8".equals(horaSuma) || "9".equals(horaSuma)) {
	    	horaSuma = "0"+horaSuma;
	    }

	    	horaSumaFinal=horaSuma+":"+minutoSuma+":"+segundoSuma;
	    
//	    System.out.println("HORA SUMA FINAL: "+ horaSumaFinal);
	    
		String estatus = "Disponible";
		proyector.setEstatus(estatus);
		proyector.setNumprestamo(proyector.getNumprestamo()+1);
		proyector.setHoursUsed(horaSumaFinal);
		
		proyectorService.save(proyector);
		
		String estado = "Terminado";
		prestamo.setEstado(estado);
		
		prestamoService.save(prestamo);
		
		status.setComplete();
		flash.addFlashAttribute("success", "Préstamo terminado | editado  con éxito");
		return "redirect:/listar";

	}

	// Eliminar sin foto
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			prestamoService.delete(id);
			flash.addFlashAttribute("success", "Registro eliminado con éxito");
		}
		return "redirect:/listar";
	}
	
	
	public static Date getDifferenceBetwenDates(Date dateInicio, Date dateFinal) {
	    long milliseconds = dateFinal.getTime() - dateInicio.getTime();
	    int seconds = (int) (milliseconds / 1000) % 60;
	    int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
	    int hours = (int) ((milliseconds / (1000 * 60 * 60)));
//	    int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.SECOND, seconds);
	    c.set(Calendar.MINUTE, minutes);
	    c.set(Calendar.HOUR_OF_DAY, hours);
	    return c.getTime();
	}
	
}
