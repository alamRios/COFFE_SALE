package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.Cafeteria;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Gaveta;
import com.coffeSale.model.dto.Habitacion;
import com.coffeSale.model.dto.Inventario;
import com.coffeSale.model.dto.Plantilla;
import com.coffeSale.model.dto.Plaza;
import com.coffeSale.model.dto.Producto;
import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;
import com.coffeSale.model.entity.CafeteriaEntity;
import com.coffeSale.model.entity.DetalleVentaEntity;
import com.coffeSale.model.entity.GavetaEntity;
import com.coffeSale.model.entity.HabitacionEntity;
import com.coffeSale.model.entity.InventarioEntity;
import com.coffeSale.model.entity.PlantillaEntity;
import com.coffeSale.model.entity.PlazaEntity;
import com.coffeSale.model.entity.ProductoEntity;
import com.coffeSale.model.entity.PuestoEntity;
import com.coffeSale.model.entity.VentaEntity;
import com.coffeSale.model.entity.MarcaEntity;
import com.coffeSale.model.entity.DireccionEntity;
import com.coffeSale.model.entity.EmpleadoEntity;
import com.coffeSale.model.entity.ClienteEntity;

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

					EmpleadoEntity empleadoEntity = (EmpleadoEntity)
							session.get(EmpleadoEntity.class, plazaE.getEmpleadoId());
					PuestoEntity puestoEntity = (PuestoEntity)
							session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
					Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
							empleadoEntity.getAppat(),empleadoEntity.getApmat(),
							empleadoEntity.getId(),puestoEntity.getNombre(),
							empleadoEntity.getCorreo());
					plantillaPlazas.add(
							new Plaza(
								empleadoDTO,
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
				List<Producto> productosDTO = new ArrayList<Producto>();
				List<DetalleVentaEntity> detVentas = session.createQuery("from DetalleVentaEntity"
						+ " where ventaId = :ventaId")
						.setParameter("ventaId", ventaE.getId())
						.list();
				List<ProductoEntity> productos = new ArrayList<ProductoEntity>();
				for(DetalleVentaEntity detVenta : detVentas){
					productos = 
							session.createQuery("from ProductoEntity"
							+ " where id = :productoId")
							.setParameter("productoId", detVenta.getProductoId())
							.list();
				}
				for(ProductoEntity productoE : productos){
					productosDTO.add(productoE.getProducto());
				}

				EmpleadoEntity empleadoEntity = (EmpleadoEntity)
						session.get(EmpleadoEntity.class, ventaE.getEmpleadoId());
				PuestoEntity puestoEntity = (PuestoEntity)
						session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
				Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
						empleadoEntity.getAppat(),empleadoEntity.getApmat(),
						empleadoEntity.getId(),puestoEntity.getNombre(),
						empleadoEntity.getCorreo());
				
				ventas.add(
					new VentaEnTienda(
						empleadoDTO,
						((GavetaEntity)session.get(GavetaEntity.class, ventaE.getGavetaId())).getGaveta(),
						ventaE.getImporte(),
						ventaE.getInicio(),
						productosDTO,
						((ClienteEntity)session.get(ClienteEntity.class, ventaE.getCliente())).getCliente()
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
	public Cafeteria persist(Cafeteria cafeteria) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String direccion = cafeteria.getDireccion();
		String [] direccionArray = direccion.split(",");
		DireccionEntity direccionEntity = new DireccionEntity(); 
			direccionEntity.setCalle(direccionArray[0]);
			direccionEntity.setNumero(direccionArray[1]);
			direccionEntity.setColonia(direccionArray[2]);
			direccionEntity.setDelegacion(direccionArray[3]);
			direccionEntity.setCiudad(direccionArray[4]);//Estado en js
			direccionEntity.setPais(direccionArray[5]);
		session.persist(direccionEntity);
		CafeteriaEntity entity = new CafeteriaEntity(); 
			entity.setAcepta_membresias(cafeteria.isAceptaMembresias());
			entity.setNombre(cafeteria.getNombre());
			entity.setEmail(cafeteria.getEmail());
			entity.setDireccionId(direccionEntity.getId());
			entity.setEstado(direccionEntity.getCiudad());
			entity.setMarcaId(Integer.valueOf(cafeteria.getLinea()));
		session.persist(entity);
		session.getTransaction().commit();
		session.close();
		return cafeteria; 
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

				EmpleadoEntity empleadoEntity = (EmpleadoEntity)
						session.get(EmpleadoEntity.class, plazaE.getEmpleadoId());
				PuestoEntity puestoEntity = (PuestoEntity)
						session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
				Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
						empleadoEntity.getAppat(),empleadoEntity.getApmat(),
						empleadoEntity.getId(),puestoEntity.getNombre(),
						empleadoEntity.getCorreo());
				plantillaPlazas.add(
						new Plaza(
							empleadoDTO,
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
			List<Producto> productosDTO = new ArrayList<Producto>();
			List<DetalleVentaEntity> detVentas = session.createQuery("from DetalleVentaEntity"
					+ " where ventaId = :ventaId")
					.setParameter("ventaId", ventaE.getId())
					.list();
			List<ProductoEntity> productos = new ArrayList<ProductoEntity>();
			for(DetalleVentaEntity detVenta : detVentas){
				productos = 
						session.createQuery("from ProductoEntity"
						+ " where id = :productoId")
						.setParameter("productoId", detVenta.getProductoId())
						.list();
			}
			for(ProductoEntity productoE : productos){
				productosDTO.add(productoE.getProducto());
			}

			EmpleadoEntity empleadoEntity = (EmpleadoEntity)
					session.get(EmpleadoEntity.class, ventaE.getEmpleadoId());
			PuestoEntity puestoEntity = (PuestoEntity)
					session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
			Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
					empleadoEntity.getAppat(),empleadoEntity.getApmat(),
					empleadoEntity.getId(),puestoEntity.getNombre(),
					empleadoEntity.getCorreo());
			ventas.add(
				new VentaEnTienda(
					empleadoDTO,
					((GavetaEntity)session.get(GavetaEntity.class, ventaE.getGavetaId())).getGaveta(),
					ventaE.getImporte(),
					ventaE.getInicio(),
					productosDTO,
					((ClienteEntity)session.get(ClienteEntity.class, ventaE.getCliente())).getCliente()
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

					EmpleadoEntity empleadoEntity = (EmpleadoEntity)
							session.get(EmpleadoEntity.class, plazaE.getEmpleadoId());
					PuestoEntity puestoEntity = (PuestoEntity)
							session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
					Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
							empleadoEntity.getAppat(),empleadoEntity.getApmat(),
							empleadoEntity.getId(),puestoEntity.getNombre(),
							empleadoEntity.getCorreo());
					plantillaPlazas.add(
							new Plaza(
								empleadoDTO,
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
				List<Producto> productosDTO = new ArrayList<Producto>();
				List<DetalleVentaEntity> detVentas = session.createQuery("from DetalleVentaEntity"
						+ " where ventaId = :ventaId")
						.setParameter("ventaId", ventaE.getId())
						.list();
				List<ProductoEntity> productos = new ArrayList<ProductoEntity>();
				for(DetalleVentaEntity detVenta : detVentas){
					productos = 
							session.createQuery("from ProductoEntity"
							+ " where id = :productoId")
							.setParameter("productoId", detVenta.getProductoId())
							.list();
				}
				for(ProductoEntity productoE : productos){
					productosDTO.add(productoE.getProducto());
				}

				EmpleadoEntity empleadoEntity = (EmpleadoEntity)
						session.get(EmpleadoEntity.class, ventaE.getEmpleadoId());
				PuestoEntity puestoEntity = (PuestoEntity)
						session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
				Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
						empleadoEntity.getAppat(),empleadoEntity.getApmat(),
						empleadoEntity.getId(),puestoEntity.getNombre(),
						empleadoEntity.getCorreo());
				ventas.add(
					new VentaEnTienda(
						empleadoDTO,
						((GavetaEntity)session.get(GavetaEntity.class, ventaE.getGavetaId())).getGaveta(),
						ventaE.getImporte(),
						ventaE.getInicio(),
						productosDTO,
						((ClienteEntity)session.get(ClienteEntity.class, ventaE.getCliente())).getCliente()
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

	@Override
	public Cafeteria update(Cafeteria cafeteria) throws Exception {
		Session session = sessionFactory.openSession();
		CafeteriaEntity cafeteriaEntity = (CafeteriaEntity)
				session.get(CafeteriaEntity.class, 
						Integer.valueOf(cafeteria.getIdentificador()));
		DireccionEntity direccionEntity = (DireccionEntity)
				session.get(DireccionEntity.class, cafeteriaEntity.getDireccionId());
		
		String direccion = cafeteria.getDireccion();
		String [] direccionArray = direccion.split(",");
		session.createQuery(""
				+ "UPDATE DireccionEntity "
				+ "set calle = :calle "
				+ ", ciudad = :ciudad "
				+ ", colonia = :colonia "
				+ ", delegacion = :delegacion"
				+ ", numero = :numero"
				+ ", pais = :pais "
				+ "where id = :direccionId")
				.setParameter("calle", direccionArray[0])
				.setParameter("numero",direccionArray[1])
				.setParameter("colonia", direccionArray[2])
				.setParameter("delegacion",direccionArray[3])
				.setParameter("ciudad", direccionArray[4])
				.setParameter("pais",direccionArray[5])
				.setParameter("direccionId",direccionEntity.getId())
				.executeUpdate();
		session.createQuery("UPDATE CafeteriaEntity "
				+ "set aceptaMembresias = :aceptaMembresias "
				+ ", email = :email "
				+ ", estado = :estado "
				+ ", nombre = :nombre"
				+ " WHERE id = :cafeteriaId")
				.setParameter("aceptaMembresias", cafeteria.isAceptaMembresias())
				.setParameter("email", cafeteria.getEmail())
				.setParameter("estado", direccionEntity.getCiudad())
				.setParameter("nombre",cafeteria.getNombre())
				.setParameter("cafeteriaId", Integer.valueOf(cafeteria.getIdentificador()))
				.executeUpdate();
		return cafeteria; 
	}
}
