package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.PlantillaDTO;
import com.coffeSale.model.entity.Plantilla;

public interface PlantillaDAO extends GenericDAO<Plantilla>{
	public List<PlantillaDTO> findAll_DTO() throws Exception;
	public PlantillaDTO findById_DTO(int id) throws Exception; 
	public PlantillaDTO findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
}
