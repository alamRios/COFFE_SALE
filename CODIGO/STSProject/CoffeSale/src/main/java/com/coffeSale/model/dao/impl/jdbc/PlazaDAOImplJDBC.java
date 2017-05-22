package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.PlazaDAO;
import com.coffeSale.model.dto.EmpleadoDTO;
import com.coffeSale.model.dto.PlazaDTO;
import com.coffeSale.model.entity.Plaza;

public class PlazaDAOImplJDBC implements PlazaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Plaza> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plaza> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plaza update(Plaza entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plaza create(Plaza entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Plaza entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlazaDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlazaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlazaDTO> findByPlantilla(PlazaDTO plaza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlazaDTO> findByEmpleado(EmpleadoDTO empleado) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Plaza plaza) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(plaza);
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
