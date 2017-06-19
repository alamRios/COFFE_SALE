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

import com.coffeSale.model.dao.ProductoDAO;
import com.coffeSale.model.dto.Producto;

@Controller
@RequestMapping(value="/rest/productos")
public class ProductoController {
	private static final Logger logger = LoggerFactory.getLogger(PlazaController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	ProductoDAO productoDAO = context.getBean(ProductoDAO.class);
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Producto> getAll(){
		logger.info("Recuperando productos...");
		List<Producto> productos = new ArrayList<Producto>();
		try{
			productos = productoDAO.findAll_DTO();
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return productos; 
	}
	
	@RequestMapping(value="/{lineaId}", method = RequestMethod.GET)
	public @ResponseBody List<Producto> getByLinea(@PathVariable int lineaId){
		logger.info("Recuperando productos de "+lineaId+"...");
		List<Producto> productos = new ArrayList<Producto>();
		try{
			productos = productoDAO.findByLinea(lineaId);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
		return productos; 
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public @ResponseStatus(value = HttpStatus.OK) Producto create(@RequestBody Producto producto){
		logger.info("Se inicia creacion de producto...");
		try{
			return productoDAO.persist(producto);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			return new Producto(); 
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes="application/json")
	public void delete(@RequestBody Producto producto){
		logger.info("Se inicia eliminacion de producto "+producto.getIdentificador()+":"
				+producto.getNombre()+"...");
		try{
			productoDAO.delete(producto);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes="application/json")
	@ResponseBody
	public @ResponseStatus(value = HttpStatus.OK) Producto update(@RequestBody Producto producto){
		logger.info("Actualizando producto "+producto.getNombre()+"...");
		try{
			return productoDAO.update(producto);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			return new Producto();
		}
	}
}
