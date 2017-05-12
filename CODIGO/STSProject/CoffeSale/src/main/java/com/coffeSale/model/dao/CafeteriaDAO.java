package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.entity.Cafeteria;

public interface CafeteriaDAO extends GenericDAO<Cafeteria>{
	public List<CafeteriaDTO> findAll_DTO() throws Exception;
	public CafeteriaDTO findById_DTO(int id) throws Exception;
}
