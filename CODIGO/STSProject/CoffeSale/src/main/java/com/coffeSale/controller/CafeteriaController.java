package com.coffeSale.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffeSale.model.dto.Cafeteria;



@Controller
@RequestMapping(value = "/rest/cafeterias/")
public class CafeteriaController {
	private static final Logger logger = LoggerFactory.getLogger(CafeteriaController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Cafeteria createCafeteria(@RequestBody Cafeteria cafeteria){
		logger.info("Se inicia creacion de cafeteria...");
		return cafeteria;
	}
}
