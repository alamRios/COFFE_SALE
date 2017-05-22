package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CajaFuerteDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.CajaFuerteDTO;
import com.coffeSale.model.entity.CajaFuerte;

public class CajaFuerteDAOImplJDBC implements CajaFuerteDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<CajaFuerte> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CajaFuerte> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerte update(CajaFuerte entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerte create(CajaFuerte entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CajaFuerte entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CajaFuerteDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerteDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CajaFuerteDTO findByCafeteria(CafeteriaDTO cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(CajaFuerte cajaFuerte) throws Exception {
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
