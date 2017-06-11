package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.PlantillaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Plantilla;
import com.coffeSale.model.entity.PlantillaEntity;

public class PlantillaDAOImpl implements PlantillaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<PlantillaEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlantillaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlantillaEntity update(PlantillaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlantillaEntity create(PlantillaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PlantillaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Plantilla> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(PlantillaEntity plantilla) throws Exception {
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
