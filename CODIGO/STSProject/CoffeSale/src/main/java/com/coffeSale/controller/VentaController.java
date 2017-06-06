package com.coffeSale.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffeSale.model.dao.VentaDAO;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Gaveta;
import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;

@Controller
@RequestMapping(value = "/rest/ventas/")
public class VentaController {
	private static final Logger logger = LoggerFactory.getLogger(VentaController.class);
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	VentaDAO ventaDAO = context.getBean(VentaDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Venta createVentaTienda(@RequestBody VentaEnTienda venta){
		logger.info("Se inicia creacion de venta...");
		venta.setMomentoVenta(new Date());
		return venta;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Venta getVenta(@PathVariable("id") int ventaId){
		logger.info("Recuperando venta con id "+ventaId+"...");
		return new VentaEnTienda();
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Venta> getAllVentas(){
		logger.info("Se inicia recuperacion de todas las ventas...");
		List<Venta> ventas = new ArrayList<Venta>();
		try{
			ventas = ventaDAO.findAll_DTO();
		}catch(Exception ex){
			logger.info(ex.getMessage());
			ventas.add((Venta)new VentaEnTienda(
					new Empleado("ERROR","ERROR","ERROR",ex.getMessage()),
					new Gaveta(0,0),
					0,
					new Date()
					));
		}
		return ventas; 
	}
}
