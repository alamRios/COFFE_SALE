package com.coffeSale.model.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.ProductoDAO;
import com.coffeSale.model.dto.Producto;
import com.coffeSale.model.entity.ProductoEntity;

public class ProductoDAOImpl implements ProductoDAO{
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductoEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoEntity> find(int idEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoEntity update(ProductoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoEntity create(ProductoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ProductoEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll_DTO() throws Exception {
		Session session = sessionFactory.openSession();
		List<ProductoEntity> productosE = 
				session.createQuery("from ProductoEntity").list();
		List<Producto> productos = new ArrayList<Producto>();
		for(ProductoEntity productoE : productosE){
			productos.add(productoE.getProducto());
		}
		return productos; 
	}

	@Override
	public Producto findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByNombre_DTO(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByCosto_DTO(double costo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(ProductoEntity producto) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.persist(producto);
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
	public List<Producto> findByLinea(int lineaId) throws Exception {
		Session session = sessionFactory.openSession();
		List<Producto> productos = new ArrayList<Producto>();
		List<ProductoEntity> productosE = session.createQuery("from ProductoEntity"
				+ " where marca = :lineaId")
				.setParameter("lineaId", lineaId)
				.list();
		for(ProductoEntity productoE : productosE){
			productos.add(productoE.getProducto());
		}
		return productos;
	}

	@Override
	public Producto persist(Producto producto) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductoEntity productoE = new ProductoEntity(); 
			productoE.setCosto((float)producto.getCosto());
			productoE.setNombre(producto.getNombre());
			productoE.setMarca(producto.getCodigoLinea());
		session.persist(productoE);
		session.getTransaction().commit();
		session.close();
		return productoE.getProducto(); 
	}

	@Override
	public void delete(Producto producto) throws Exception {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM ProductoEntity "
							+ "WHERE id = :productoId")
				.setParameter("productoId", Integer.parseInt(producto.getIdentificador()))
				.executeUpdate();
	}

	@Override
	public Producto update(Producto producto) throws Exception {
		Session session = sessionFactory.openSession();
		session.createQuery(""
				+ "UPDATE ProductoEntity "
				+ "set costo = :ncosto, "
					+ "nombre = :nnombre "
				+ "WHERE id = :productoId")
				.setParameter("ncosto", (float)producto.getCosto())
				.setParameter("nnombre", producto.getNombre())
				.setParameter("productoId", Integer.valueOf(producto.getIdentificador()))
				.executeUpdate();
		return producto; 
	}
}
