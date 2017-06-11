package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Inventario;
import com.coffeSale.model.entity.InventarioEntity;

public interface InventarioDAO extends GenericDAO<InventarioEntity>{
	public List<Inventario> findAll_DTO() throws Exception;
	public Inventario findById_DTO(int id) throws Exception; 
	public Inventario findByCafeteria(Cafeteria cafeteria) throws Exception;
}
