package com.coffeSale.controller;

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

import com.coffeSale.model.dao.UsuarioDAO;
import com.coffeSale.model.dto.Usuario;

@Controller
@RequestMapping(value="/rest/usuarios")
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	UsuarioDAO usuarioDAO = context.getBean(UsuarioDAO.class);
	
	@RequestMapping(value="/login", method = RequestMethod.POST, 
			consumes="application/json")
	@ResponseBody
	public @ResponseStatus(value = HttpStatus.OK) Usuario login(@RequestBody Usuario usuario){
		logger.info(usuario.getNombre() + " haciendo login...");
		try{
			return usuarioDAO.validarLogIn(usuario);
		}catch(Exception ex){
			logger.warn(ex.getMessage());
			return new Usuario(
					"Usuario incorrecto",0,"Password incorrecto");
		}
	}
}
