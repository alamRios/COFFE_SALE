package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.PlantillaDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.PlantillaDTO;
import com.coffeSale.model.entity.Plantilla;

public class PlantillaDAOImplJDBC implements PlantillaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Plantilla> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plantilla> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla update(Plantilla entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla create(Plantilla entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Plantilla entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlantillaDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlantillaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlantillaDTO findByCafeteria(CafeteriaDTO cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Plantilla plantilla) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(plantilla);
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
