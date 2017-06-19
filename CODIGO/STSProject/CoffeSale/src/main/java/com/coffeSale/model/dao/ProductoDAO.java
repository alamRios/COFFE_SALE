package com.coffeSale.model.dao;

import java.util.List;

import com.coffeSale.model.dto.Producto;
import com.coffeSale.model.entity.ProductoEntity;

public interface ProductoDAO extends GenericDAO<ProductoEntity> {
	public List<Producto> findAll_DTO() throws Exception;
	public Producto findById_DTO(int id) throws Exception; 
	public List<Producto> findByNombre_DTO(String nombre) throws Exception;
	public List<Producto> findByCosto_DTO(double costo) throws Exception;
	public List<Producto> findByLinea(int lineaId) throws Exception;
	public Producto persist(Producto producto) throws Exception;
	public void delete(Producto producto) throws Exception;
	public Producto update(Producto producto) throws Exception;
}
