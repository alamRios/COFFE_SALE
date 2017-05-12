package com.coffeSale.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T extends Serializable> {
	public List<T> findAll() throws Exception;
	public T update(T entity) throws Exception; 
	public T create(T entity) throws Exception;
	public void delete(T entity) throws Exception; 
}
