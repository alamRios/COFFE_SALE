package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.MembresiaClienteDTO;
import com.coffeSale.model.entity.Cliente;

public interface MembresiaClienteDAO extends GenericDAO<Cliente>{
	public List<MembresiaClienteDTO> findAll_DTO() throws Exception;
	public MembresiaClienteDTO findById_DTO(int id) throws Exception; 
	public MembresiaClienteDTO findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
	public List<MembresiaClienteDTO> findByNombre(String nombre) throws Exception; 
}
