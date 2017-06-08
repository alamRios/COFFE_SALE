package com.coffeSale.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public @ResponseStatus(value = HttpStatus.OK) void create(@RequestBody VentaEnTienda venta){
		logger.info("Se inicia creacion de venta...");
	}
	
	@RequestMapping(value = "/{cafeteriaId}", method = RequestMethod.GET)
	public @ResponseBody List<Venta> getByCafeteria(@PathVariable String cafeteriaId){
		logger.info("Recuperando ventas de cafeteria con id "+cafeteriaId+"...");
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ventas.add(new VentaEnTienda(new Empleado("Alejandro","Maguey","Renteria","2016630"),
				new Gaveta(500,8000.5),800,new Date()));
		ventas.add(new VentaEnTienda(new Empleado("Alejandro","Maguey","Renteria","2016630"),
				new Gaveta(500,8000.5),500,new Date()));
		return ventas; 
	}
	
	@RequestMapping(value = "/{cafeteriaId}/{fechaInicio}/{fechaFin}", method = RequestMethod.GET)
	public @ResponseBody List<Venta> getByCafeteriaAndFechas(@PathVariable String cafeteriaId,
			@PathVariable String fechaInicio, @PathVariable String fechaFin){
		logger.info("Recuperando ventas de cafeteria con id "+cafeteriaId+"...");
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try{
		ventas.add(new VentaEnTienda(new Empleado("Alejandro","Maguey","Renteria","2016630"),
				new Gaveta(500,8000.5),800,dateFormat.parse(fechaInicio)));
		ventas.add(new VentaEnTienda(new Empleado("Alejandro","Maguey","Renteria","2016630"),
				new Gaveta(500,8000.5),500,dateFormat.parse(fechaFin)));
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return ventas; 
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
