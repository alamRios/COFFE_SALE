package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.InventarioDTO;
import com.coffeSale.model.entity.Inventario;

public interface InventarioDAO extends GenericDAO<Inventario>{
	public List<InventarioDTO> findAll_DTO() throws Exception;
	public InventarioDTO findById_DTO(int id) throws Exception; 
	public InventarioDTO findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
}
