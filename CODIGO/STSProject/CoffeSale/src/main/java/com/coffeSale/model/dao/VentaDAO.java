package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.entity.Venta;
import com.coffeSale.model.dto.VentaDTO; 

public interface VentaDAO extends GenericDAO<Venta>{
	public List<VentaDTO> findAll_DTO() throws Exception;
	public VentaDTO findById_DTO() throws Exception; 
	public List<VentaDTO> findVentasByCafeteria() throws Exception; 
	public void save(Venta venta) throws Exception; 
}
