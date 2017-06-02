package com.coffeSale.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffeSale.model.dto.VentaDTO;
import com.coffeSale.model.dto.VentaEnTiendaDTO;

@Controller
@RequestMapping(value = "/rest/ventas/")
public class VentaController {
	private static final Logger logger = LoggerFactory.getLogger(VentaController.class);
	
	Map<Integer,VentaDTO> ventaData = new HashMap<Integer, VentaDTO>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody VentaDTO createVentaTienda(@RequestBody VentaEnTiendaDTO venta){
		logger.info("Se inicia creacion de venta...");
		venta.setMomentoVenta(new Date());
		ventaData.put((int)venta.getMontoTotal(), venta);
		return venta;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody VentaDTO getVenta(@PathVariable("id") int ventaId){
		logger.info("Recuperando venta con id "+ventaId+"...");
		return ventaData.get(ventaId);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<VentaDTO> getAllVentas(){
		logger.info("Se inicia recuperacion de todas las ventas...");
		List<VentaDTO> ventas = new ArrayList<VentaDTO>();
		Set<Integer> ventasIds = ventaData.keySet();
		for(Integer i : ventasIds){
			ventas.add(ventaData.get(i));
		}
		return ventas; 
	}
}
