package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.EmpleadoDAO;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.entity.CafeteriaEntity;
import com.coffeSale.model.entity.EmpleadoEntity;
import com.coffeSale.model.entity.PlantillaEntity;
import com.coffeSale.model.entity.PlazaEntity;
import com.coffeSale.model.entity.PuestoEntity;
import com.coffeSale.model.entity.UsuarioEntity;

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
		EmpleadoEntity empleadoEntity = 
				(EmpleadoEntity)session.createQuery("from EmpleadoEntity "
						+ "where id = :idEmp")
				.setParameter("idEmp",id)
				.uniqueResult();
		PuestoEntity puestoEntity = (PuestoEntity)
				session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
		Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
				empleadoEntity.getAppat(),empleadoEntity.getApmat(),
				empleadoEntity.getId(),puestoEntity.getNombre(),
				empleadoEntity.getCorreo());
		return empleadoDTO;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByPlantilla(int plantillaId) throws Exception {
		Session session = this.sessionFactory.openSession();
		List<Empleado> empleadosDTO = new ArrayList<Empleado>();
		List<PlazaEntity> plazas = session.createQuery("from PlazaEntity "
				+ "where plantillaId = :plantillaId")
				.setParameter("plantillaId", plantillaId)
				.list();
		
		for(PlazaEntity plazaE : plazas){
			EmpleadoEntity empleadoEntity = (EmpleadoEntity)
					session.get(EmpleadoEntity.class, plazaE.getEmpleadoId());
			PuestoEntity puestoEntity = (PuestoEntity)
					session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
			Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
					empleadoEntity.getAppat(),empleadoEntity.getApmat(),
					empleadoEntity.getId(),puestoEntity.getNombre(),
					empleadoEntity.getCorreo());
			empleadosDTO.add(empleadoDTO);
		}
			
		return empleadosDTO; 
	}

	@Override
	public Empleado findByUsuarioNombre_DTO(String usuarioNombre) throws Exception {
		Session session = this.sessionFactory.openSession();
		UsuarioEntity usuarioEntity = (UsuarioEntity)session.createQuery("from UsuarioEntity"
				+ " where nombre = :usuarioNombre")
				.setParameter("usuarioNombre", usuarioNombre)
				.uniqueResult();
		EmpleadoEntity empleadoEntity = 
				(EmpleadoEntity)session.createQuery("from EmpleadoEntity "
						+ "where id = :idEmp")
				.setParameter("idEmp",usuarioEntity.getIdEmpleado())
				.uniqueResult();
		PuestoEntity puestoEntity = (PuestoEntity)
				session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
		Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
				empleadoEntity.getAppat(),empleadoEntity.getApmat(),
				empleadoEntity.getId(),puestoEntity.getNombre(),
				empleadoEntity.getCorreo());
		return empleadoDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findByLineaId_DTO(int lineaId) throws Exception {
		List<Empleado> empleadosDTO = new ArrayList<Empleado>();
		Session session = sessionFactory.openSession();
		List<CafeteriaEntity> cafeteriasEntity = session.createQuery("from CafeteriaEntity "
				+ "where marcaId = :lineaId")
				.setParameter("lineaId",lineaId)
				.list();
		for(CafeteriaEntity cafeteriaEntity : cafeteriasEntity){
			List<PlantillaEntity> plantillasEntity =
					session.createQuery("from PlantillaEntity "
							+ "where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId",cafeteriaEntity.getId())
					.list();
			for(PlantillaEntity plantillaEntity : plantillasEntity){
				List<PlazaEntity> plazasEntity =
						session.createQuery("from PlazaEntity "
								+ "where plantillaId = :plantillaId")
						.setParameter("plantillaId", plantillaEntity.getId())
						.list();
				for(PlazaEntity plazaEntity : plazasEntity){
					List<EmpleadoEntity> empleadosEntity = 
							session.createQuery("from EmpleadoEntity "
									+ "where id = :empleadoId")
							.setParameter("empleadoId",plazaEntity.getEmpleadoId())
							.list();
					for(EmpleadoEntity empleadoEntity : empleadosEntity){
						empleadosDTO.add(
							new Empleado(empleadoEntity.getNombre(),
									empleadoEntity.getAppat(),empleadoEntity.getApmat(),
									empleadoEntity.getId(),
									((PuestoEntity)session.get(
											PuestoEntity.class,
											empleadoEntity.getPuestoId())
									).getNombre(),
									empleadoEntity.getCorreo()
							)
						);
					}
				}
			}
		}
		return empleadosDTO;
	}

	@Override
	public Empleado persist(Empleado empleado) throws Exception {
		Session session = sessionFactory.openSession();
		int lineaId = empleado.getCodigoEmpleado();// Se guardo el id de la linea ahi empleados.js
		CafeteriaEntity cafeteriaEntity = (CafeteriaEntity)
				session.createQuery("from CafeteriaEntity "
						+ "where marcaId = :lineaId")
						.setParameter("lineaId", lineaId)
						.setMaxResults(1)
						.uniqueResult();
		PlantillaEntity plantillaEntity = (PlantillaEntity)
				session.createQuery("from PlantillaEntity "
						+ "where cafeteriaId = :cafeteriaId")
						.setParameter("cafeteriaId", cafeteriaEntity.getId())
						.setMaxResults(1)
						.uniqueResult();
		session.beginTransaction();
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();
			empleadoEntity.setNombre(empleado.getNombre());
			empleadoEntity.setAppat(empleado.getApPaterno());
			empleadoEntity.setApmat(empleado.getApMaterno());
			empleadoEntity.setContratacion(new Date());
			empleadoEntity.setCorreo(empleado.getCorreo());
			empleadoEntity.setHorarioId(1); // Solo existe matutino por el momento
			empleadoEntity.setPuestoId(Integer.valueOf(empleado.getPuesto()));
			empleadoEntity.setSalario(3000); // FIXME: El sueldo se debe asignar
		session.persist(empleadoEntity);
		PlazaEntity plazaEntity = new PlazaEntity(); 
			plazaEntity.setActiva(true);
			plazaEntity.setFechaAlta(new Date());
			plazaEntity.setPlantillaId(plantillaEntity.getId());
			plazaEntity.setEmpleadoId(empleadoEntity.getId());
		session.persist(plazaEntity);
			plazaEntity.setFolio(plazaEntity.getId());
		session.update(plazaEntity);
		
		session.getTransaction().commit();
		empleado.setCodigoEmpleado(empleadoEntity.getId());
		
		return empleado; 
	}

	@Override
	public Empleado update(Empleado empleado) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		EmpleadoEntity empleadoEntity =(EmpleadoEntity)  
				session.get(EmpleadoEntity.class, empleado.getCodigoEmpleado());
			empleadoEntity.setNombre(empleado.getNombre());
			empleadoEntity.setAppat(empleado.getApPaterno());
			empleadoEntity.setCorreo(empleado.getCorreo());
			empleadoEntity.setPuestoId(Integer.valueOf(empleado.getPuesto()));
		session.update(empleadoEntity);
		session.getTransaction().commit();
		return empleado; 
	}
}
