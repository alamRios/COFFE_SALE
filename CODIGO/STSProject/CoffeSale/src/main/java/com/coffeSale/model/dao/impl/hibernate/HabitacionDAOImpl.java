package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.HabitacionDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Habitacion;
import com.coffeSale.model.entity.HabitacionEntity;

public class HabitacionDAOImpl implements HabitacionDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<HabitacionEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HabitacionEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HabitacionEntity update(HabitacionEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HabitacionEntity create(HabitacionEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(HabitacionEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Habitacion> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitacion findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Habitacion> findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(HabitacionEntity habitacion) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(habitacion);
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
