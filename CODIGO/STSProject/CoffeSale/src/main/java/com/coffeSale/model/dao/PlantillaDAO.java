package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Plantilla;
import com.coffeSale.model.entity.PlantillaEntity;

public interface PlantillaDAO extends GenericDAO<PlantillaEntity>{
	public List<Plantilla> findAll_DTO() throws Exception;
	public Plantilla findById_DTO(int id) throws Exception; 
	public Plantilla findByCafeteria(Cafeteria cafeteria) throws Exception;
}
