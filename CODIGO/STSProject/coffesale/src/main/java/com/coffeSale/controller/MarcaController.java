package com.coffeSale.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.coffeSale.model.dao.MarcaDAO;
import com.coffeSale.model.dto.Marca;


@Controller
@RequestMapping(value = "/rest/lineas/")
public class MarcaController {
	private static final Logger logger = LoggerFactory.getLogger(MarcaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	MarcaDAO marcaDAO = context.getBean(MarcaDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseStatus(value = HttpStatus.OK) void create(@RequestBody Marca marca){
		logger.info("Se inicia creacion de marca...");
		try{
			marcaDAO.persist(marca);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseStatus(value = HttpStatus.OK) void update(@RequestBody Marca marca){
		logger.info("Actualizando linea "+marca.getNombre()+"...");
		try{
			marcaDAO.update(marca);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Marca> getAll(){
		logger.info("Se inicia recuperacion de todas las marcas...");
		List<Marca> marcas = new ArrayList<Marca>();
		try{
			marcas = marcaDAO.findAll_DTO();
		}catch(Exception ex){
			logger.info(ex.getMessage());
			marcas.add(new Marca("Error","Error"));
		}
		return marcas; 
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody Marca marca){
		logger.info("Se inicia eliminacion de marca "+marca.getNombre()+"...");
		try{
			marcaDAO.delete(marca);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
	}
}
