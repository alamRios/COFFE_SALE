package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.EmpleadoDTO;
import com.coffeSale.model.entity.Empleado;

public interface EmpleadoDAO extends GenericDAO<Empleado>{
	public List<EmpleadoDTO> findAll_DTO() throws Exception;
	public EmpleadoDTO findById_DTO(int id) throws Exception;
	public List<EmpleadoDTO> findByNombre_DTO(String nombre) throws Exception;
	public List<EmpleadoDTO> findByCafeteria_DTO(int cafeteriaId);
}
