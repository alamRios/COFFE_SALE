package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.MembresiaClienteDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.MembresiaCliente;
import com.coffeSale.model.entity.ClienteEntity;

public class MembresiaClienteDAOImpl implements MembresiaClienteDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<ClienteEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteEntity update(ClienteEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteEntity create(ClienteEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ClienteEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MembresiaCliente> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembresiaCliente findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembresiaCliente findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembresiaCliente> findByNombre(String nombre)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ClienteEntity cliente) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(cliente);
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
