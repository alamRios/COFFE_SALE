package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.entity.Cafeteria;

public class CafeteriaDAOImpl implements CafeteriaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cafeteria> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cafeteria> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cafeteria update(Cafeteria entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cafeteria create(Cafeteria entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cafeteria entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CafeteriaDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CafeteriaDTO> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CafeteriaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Cafeteria cafeteria) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(cafeteria);
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