package com.coffeSale.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffeSale.model.dao.UtileriaDAO;
import com.coffeSale.model.entity.PuestoEntity;

@Controller
@RequestMapping(value="/rest/util")
public class UtilidadController {
	private static final Logger logger = LoggerFactory.getLogger(UtilidadController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	UtileriaDAO utilidadDAO = context.getBean(UtileriaDAO.class);
	
	@RequestMapping(value="/puestos")
	@ResponseBody
	public List<PuestoEntity> getAllPuestos(){
		logger.info("Recuperando puestos...");
		List<PuestoEntity> puestos;
		try{
			puestos = utilidadDAO.getPuestos();
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			puestos = new ArrayList<PuestoEntity>();
		}
		return puestos; 
	}
}
