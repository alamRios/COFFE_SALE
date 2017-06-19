package com.coffeSale.model.dao.impl.hibernate;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.PlazaDAO;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Plaza;
import com.coffeSale.model.entity.EmpleadoEntity;
import com.coffeSale.model.entity.PlazaEntity;
import com.coffeSale.model.entity.PuestoEntity;

public class PlazaDAOImpl implements PlazaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<PlazaEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlazaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlazaEntity update(PlazaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlazaEntity create(PlazaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PlazaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Plaza> findAll_DTO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plaza findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plaza> findByPlantilla(Plaza plaza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plaza> findByEmpleado(Empleado empleado) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(PlazaEntity plaza) throws Exception {
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

	@Override
	public void persist(Plaza plaza) throws Exception {
		//TODO: Definir forma de crear una plaza
	}

	@Override
	public Plaza findByFolio(String plazaId) throws Exception {
		Plaza plazaDTO = new Plaza();
		
		
		
		Session session = sessionFactory.openSession();
		PlazaEntity plazaEntity = (PlazaEntity)session.createQuery("from PlazaEntity "
				+ "where folio = :folioPlaza order by id desc")
				.setParameter("folioPlaza", plazaId)
				.setMaxResults(1)
				.uniqueResult();

		EmpleadoEntity empleadoEntity = (EmpleadoEntity)
				session.get(EmpleadoEntity.class, plazaEntity.getEmpleadoId());
		PuestoEntity puestoEntity = (PuestoEntity)
				session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
		Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
				empleadoEntity.getAppat(),empleadoEntity.getApmat(),
				empleadoEntity.getId(),puestoEntity.getNombre(),
				empleadoEntity.getCorreo());
		
		plazaDTO.setIdentificador(String.valueOf(plazaEntity.getId()));
		plazaDTO.setActiva(plazaEntity.isActiva());
		plazaDTO.setEmpleado(empleadoDTO);
		return plazaDTO; 
	}
}
