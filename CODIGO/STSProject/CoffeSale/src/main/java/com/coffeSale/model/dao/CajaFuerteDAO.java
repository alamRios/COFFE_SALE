package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.CajaFuerte;
import com.coffeSale.model.entity.CajaFuerteEntity;

public interface CajaFuerteDAO extends GenericDAO<CajaFuerteEntity>{
	public List<CajaFuerte> findAll_DTO() throws Exception;
	public CajaFuerte findById_DTO(int id) throws Exception; 
	public CajaFuerte findByCafeteria(Cafeteria cafeteria) throws Exception;
}
