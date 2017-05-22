package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.GavetaDTO;
import com.coffeSale.model.entity.Gaveta;

public interface GavetaDAO extends GenericDAO<Gaveta>{
	public List<GavetaDTO> findAll_DTO() throws Exception;
	public GavetaDTO findById_DTO(int id) throws Exception; 
	public List<GavetaDTO> findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
}
