package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.GavetaDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.GavetaDTO;
import com.coffeSale.model.entity.Gaveta;

public class GavetaDAOImplJDBC implements GavetaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Gaveta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gaveta> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gaveta update(Gaveta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gaveta create(Gaveta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Gaveta entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GavetaDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GavetaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GavetaDTO> findByCafeteria(CafeteriaDTO cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Gaveta gaveta) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(gaveta);
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
