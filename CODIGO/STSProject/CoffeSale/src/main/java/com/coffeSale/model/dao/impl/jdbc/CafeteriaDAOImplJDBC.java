package com.coffeSale.model.dao.impl.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.entity.Cafeteria;

public class CafeteriaDAOImplJDBC implements CafeteriaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Cafeteria cafeteria) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(cafeteria);
		tx.commit();
		session.close(); 
	}
	
	@Override
	public List<Cafeteria> findAll() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<Cafeteria> cafeterias = session.createQuery("from CAFETERIA").list();
		session.close();
		return cafeterias;
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
		List<CafeteriaDTO> res = new ArrayList<CafeteriaDTO>();
		
				
		return res;
	}

	@Override
	public CafeteriaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
