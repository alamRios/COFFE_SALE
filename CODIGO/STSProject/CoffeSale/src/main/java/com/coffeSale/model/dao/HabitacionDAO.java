package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Habitacion;
import com.coffeSale.model.entity.HabitacionEntity;

public interface HabitacionDAO extends GenericDAO<HabitacionEntity>{
	public List<Habitacion> findAll_DTO() throws Exception;
	public Habitacion findById_DTO(int id) throws Exception; 
	public List<Habitacion> findByCafeteria(Cafeteria cafeteria) throws Exception;
}
