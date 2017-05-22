package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.ProductoDTO;
import com.coffeSale.model.entity.Producto;

public interface ProductoDAO extends GenericDAO<Producto> {
	public List<ProductoDTO> findAll_DTO() throws Exception;
	public ProductoDTO findById_DTO(int id) throws Exception; 
	public List<ProductoDTO> findByNombre_DTO(String nombre) throws Exception;
	public List<ProductoDTO> findByCosto_DTO(double costo) throws Exception;
}
