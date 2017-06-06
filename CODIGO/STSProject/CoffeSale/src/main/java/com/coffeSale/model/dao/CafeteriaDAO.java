package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.entity.CafeteriaEntity;

public interface CafeteriaDAO extends GenericDAO<CafeteriaEntity>{
	public List<Cafeteria> findAll_DTO() throws Exception;
	public List<Cafeteria> findByNombre_DTO(String nombre) throws Exception;
	public Cafeteria findById_DTO(int id) throws Exception;
}
