package com.coffeSale.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.coffeSale.model.dao.EmpleadoDAO;
import com.coffeSale.model.dto.Empleado;

@Controller
@RequestMapping(value = "/rest/empleados/")
public class EmpleadoController {
	private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	EmpleadoDAO empleadoDAO = context.getBean(EmpleadoDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseStatus(value = HttpStatus.OK) void create(@RequestBody Empleado empleado){
		logger.info("Se inicia creacion de empleado...");
	}
	
	@RequestMapping(value="/{empleadoId}", method = RequestMethod.GET)
	public @ResponseBody Empleado getById(@PathVariable String empleadoId){
		return new Empleado("Alejandro","Maguey","Renteria",empleadoId);
	}
	
	@RequestMapping(value="/{cafeteriaId}/{plantillaId}", method = RequestMethod.GET)
	public @ResponseBody Empleado getByPlazaId(@PathVariable String cafeteriaId,@PathVariable String plantillaId){
		return new Empleado("Alejandro","Maguey","Renteria",String.valueOf(plantillaId.hashCode())); 
	}
}
