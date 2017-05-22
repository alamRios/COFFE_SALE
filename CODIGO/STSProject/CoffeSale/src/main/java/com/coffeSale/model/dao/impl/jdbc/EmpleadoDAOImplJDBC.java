package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.EmpleadoDAO;
import com.coffeSale.model.dto.EmpleadoDTO;
import com.coffeSale.model.entity.Empleado;

public class EmpleadoDAOImplJDBC implements EmpleadoDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Empleado> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado update(Empleado entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado create(Empleado entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Empleado entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpleadoDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoDTO> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoDTO> findByCafeteria_DTO(int cafeteriaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Empleado empleado) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(empleado);
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
