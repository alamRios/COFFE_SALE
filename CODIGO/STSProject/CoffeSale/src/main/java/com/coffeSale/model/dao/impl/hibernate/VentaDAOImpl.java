package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.VentaDAO;
import com.coffeSale.model.dto.Empleado;
import com.coffeSale.model.dto.Producto;
import com.coffeSale.model.dto.Venta;
import com.coffeSale.model.dto.VentaEnTienda;
import com.coffeSale.model.entity.ClienteEntity;
import com.coffeSale.model.entity.DetalleVentaEntity;
import com.coffeSale.model.entity.EmpleadoEntity;
import com.coffeSale.model.entity.GavetaEntity;
import com.coffeSale.model.entity.PlantillaEntity;
import com.coffeSale.model.entity.PlazaEntity;
import com.coffeSale.model.entity.ProductoEntity;
import com.coffeSale.model.entity.PuestoEntity;
import com.coffeSale.model.entity.VentaEntity;

public class VentaDAOImpl implements VentaDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<VentaEntity> findAll() throws Exception {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<VentaEntity> ventas =  session.createQuery("from Venta").list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findAll_DTO() throws Exception {
		Session session = this.sessionFactory.openSession();
		List<VentaEntity> ventas = session.createQuery("from VentaEntity").list();
		List<Venta> ventasDTO = new ArrayList<Venta>();
		List<Producto> productosDTO = new ArrayList<Producto>();
		for(VentaEntity venta : ventas){
			List<DetalleVentaEntity> detVentas = session.createQuery("from DetalleVentaEntity"
					+ " where ventaId = :ventaId")
					.setParameter("ventaId", venta.getId())
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
					session.get(EmpleadoEntity.class, venta.getEmpleadoId());
			PuestoEntity puestoEntity = (PuestoEntity)
					session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
			Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
					empleadoEntity.getAppat(),empleadoEntity.getApmat(),
					empleadoEntity.getId(),puestoEntity.getNombre(),
					empleadoEntity.getCorreo());
			ventasDTO.add(
				new VentaEnTienda(
					empleadoDTO,
					((GavetaEntity)session.get(GavetaEntity.class, venta.getGavetaId())).getGaveta(),
					venta.getImporte(),
					venta.getInicio(),
					productosDTO,
					((ClienteEntity)session.get(ClienteEntity.class, venta.getCliente())).getCliente()
				)
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

	@Override
	public VentaEnTienda persist(VentaEnTienda venta) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		EmpleadoEntity empleadoE = (EmpleadoEntity) 
				session.get(EmpleadoEntity.class,
						venta.getVendedor().getCodigoEmpleado());
		PlazaEntity plazaE = (PlazaEntity)
				session.createQuery("from PlazaEntity where empleadoId = :empleadoId")
				.setParameter("empleadoId", empleadoE.getId())
				.uniqueResult();
		PlantillaEntity plantillaE = (PlantillaEntity) 
				session.createQuery("from PlantillaEntity where id = :plantillaId")
				.setParameter("plantillaId", plazaE.getPlantillaId())
				.uniqueResult();
		GavetaEntity gavetaE = (GavetaEntity)
				session.createQuery("from GavetaEntity where "
						+ "cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", plantillaE.getCafeteriaId())
				.setMaxResults(1)
				.uniqueResult();
		VentaEntity entity = new VentaEntity();
			entity.setInicio(venta.getMomentoVenta());
			entity.setFin(venta.getMomentoVenta());
			entity.setImporte((float)venta.getMontoTotal());
			entity.setEmpleadoId(empleadoE.getId());
			entity.setCafeteriaId(plantillaE.getCafeteriaId());
			if( venta.getComprador().getNoCliente() != 0 )
				entity.setCliente(venta.getComprador().getNoCliente());
			else 
				entity.setCliente(2);
			entity.setGavetaId(gavetaE.getId());
			entity.setPromocionId(1);
		session.persist(entity);
			
		for(Producto producto : venta.getProductos()){
			DetalleVentaEntity detVenE = new DetalleVentaEntity();
				detVenE.setPrecioUnitario(producto.getCosto());
				detVenE.setVentaId(entity.getId());
				detVenE.setProductoId(Integer.valueOf(producto.getIdentificador()));
			session.persist(detVenE);
		}
		
		session.getTransaction().commit();
		session.close();
		return venta; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findByCafeteriaId(String cafeteriaId) throws Exception {
		Session session = this.sessionFactory.openSession();
		List<VentaEntity> ventas = session.createQuery("from VentaEntity"
				+ " where cafeteriaId = :cafeteriaId")
				.setParameter("cafeteriaId", Integer.valueOf(cafeteriaId))
				.list();
		List<Venta> ventasDTO = new ArrayList<Venta>();
		List<Producto> productosDTO = new ArrayList<Producto>();
		for(VentaEntity venta : ventas){
			List<DetalleVentaEntity> detVentas = session.createQuery("from DetalleVentaEntity"
					+ " where ventaId = :ventaId")
					.setParameter("ventaId", venta.getId())
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
					session.get(EmpleadoEntity.class, venta.getEmpleadoId());
			PuestoEntity puestoEntity = (PuestoEntity)
					session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
			Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
					empleadoEntity.getAppat(),empleadoEntity.getApmat(),
					empleadoEntity.getId(),puestoEntity.getNombre(),
					empleadoEntity.getCorreo());
			ventasDTO.add(
				new VentaEnTienda(
					empleadoDTO,
					((GavetaEntity)session.get(GavetaEntity.class, venta.getGavetaId())).getGaveta(),
					venta.getImporte(),
					venta.getInicio(),
					productosDTO,
					((ClienteEntity)session.get(ClienteEntity.class, venta.getCliente())).getCliente()
				)
			);
		}
		return ventasDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findByCafeteriaIdFiltered(String cafeteriaId, Date fechaInicio, 
			Date fechaFinal) throws Exception {
		Session session = this.sessionFactory.openSession();
		List<VentaEntity> ventas = session.createQuery("from VentaEntity"
				+ " where cafeteriaId = :cafeteriaId"
				+ " and inicio >= :fechaInicio"
				+ " and fin <= :fechaFinal")
				.setParameter("cafeteriaId", Integer.valueOf(cafeteriaId))
				.setParameter("fechaInicio", fechaInicio)
				.setParameter("fechaFinal", fechaFinal)
				.list();
		List<Venta> ventasDTO = new ArrayList<Venta>();
		List<Producto> productosDTO = new ArrayList<Producto>();
		for(VentaEntity venta : ventas){
			List<DetalleVentaEntity> detVentas = session.createQuery("from DetalleVentaEntity"
					+ " where ventaId = :ventaId")
					.setParameter("ventaId", venta.getId())
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
					session.get(EmpleadoEntity.class, venta.getEmpleadoId());
			PuestoEntity puestoEntity = (PuestoEntity)
					session.get(PuestoEntity.class, empleadoEntity.getPuestoId());
			Empleado empleadoDTO = new Empleado(empleadoEntity.getNombre(),
					empleadoEntity.getAppat(),empleadoEntity.getApmat(),
					empleadoEntity.getId(),puestoEntity.getNombre(),
					empleadoEntity.getCorreo());
			ventasDTO.add(
				new VentaEnTienda(
					empleadoDTO,
					((GavetaEntity)session.get(GavetaEntity.class, venta.getGavetaId())).getGaveta(),
					venta.getImporte(),
					venta.getInicio(),
					productosDTO,
					((ClienteEntity)session.get(ClienteEntity.class, venta.getCliente())).getCliente()
				)
			);
		}
		return ventasDTO;
	}
}
