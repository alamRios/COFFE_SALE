package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.InventarioDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.InventarioDTO;
import com.coffeSale.model.entity.Inventario;

public class InventarioDAOImpl implements InventarioDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Inventario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventario> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventario update(Inventario entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventario create(Inventario entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Inventario entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InventarioDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventarioDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventarioDTO findByCafeteria(CafeteriaDTO cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Inventario inventario) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(inventario);
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
