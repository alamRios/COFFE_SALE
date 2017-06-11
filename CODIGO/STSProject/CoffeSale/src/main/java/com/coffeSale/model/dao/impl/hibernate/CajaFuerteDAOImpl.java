package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CajaFuerteDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.CajaFuerte;
import com.coffeSale.model.entity.CajaFuerteEntity;

public class CajaFuerteDAOImpl implements CajaFuerteDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<CajaFuerteEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CajaFuerteEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerteEntity update(CajaFuerteEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerteEntity create(CajaFuerteEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CajaFuerteEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CajaFuerte> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerte findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerte findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(CajaFuerteEntity cajaFuerte) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(cajaFuerte);
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
