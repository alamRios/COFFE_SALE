package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.HabitacionDTO;
import com.coffeSale.model.entity.Habitacion;

public interface HabitacionDAO extends GenericDAO<Habitacion>{
	public List<HabitacionDTO> findAll_DTO() throws Exception;
	public HabitacionDTO findById_DTO(int id) throws Exception; 
	public List<HabitacionDTO> findByCafeteria(CafeteriaDTO cafeteria) throws Exception;
}
