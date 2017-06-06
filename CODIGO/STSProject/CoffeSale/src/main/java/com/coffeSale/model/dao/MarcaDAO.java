package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Marca;
import com.coffeSale.model.entity.MarcaEntity;

public interface MarcaDAO extends GenericDAO<MarcaEntity>{
	public List<Marca> findAll_DTO() throws Exception;
	public Marca findById_DTO(int id) throws Exception; 
}
