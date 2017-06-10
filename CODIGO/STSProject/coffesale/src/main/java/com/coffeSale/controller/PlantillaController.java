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

import com.coffeSale.model.dao.PlantillaDAO;				
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Plantilla;
import com.coffeSale.model.dto.Plaza;

@Controller
@RequestMapping(value="/rest/plantillas/")
public class PlantillaController {
	private static final Logger logger = LoggerFactory.getLogger(PlantillaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	PlantillaDAO plantillaDAO = context.getBean(PlantillaDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseStatus(value = HttpStatus.OK) void create(@RequestBody Plantilla plantilla){
		logger.info("Se inicia creacion de plantilla...");
	}
	
	@RequestMapping(value="/{cafeteriaId}/{plantillaId}", method = RequestMethod.GET)
	public @ResponseBody Plantilla getById(@PathVariable String cafeteriaId, @PathVariable String plantillaId){
		ArrayList<Plaza> plazas = new ArrayList<Plaza>();
		plazas.add(new Plaza(new Empleado("Alejandro","Maguey","Renteria",2016630),"123",true));
		return new Plantilla(plazas,plantillaId,1);
	}
	
	@RequestMapping(value="/{cafeteriaId}", method = RequestMethod.GET)
	public @ResponseBody List<Plantilla> getByCafeteriaId(@PathVariable String cafeteriaId){
		List<Plantilla> plantillas = new ArrayList<Plantilla>();
		
		ArrayList<Plaza> plazas = new ArrayList<Plaza>();
		plazas.add(new Plaza(new Empleado("Alejandro","Maguey","Renteria",2016630),"123",true));
		
		plantillas.add(new Plantilla(plazas,cafeteriaId+"-01",1));
		plantillas.add(new Plantilla(plazas,cafeteriaId+"-02",1));
		
		return plantillas; 
	}	
}
