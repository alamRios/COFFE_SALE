package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.MembresiaClienteDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.MembresiaClienteDTO;
import com.coffeSale.model.entity.Cliente;

public class MembresiaClienteDAOImplJDBC implements MembresiaClienteDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente create(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MembresiaClienteDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembresiaClienteDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembresiaClienteDTO findByCafeteria(CafeteriaDTO cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembresiaClienteDTO> findByNombre(String nombre)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Cliente cliente) throws Exception {
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
