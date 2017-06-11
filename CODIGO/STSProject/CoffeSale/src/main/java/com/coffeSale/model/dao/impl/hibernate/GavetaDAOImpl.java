package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.GavetaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Gaveta;
import com.coffeSale.model.entity.GavetaEntity;

public class GavetaDAOImpl implements GavetaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<GavetaEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GavetaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GavetaEntity update(GavetaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GavetaEntity create(GavetaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(GavetaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Gaveta> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gaveta findById_DTO(int id) throws Exception {
		Session session = this.sessionFactory.openSession();
		GavetaEntity gavetaEntity = (GavetaEntity)session.createQuery("from GavetaEntity where id = :idGaveta")
				.setParameter("idGaveta", id)
				.uniqueResult();
		return gavetaEntity.getGaveta();
	}

	@Override
	public List<Gaveta> findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(GavetaEntity gaveta) throws Exception {
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
