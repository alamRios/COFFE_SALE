package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.ProductoDAO;
import com.coffeSale.model.dto.ProductoDTO;
import com.coffeSale.model.entity.Producto;

public class ProductoDAOImplJDBC implements ProductoDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Producto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto update(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto create(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductoDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO> findByCosto_DTO(double costo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Producto producto) throws Exception {
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
