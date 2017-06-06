package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.MembresiaCliente;
import com.coffeSale.model.entity.ClienteEntity;

public interface MembresiaClienteDAO extends GenericDAO<ClienteEntity>{
	public List<MembresiaCliente> findAll_DTO() throws Exception;
	public MembresiaCliente findById_DTO(int id) throws Exception; 
	public MembresiaCliente findByCafeteria(Cafeteria cafeteria) throws Exception;
	public List<MembresiaCliente> findByNombre(String nombre) throws Exception; 
}
