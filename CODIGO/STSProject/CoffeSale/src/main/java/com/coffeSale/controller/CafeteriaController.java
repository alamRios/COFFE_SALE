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

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.Cafeteria;

@Controller
@RequestMapping(value = "/rest/cafeterias/")
public class CafeteriaController {
	private static final Logger logger = LoggerFactory.getLogger(CafeteriaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CafeteriaDAO cafeteriaDAO = context.getBean(CafeteriaDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes="application/json")
	public @ResponseStatus(value = HttpStatus.OK) void create(@RequestBody Cafeteria cafeteria){
		logger.info("Se inicia creacion de cafeteria...");
		try{
			cafeteriaDAO.persist(cafeteria);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
	}
	
	@RequestMapping(value="/{lineaId}/{cafeteriaNombre}", method = RequestMethod.GET)
	public @ResponseBody Cafeteria getById(@PathVariable int lineaId, @PathVariable String cafeteriaNombre){
		Cafeteria cafeteria = new Cafeteria(); 
		try{
			 cafeteria = cafeteriaDAO.findByLineaYNombre_DTO(lineaId, cafeteriaNombre);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return cafeteria; 
	}
	
	@RequestMapping(value="/{lineaId}", method = RequestMethod.GET)
	public @ResponseBody List<Cafeteria> getByLineaId(@PathVariable int lineaId){
		logger.info("Se inicia recuperacion de cafeterias de: "+lineaId);
		List<Cafeteria> cafeterias = new ArrayList<Cafeteria>();
		try{
			cafeterias = cafeteriaDAO.findByLinea_DTO(lineaId);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return cafeterias; 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes="application/json")
	@ResponseBody
	public @ResponseStatus(value = HttpStatus.OK) Cafeteria update(@RequestBody Cafeteria cafeteria){
		logger.info("Actualizando cafeteria "+cafeteria.getNombre()+"...");
		try{
			return cafeteriaDAO.update(cafeteria);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			return new Cafeteria(); 
		}
	}
}
