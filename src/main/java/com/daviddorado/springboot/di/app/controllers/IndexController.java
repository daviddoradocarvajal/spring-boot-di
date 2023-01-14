package com.daviddorado.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daviddorado.springboot.di.app.models.services.IMyService;

@Controller
public class IndexController {
	
	@Autowired	
	private IMyService servicio;
	
	@Autowired
	@Qualifier("miServicioSimple")
	private IMyService servicio2;
	
	@Autowired
	@Qualifier("ServicioBean")
	private IMyService servicio3;
	
	@GetMapping({"/complex", ""})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operation("Palabro"));
		return "index";
	}
	@GetMapping({"/simple", "/"})
	public String indexDos(Model model) {		
		model.addAttribute("objeto", servicio2.operation("Palabro"));
		return "index";
	}
	
	@GetMapping("/bean")
	public String indexBean(Model model) {
		model.addAttribute("objeto", servicio3.operation("Palabro"));
		return "index";
	}
	
//	@Autowired
//	public void setServicio(IMyService servicio) {
//		this.servicio = servicio;
//	}
	
	// Si se pasa un componente manejado por Spring (Anotado con Component o derivados) inyecta automáticamente
//	public IndexController(IMyService servicio) {
//		this.servicio = servicio;
//	}
	
	
	
	
}
