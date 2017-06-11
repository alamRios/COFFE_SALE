package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.entity.VentaEntity;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Venta; 

public interface VentaDAO extends GenericDAO<VentaEntity>{
	public List<Venta> findAll_DTO() throws Exception;
	public Venta findById_DTO(int id) throws Exception; 
	public List<Venta> findByCafeteria(Cafeteria cafeteria) throws Exception;
}
