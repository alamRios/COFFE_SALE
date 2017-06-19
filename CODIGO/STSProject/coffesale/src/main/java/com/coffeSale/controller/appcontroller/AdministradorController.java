package com.coffeSale.controller.appcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministradorController {
	@RequestMapping("/inicio")
	public String redirInicio(Model model){
		return "admin/inicio";
	}
	
	@RequestMapping("/productos")
	public String redirProductos(Model model){
		return "productos/inicio";
	}
	
	@RequestMapping("/cafeterias")
	public String redirCafeterias(Model model){
		return "cafeterias/inicio";
	}
	
	@RequestMapping("/empleados")
	public String redirEmpleados(Model model){
		return "empleados/inicio";
	}
}
