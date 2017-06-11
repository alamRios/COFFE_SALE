package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Gaveta;
import com.coffeSale.model.dto.Habitacion;
import com.coffeSale.model.dto.Inventario;
import com.coffeSale.model.dto.Plantilla;
import com.coffeSale.model.dto.Plaza;
import com.coffeSale.model.dto.Producto;
import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;
import com.coffeSale.model.entity.CafeteriaEntity;
import com.coffeSale.model.entity.GavetaEntity;
import com.coffeSale.model.entity.HabitacionEntity;
import com.coffeSale.model.entity.InventarioEntity;
import com.coffeSale.model.entity.PlantillaEntity;
import com.coffeSale.model.entity.PlazaEntity;
import com.coffeSale.model.entity.ProductoEntity;
import com.coffeSale.model.entity.VentaEntity;
import com.coffeSale.model.entity.MarcaEntity;
import com.coffeSale.model.entity.DireccionEntity;
import com.coffeSale.model.entity.EmpleadoEntity;

public class CafeteriaDAOImpl implements CafeteriaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<CafeteriaEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CafeteriaEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CafeteriaEntity update(CafeteriaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CafeteriaEntity create(CafeteriaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CafeteriaEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cafeteria> findAll_DTO() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<CafeteriaEntity> cafeterias = session.createQuery("from CafeteriaEntity").list();
		
		List<Cafeteria> cafeteriasDTO = new ArrayList<Cafeteria>();
		List<Gaveta> gavetas = new ArrayList<Gaveta>();
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		List<Plantilla> plantillas = new ArrayList<Plantilla>();
		List<Plaza> plantillaPlazas = new ArrayList<Plaza>();
		List<Venta> ventas = new ArrayList<Venta>(); 
		List<Producto> inventarioProductos = new ArrayList<Producto>();
		
		List<GavetaEntity> gavetasEntity = new ArrayList<GavetaEntity>();
		List<HabitacionEntity> habitacionesEntity = new ArrayList<HabitacionEntity>();
		List<PlantillaEntity> plantillasEntity = new ArrayList<PlantillaEntity>();
		List<PlazaEntity> plantillaPlazasEntity = new ArrayList<PlazaEntity>();
		List<VentaEntity> ventasEntity = new ArrayList<VentaEntity>(); 
		List<InventarioEntity> inventarioProductosEntity = new ArrayList<InventarioEntity>();
		
		for(CafeteriaEntity cafeteria : cafeterias){
			gavetasEntity = session.createQuery("from GavetaEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(GavetaEntity gavetaE : gavetasEntity){
				gavetas.add(gavetaE.getGaveta());
			}			
			habitacionesEntity = session.createQuery("from HabitacionEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(HabitacionEntity habitacionE : habitacionesEntity){
				habitaciones.add(habitacionE.getHabitacion());
			}
			plantillasEntity = session.createQuery("from PlantillaEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(PlantillaEntity plantillaE : plantillasEntity){
				plantillaPlazasEntity = session.createQuery("from PlazaEntity "
										+ "where plantillaId = :plantillaId")
										.setParameter("plantillaId",plantillaE.getId())
										.list();
				for(PlazaEntity plazaE : plantillaPlazasEntity){
					plantillaPlazas.add(
							new Plaza(
								((EmpleadoEntity)session.get(EmpleadoEntity.class,plazaE.getEmpleadoId())).getEmpleado(),
								String.valueOf(plazaE.getFolio()),
								plazaE.isActiva()
							)
						);
				}
				plantillas.add(new Plantilla(plantillaPlazas,
						String.valueOf(plantillaE.getId()),plantillaE.getNumeroEmpleados()));
			}
			ventasEntity = session.createQuery("from VentaEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(VentaEntity ventaE : ventasEntity){
				ventas.add(
					new VentaEnTienda(
						((EmpleadoEntity)session.get(EmpleadoEntity.class, ventaE.getEmpleadoId())).getEmpleado(),
						((GavetaEntity)session.get(GavetaEntity.class, ventaE.getGavetaId())).getGaveta(),
						ventaE.getImporte(),
						ventaE.getInicio()
					)
				);
			}
			inventarioProductosEntity = session.createQuery("from InventarioEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list(); 
			for(InventarioEntity inventarioE : inventarioProductosEntity){
				inventarioProductos.add(
					((ProductoEntity)session.get(
							ProductoEntity.class,inventarioE.getProducto())).getProducto()	
					);
			}
			cafeteriasDTO.add(
				new Cafeteria(
						plantillas,
						gavetas,
						ventas,
						habitaciones,
						new Inventario(
								inventarioProductosEntity.get(0).getUltimaActualizacion(),
								"codigoInventario",
								inventarioProductos
								),
						cafeteria.getNombre(),
						((MarcaEntity)session.get(MarcaEntity.class,cafeteria.getMarcaId())).getMarca().getNombre(),
						String.valueOf(cafeteria.getId()),
						cafeteria.isAcepta_membresias(),
						cafeteria.getEmail(),
						((DireccionEntity)session.get(DireccionEntity.class,cafeteria.getDireccionId())).getDireccion()
					)
			);
		}
		return cafeteriasDTO;
	}

	@Override
	public List<Cafeteria> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(CafeteriaEntity cafeteria) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(cafeteria);
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
	public void persist(Cafeteria cafeteria) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CafeteriaEntity entity = new CafeteriaEntity(); 
			entity.setAcepta_membresias(false);
			entity.setNombre(cafeteria.getNombre());
			entity.setEmail("");
			entity.setDireccionId(1);
			entity.setEstado("");
			entity.setMarcaId(1);
		session.persist(entity);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cafeteria findByLineaYNombre_DTO(int lineaId, String nombre) throws Exception {
		Session session = this.sessionFactory.openSession();
		CafeteriaEntity cafeteria = (CafeteriaEntity) session.createQuery("from CafeteriaEntity"
				+ " where marcaId = :marcaId and nombre = :nombre")
				.setParameter("marcaId", lineaId)
				.setParameter("nombre", nombre)
				.uniqueResult();
		
		List<Gaveta> gavetas = new ArrayList<Gaveta>();
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		List<Plantilla> plantillas = new ArrayList<Plantilla>();
		List<Plaza> plantillaPlazas = new ArrayList<Plaza>();
		List<Venta> ventas = new ArrayList<Venta>(); 
		List<Producto> inventarioProductos = new ArrayList<Producto>();
		
		List<GavetaEntity> gavetasEntity = new ArrayList<GavetaEntity>();
		List<HabitacionEntity> habitacionesEntity = new ArrayList<HabitacionEntity>();
		List<PlantillaEntity> plantillasEntity = new ArrayList<PlantillaEntity>();
		List<PlazaEntity> plantillaPlazasEntity = new ArrayList<PlazaEntity>();
		List<VentaEntity> ventasEntity = new ArrayList<VentaEntity>(); 
		List<InventarioEntity> inventarioProductosEntity = new ArrayList<InventarioEntity>();
		
		gavetasEntity = session.createQuery("from GavetaEntity where cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", cafeteria.getId())
				.list();
		for(GavetaEntity gavetaE : gavetasEntity){
			gavetas.add(gavetaE.getGaveta());
		}			
		habitacionesEntity = session.createQuery("from HabitacionEntity where cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", cafeteria.getId())
				.list();
		for(HabitacionEntity habitacionE : habitacionesEntity){
			habitaciones.add(habitacionE.getHabitacion());
		}
		plantillasEntity = session.createQuery("from PlantillaEntity where cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", cafeteria.getId())
				.list();
		for(PlantillaEntity plantillaE : plantillasEntity){
			plantillaPlazasEntity = session.createQuery("from PlazaEntity "
									+ "where plantillaId = :plantillaId")
									.setParameter("plantillaId",plantillaE.getId())
									.list();
			for(PlazaEntity plazaE : plantillaPlazasEntity){
				plantillaPlazas.add(
						new Plaza(
							((EmpleadoEntity)session.get(EmpleadoEntity.class,plazaE.getEmpleadoId())).getEmpleado(),
							String.valueOf(plazaE.getFolio()),
							plazaE.isActiva()
						)
					);
			}
			plantillas.add(new Plantilla(plantillaPlazas,
					String.valueOf(plantillaE.getId()),plantillaE.getNumeroEmpleados()));
		}
		ventasEntity = session.createQuery("from VentaEntity where cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", cafeteria.getId())
				.list();
		for(VentaEntity ventaE : ventasEntity){
			ventas.add(
				new VentaEnTienda(
					((EmpleadoEntity)session.get(EmpleadoEntity.class, ventaE.getEmpleadoId())).getEmpleado(),
					((GavetaEntity)session.get(GavetaEntity.class, ventaE.getGavetaId())).getGaveta(),
					ventaE.getImporte(),
					ventaE.getInicio()
				)
			);
		}
		inventarioProductosEntity = session.createQuery("from InventarioEntity where cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", cafeteria.getId())
				.list(); 
		for(InventarioEntity inventarioE : inventarioProductosEntity){
			inventarioProductos.add(
				((ProductoEntity)session.get(
						ProductoEntity.class,inventarioE.getProducto())).getProducto()	
				);
		}
		return new Cafeteria(
			plantillas,
			gavetas,
			ventas,
			habitaciones,
			inventarioProductosEntity.size()>0?
					new Inventario(
					inventarioProductosEntity.get(0).getUltimaActualizacion(),
					String.valueOf(inventarioProductosEntity.get(0).getCafeteriaId()),
					inventarioProductos
					):
					new Inventario(),
			cafeteria.getNombre(),
			((MarcaEntity)session.get(MarcaEntity.class,cafeteria.getMarcaId())).getMarca().getNombre(),
			String.valueOf(cafeteria.getId()),
			cafeteria.isAcepta_membresias(),
			cafeteria.getEmail(),
			((DireccionEntity)session.get(DireccionEntity.class,cafeteria.getDireccionId())).getDireccion()
		);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cafeteria> findByLinea_DTO(int lineaId) throws Exception {
		Session session = this.sessionFactory.openSession();
		List<CafeteriaEntity> cafeterias = 
				session.createQuery("from CafeteriaEntity "
						+ "where marcaId = :lineaId")
				.setParameter("lineaId", lineaId)
				.list();
		
		List<Cafeteria> cafeteriasDTO = new ArrayList<Cafeteria>();
		List<Gaveta> gavetas = new ArrayList<Gaveta>();
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		List<Plantilla> plantillas = new ArrayList<Plantilla>();
		List<Plaza> plantillaPlazas = new ArrayList<Plaza>();
		List<Venta> ventas = new ArrayList<Venta>(); 
		List<Producto> inventarioProductos = new ArrayList<Producto>();
		
		List<GavetaEntity> gavetasEntity = new ArrayList<GavetaEntity>();
		List<HabitacionEntity> habitacionesEntity = new ArrayList<HabitacionEntity>();
		List<PlantillaEntity> plantillasEntity = new ArrayList<PlantillaEntity>();
		List<PlazaEntity> plantillaPlazasEntity = new ArrayList<PlazaEntity>();
		List<VentaEntity> ventasEntity = new ArrayList<VentaEntity>(); 
		List<InventarioEntity> inventarioProductosEntity = new ArrayList<InventarioEntity>();
		
		for(CafeteriaEntity cafeteria : cafeterias){
			gavetasEntity = session.createQuery("from GavetaEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(GavetaEntity gavetaE : gavetasEntity){
				gavetas.add(gavetaE.getGaveta());
			}			
			habitacionesEntity = session.createQuery("from HabitacionEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(HabitacionEntity habitacionE : habitacionesEntity){
				habitaciones.add(habitacionE.getHabitacion());
			}
			plantillasEntity = session.createQuery("from PlantillaEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(PlantillaEntity plantillaE : plantillasEntity){
				plantillaPlazasEntity = session.createQuery("from PlazaEntity "
										+ "where plantillaId = :plantillaId")
										.setParameter("plantillaId",plantillaE.getId())
										.list();
				for(PlazaEntity plazaE : plantillaPlazasEntity){
					plantillaPlazas.add(
							new Plaza(
								((EmpleadoEntity)session.get(EmpleadoEntity.class,plazaE.getEmpleadoId())).getEmpleado(),
								String.valueOf(plazaE.getFolio()),
								plazaE.isActiva()
							)
						);
				}
				plantillas.add(new Plantilla(plantillaPlazas,
						String.valueOf(plantillaE.getId()),plantillaE.getNumeroEmpleados()));
			}
			ventasEntity = session.createQuery("from VentaEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list();
			for(VentaEntity ventaE : ventasEntity){
				ventas.add(
					new VentaEnTienda(
						((EmpleadoEntity)session.get(EmpleadoEntity.class, ventaE.getEmpleadoId())).getEmpleado(),
						((GavetaEntity)session.get(GavetaEntity.class, ventaE.getGavetaId())).getGaveta(),
						ventaE.getImporte(),
						ventaE.getInicio()
					)
				);
			}
			inventarioProductosEntity = session.createQuery("from InventarioEntity where cafeteriaId = :cafeteriaId")
					.setParameter("cafeteriaId", cafeteria.getId())
					.list(); 
			for(InventarioEntity inventarioE : inventarioProductosEntity){
				inventarioProductos.add(
					((ProductoEntity)session.get(
							ProductoEntity.class,inventarioE.getProducto())).getProducto()	
					);
			}
			cafeteriasDTO.add(
				new Cafeteria(
						plantillas,
						gavetas,
						ventas,
						habitaciones,
						inventarioProductosEntity.size()>0?
							new Inventario(
									inventarioProductosEntity.get(0).getUltimaActualizacion(),
									"codigoInventario",
									inventarioProductos
									):
							new Inventario(),
						cafeteria.getNombre(),
						((MarcaEntity)session.get(MarcaEntity.class,cafeteria.getMarcaId())).getMarca().getNombre(),
						String.valueOf(cafeteria.getId()),
						cafeteria.isAcepta_membresias(),
						cafeteria.getEmail(),
						((DireccionEntity)session.get(DireccionEntity.class,cafeteria.getDireccionId())).getDireccion()
					)
			);
		}
		return cafeteriasDTO;
	}
}
