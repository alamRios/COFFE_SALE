package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.entity.Venta;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.VentaDTO; 

public interface VentaDAO extends GenericDAO<Venta>{
	public List<VentaDTO> findAll_DTO() throws Exception;
	public VentaDTO findById_DTO(int id) throws Exception; 
	public List<VentaDTO> findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
}
