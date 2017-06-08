package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.entity.CafeteriaEntity;

public class CafeteriaDAOImpl implements CafeteriaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<CafeteriaEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CafeteriaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CafeteriaEntity update(CafeteriaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CafeteriaEntity create(CafeteriaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CafeteriaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cafeteria> findAll_DTO() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<CafeteriaEntity> cafeterias = session.createQuery("from CafeteriaEntity").list();
		List<Cafeteria> cafeteriasDTO = new ArrayList<Cafeteria>();
		for(CafeteriaEntity cafeteria : cafeterias){
			cafeteriasDTO.add(
				//TODO: Armar los que entran
				new Cafeteria()
			);
		}
		return cafeteriasDTO;
	}

	@Override
	public List<Cafeteria> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cafeteria findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(CafeteriaEntity cafeteria) throws Exception {
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

	@Override
	public void persist(Cafeteria cafeteria) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CafeteriaEntity entity = new CafeteriaEntity(); 
			entity.setAcepta_membresias(false);
			entity.setNombre(cafeteria.getNombre());
			entity.setEmail("");
			entity.setDireccionId(1);
			entity.setEstado("");
			entity.setMarcaId(1);
		session.persist(entity);
		session.getTransaction().commit();
		session.close();
	}
}
