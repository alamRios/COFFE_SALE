package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Marca;
import com.coffeSale.model.entity.MarcaEntity;

public interface MarcaDAO extends GenericDAO<MarcaEntity>{
	public List<Marca> findAll_DTO() throws Exception;
	public Marca findByNombre_DTO(String nombre) throws Exception; 
	public void persist(Marca marca) throws Exception;
	public void update(Marca marca) throws Exception;
	public void delete(Marca marca) throws Exception;
}
