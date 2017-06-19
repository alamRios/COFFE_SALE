package com.coffeSale.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public @ResponseStatus(value = HttpStatus.OK) Empleado create(@RequestBody Empleado empleado){
		logger.info("Se inicia creacion de empleado...");
		try{
			return empleadoDAO.persist(empleado);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			return new Empleado(); 
		}
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT, consumes="application/json")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Empleado update(@RequestBody Empleado empleado){
		logger.info("Actualizando al empleado: "+empleado.getCodigoEmpleado());
		try{
			return empleadoDAO.update(empleado);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			return new Empleado();
		}
	}
	
	@RequestMapping(value="/{lineaId}", method = RequestMethod.GET)
	public @ResponseBody List<Empleado> getById(@PathVariable int lineaId){
		logger.info("Recuperando a empleados de linea: "+lineaId);
		List<Empleado> empleados = new ArrayList<Empleado>(); 
		try{
			empleados = empleadoDAO.findByLineaId_DTO(lineaId);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return empleados; 
	}
	
	@RequestMapping(value="/usuarios/{usuarioNombre}", method = RequestMethod.GET)
	public @ResponseBody Empleado getByUsuario(@PathVariable String usuarioNombre){
		logger.info("Recuperando a empleado: "+usuarioNombre);
		Empleado empleado = new Empleado(); 
		try{
			empleado = empleadoDAO.findByUsuarioNombre_DTO(usuarioNombre);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return empleado; 
	}
	
	@RequestMapping(value="/{cafeteriaId}/{plantillaId}", method = RequestMethod.GET)
	public @ResponseBody List<Empleado> getByPlazaId(@PathVariable String cafeteriaId,@PathVariable int plantillaId){
		logger.info("Recuperando al empleado de la plantilla: "+plantillaId);
		List<Empleado> empleados = new ArrayList<Empleado>(); 
		try{
			empleados = empleadoDAO.findByPlantilla(plantillaId);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return empleados; 
	}
}
