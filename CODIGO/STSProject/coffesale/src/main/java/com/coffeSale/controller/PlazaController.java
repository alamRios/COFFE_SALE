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

import com.coffeSale.model.dao.PlazaDAO;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Plaza;

@Controller
@RequestMapping(value="/rest/plazas")
public class PlazaController {	
	private static final Logger logger = LoggerFactory.getLogger(PlazaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	PlazaDAO plazaDAO = context.getBean(PlazaDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseStatus(value = HttpStatus.OK) void create(@RequestBody Plaza plaza){
		logger.info("Se inicia creacion de plaza...");
	}
	
	@RequestMapping(value="/{plantillaId}/{plazaId}", method = RequestMethod.GET)
	public @ResponseBody Plaza getById(@PathVariable String plantillaId, @PathVariable String plazaId){
		return new Plaza(new Empleado("Alejandro","Maguey","Renteria","2016630"),"123",true);
	}
	
	@RequestMapping(value="/{plantillaId}", method = RequestMethod.GET)
	public @ResponseBody List<Plaza> getByPlantillaId(@PathVariable String plantillaId){
		ArrayList<Plaza> plazas = new ArrayList<Plaza>();
		plazas.add(new Plaza(new Empleado("Alejandro","Maguey","Renteria","2016630-01"),"123",true));
		plazas.add(new Plaza(new Empleado("Alam Yael","Rios","Altamirano","2016630-02"),"321",true));  
		
		return plazas; 
	}
}
