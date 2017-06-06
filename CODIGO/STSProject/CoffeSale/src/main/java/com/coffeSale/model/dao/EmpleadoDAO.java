package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.entity.EmpleadoEntity;

public interface EmpleadoDAO extends GenericDAO<EmpleadoEntity>{
	public List<Empleado> findAll_DTO() throws Exception;
	public Empleado findById_DTO(int id) throws Exception;
	public List<Empleado> findByNombre_DTO(String nombre) throws Exception;
	public List<Empleado> findByCafeteria_DTO(int cafeteriaId);
}
