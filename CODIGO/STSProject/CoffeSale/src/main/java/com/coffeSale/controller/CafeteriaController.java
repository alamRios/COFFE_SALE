package com.coffeSale.controller;

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

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.CajaFuerte;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Gaveta;
import com.coffeSale.model.dto.Habitacion;
import com.coffeSale.model.dto.Inventario;
import com.coffeSale.model.dto.Plantilla;
import com.coffeSale.model.dto.Plaza;
import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;
import com.coffeSale.model.dto.Producto;

@Controller
@RequestMapping(value = "/rest/cafeterias/")
public class CafeteriaController {
	private static final Logger logger = LoggerFactory.getLogger(CafeteriaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CafeteriaDAO cafeteriaDAO = context.getBean(CafeteriaDAO.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
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
		ArrayList<Plaza> plazas = new ArrayList<Plaza>();
		plazas.add(new Plaza(new Empleado("Alejandro","Maguey","Renteria","2016630"),"123",true));  
		ArrayList<Gaveta> gavetas = new ArrayList<Gaveta>();
		gavetas.add(new Gaveta(500,8000.5));
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ventas.add(new VentaEnTienda(new Empleado("Alejandro","Maguey","Renteria","2016630"),
				new Gaveta(500,8000.5),800,new Date()));
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>(); 
		habitaciones.add(new Habitacion("Cocina","Cocina sencilla",50,50));
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("Cafe","001",20,"Cafe solutions"));
		return new Cafeteria(
			new Plantilla(
					plazas,"0564",1),
			gavetas,
			ventas,
			habitaciones,
			new Inventario(new Date(), "IN-CA-001", productos),
			new CajaFuerte(2000,1500,new Date()),
			cafeteriaNombre, String.valueOf(lineaId), 
			String.valueOf(cafeteriaNombre.hashCode())
			);
	}
	
	@RequestMapping(value="/{lineaId}", method = RequestMethod.GET)
	public @ResponseBody List<Cafeteria> getByLineaId(@PathVariable int lineaId){
		List<Cafeteria> cafeterias = new ArrayList<Cafeteria>();
		
		ArrayList<Plaza> plazas = new ArrayList<Plaza>();
		plazas.add(new Plaza(new Empleado("Alejandro","Maguey","Renteria","2016630"),"123",true));  
		ArrayList<Gaveta> gavetas = new ArrayList<Gaveta>();
		gavetas.add(new Gaveta(500,8000.5));
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ventas.add(new VentaEnTienda(new Empleado("Alejandro","Maguey","Renteria","2016630"),
				new Gaveta(500,8000.5),800,new Date()));
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>(); 
		habitaciones.add(new Habitacion("Cocina","Cocina sencilla",50,50));
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("Cafe","001",20,"Cafe solutions"));
		
		cafeterias.add(new Cafeteria(
			new Plantilla(
					plazas,"0564",1),
			gavetas,
			ventas,
			habitaciones,
			new Inventario(new Date(), "IN-CA1-001", productos),
			new CajaFuerte(2000,1500,new Date()),
			"Primer cafeteria", String.valueOf(lineaId), 
			String.valueOf("Primer cafeteria".hashCode())
			)
		);
		
		cafeterias.add(new Cafeteria(
				new Plantilla(
						plazas,"4650",1),
				gavetas,
				ventas,
				habitaciones,
				new Inventario(new Date(), "IN-CA2-001", productos),
				new CajaFuerte(2000,1500,new Date()),
				"Segunda cafeteria", String.valueOf(lineaId), 
				String.valueOf("Segunda cafeteria".hashCode())
				)
			);
		
		return cafeterias; 
	}
	
}
