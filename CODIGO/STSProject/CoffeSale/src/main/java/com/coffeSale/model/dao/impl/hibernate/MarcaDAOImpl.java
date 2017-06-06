package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
