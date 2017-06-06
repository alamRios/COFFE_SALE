package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Gaveta;
import com.coffeSale.model.entity.GavetaEntity;

public interface GavetaDAO extends GenericDAO<GavetaEntity>{
	public List<Gaveta> findAll_DTO() throws Exception;
	public Gaveta findById_DTO(int id) throws Exception; 
	public List<Gaveta> findByCafeteria(Cafeteria cafeteria) throws Exception;
}
