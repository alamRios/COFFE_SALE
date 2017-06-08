package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.MarcaDAO;
import com.coffeSale.model.dto.Marca;
import com.coffeSale.model.entity.MarcaEntity;

public class MarcaDAOImpl implements MarcaDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<MarcaEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarcaEntity update(MarcaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarcaEntity create(MarcaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(MarcaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(MarcaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Marca> findAll_DTO() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<MarcaEntity> marcas = session.createQuery("from MarcaEntity").list();
		List<Marca> marcasDTO = new ArrayList<Marca>();
		for(MarcaEntity marca : marcas){
			marcasDTO.add(
				marca.getMarca()
			);
		}
		return marcasDTO;
	}

	@Override
	public Marca findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Marca marca) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		MarcaEntity entity = new MarcaEntity();
			entity.setNombre(marca.getNombre());
			entity.setRfc(marca.getRfc());
		session.persist(entity);
		session.getTransaction().commit();
		session.close();
	}

}
