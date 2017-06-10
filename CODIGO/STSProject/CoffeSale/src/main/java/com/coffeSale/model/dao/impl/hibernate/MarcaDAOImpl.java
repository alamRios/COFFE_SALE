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
	
	public MarcaEntity find(String nombre) throws Exception{
		Session session = sessionFactory.openSession();
		MarcaEntity entity = new MarcaEntity(); 
		entity = (MarcaEntity) session.createQuery("from MarcaEntity where nombre = :nombreDTO")
				.setParameter("nombreDTO", nombre)
				.uniqueResult();
		return entity; 
	}

	@Override
	public MarcaEntity update(MarcaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(Marca marca) throws Exception{
		Session session = sessionFactory.openSession();
		session.createQuery(""
				+ "UPDATE MarcaEntity "
				+ "set nombre = :nombre "
				+ "WHERE rfc = :rfc")
				.setParameter("nombre", marca.getNombre())
				.setParameter("rfc", marca.getRfc())
				.executeUpdate();
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
		@SuppressWarnings("unchecked")
		List<MarcaEntity> marcas =  session.createQuery("from MarcaEntity").list();
		List<Marca> marcasDTO = new ArrayList<Marca>();
		for(MarcaEntity marca : marcas){
			marcasDTO.add(
				marca.getMarca()
			);
		}
		return marcasDTO;
	}

	@Override
	public Marca findByNombre_DTO(String nombre) throws Exception {
		Marca marca = new Marca(); 
		return marca;
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

	@Override
	public void delete(Marca marca) throws Exception {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM MarcaEntity "
							+ "WHERE rfc = :rfc")
				.setParameter("rfc", marca.getRfc())
				.executeUpdate();
	}

}
