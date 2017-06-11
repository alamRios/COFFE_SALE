package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.ProductoDAO;
import com.coffeSale.model.dto.Producto;
import com.coffeSale.model.entity.ProductoEntity;

public class ProductoDAOImpl implements ProductoDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductoEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoEntity update(ProductoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoEntity create(ProductoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ProductoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByCosto_DTO(double costo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(ProductoEntity producto) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(producto);
		tx.commit();
		session.close(); 
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
