package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.EmpleadoDAO;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.entity.EmpleadoEntity;

public class EmpleadoDAOImpl implements EmpleadoDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<EmpleadoEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoEntity update(EmpleadoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoEntity create(EmpleadoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EmpleadoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado findById_DTO(int id) throws Exception {
		Session session = this.sessionFactory.openSession();
		EmpleadoEntity empleadoEntity = (EmpleadoEntity)session.createQuery("from EmpleadoEntity where id = :idEmp")
				.setParameter("idEmp",id)
				.uniqueResult();
		return empleadoEntity.getEmpleado();
	}

	@Override
	public List<Empleado> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> findByCafeteria_DTO(int cafeteriaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(EmpleadoEntity empleado) throws Exception {
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
