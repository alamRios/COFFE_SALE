package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.EmpleadoDTO;
import com.coffeSale.model.dto.PlazaDTO;
import com.coffeSale.model.entity.Plaza;

public interface PlazaDAO extends GenericDAO<Plaza>{
	public List<PlazaDTO> findAll_DTO() throws Exception;
	public PlazaDTO findById_DTO(int id) throws Exception; 
	public List<PlazaDTO> findByPlantilla(PlazaDTO plaza) throws Exception;
	public List<PlazaDTO> findByEmpleado(EmpleadoDTO empleado) throws Exception;
}
