package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.InventarioDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Inventario;
import com.coffeSale.model.entity.InventarioEntity;

public class InventarioDAOImpl implements InventarioDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<InventarioEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventarioEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventarioEntity update(InventarioEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventarioEntity create(InventarioEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(InventarioEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Inventario> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventario findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventario findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(InventarioEntity inventario) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(inventario);
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
