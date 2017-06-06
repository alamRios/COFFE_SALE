package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.VentaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;
import com.coffeSale.model.entity.VentaEntity;

public class VentaDAOImpl implements VentaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<VentaEntity> findAll() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<VentaEntity> ventas = session.createQuery("from Venta").list();
		session.close();
		return ventas;
	}

	@Override
	public List<VentaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VentaEntity update(VentaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VentaEntity create(VentaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(VentaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Venta> findAll_DTO() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<VentaEntity> ventas = session.createQuery("from VentaEntity").list();
		List<Venta> ventasDTO = new ArrayList<Venta>();
		for(VentaEntity venta : ventas){
			ventasDTO.add(
				venta.getVenta()
			);
		}
		return ventasDTO;
	}

	@Override
	public Venta findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> findByCafeteria(Cafeteria cafeteria)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(VentaEntity venta) throws Exception {
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
