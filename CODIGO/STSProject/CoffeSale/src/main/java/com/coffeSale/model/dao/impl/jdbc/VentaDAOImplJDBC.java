package com.coffeSale.model.dao.impl.jdbc;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.VentaDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.dto.VentaDTO;
import com.coffeSale.model.entity.Venta;

public class VentaDAOImplJDBC implements VentaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<Venta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta update(Venta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta create(Venta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Venta entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VentaDTO> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VentaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaDTO> findByCafeteria(CafeteriaDTO cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Venta venta) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(venta);
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
