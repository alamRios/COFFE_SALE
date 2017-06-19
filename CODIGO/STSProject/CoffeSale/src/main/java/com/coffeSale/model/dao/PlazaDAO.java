package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Plaza;
import com.coffeSale.model.entity.PlazaEntity;

public interface PlazaDAO extends GenericDAO<PlazaEntity>{
	public List<Plaza> findAll_DTO() throws Exception;
	public Plaza findById_DTO(int id) throws Exception; 
	public List<Plaza> findByPlantilla(Plaza plaza) throws Exception;
	public List<Plaza> findByEmpleado(Empleado empleado) throws Exception;
	public void persist(Plaza plaza) throws Exception;
	public Plaza findByFolio(String plazaId) throws Exception;
}
