package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.UtileriaDAO;
import com.coffeSale.model.entity.PuestoEntity;

public class UtileriaDAOImpl implements UtileriaDAO{
	SessionFactory sessionFactory; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuestoEntity> getPuestos() throws Exception {
		Session session = sessionFactory.openSession();
		List<PuestoEntity> puestosDTO = 
				session.createQuery("from PuestoEntity")
				.list();
		return puestosDTO;
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
