package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.CajaFuerteDTO;
import com.coffeSale.model.entity.CajaFuerte;

public interface CajaFuerteDAO extends GenericDAO<CajaFuerte>{
	public List<CajaFuerteDTO> findAll_DTO() throws Exception;
	public CajaFuerteDTO findById_DTO(int id) throws Exception; 
	public CajaFuerteDTO findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
}
