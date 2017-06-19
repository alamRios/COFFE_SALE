package com.coffeSale.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffeSale.model.dao.GavetaDAO;
import com.coffeSale.model.dto.Gaveta;

@Controller
@RequestMapping(value="/rest/gavetas/")
public class GavetaController {
	private static final Logger logger = LoggerFactory.getLogger(PlazaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	GavetaDAO gavetaDAO = context.getBean(GavetaDAO.class);
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Gaveta> getAll(){
		logger.info("Recuperando todas las Gavetas...");
		List<Gaveta> gavetas = new ArrayList<Gaveta>();
		try{
			gavetas = gavetaDAO.findAll_DTO();
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return gavetas; 
	}
}
