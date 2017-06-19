package com.coffeSale.model.dao;

import java.util.Date;
import java.util.List;

import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;
import com.coffeSale.model.entity.VentaEntity; 

public interface VentaDAO extends GenericDAO<VentaEntity>{
	public List<Venta> findAll_DTO() throws Exception;
	public Venta findById_DTO(int id) throws Exception; 
	public List<Venta> findByCafeteriaId(String cafeteriaId) throws Exception;
	public VentaEnTienda persist(VentaEnTienda venta) throws Exception;
	public List<Venta> findByCafeteriaIdFiltered(
			String cafeteriaId, Date fechaInicio, Date fechaFinal) throws Exception;
}
