package com.coffeSale.model.dao.impl.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.coffeSale.model.dao.UsuarioDAO;
import com.coffeSale.model.dto.Usuario;
import com.coffeSale.model.entity.CafeteriaEntity;
import com.coffeSale.model.entity.EmpleadoEntity;
import com.coffeSale.model.entity.PlantillaEntity;
import com.coffeSale.model.entity.PlazaEntity;
import com.coffeSale.model.entity.UsuarioEntity;

public class UsuarioDAOImpl implements UsuarioDAO{
	SessionFactory sessionFactory; 

	@Override
	public Usuario validarLogIn(Usuario usuario) throws Exception {
		Session session = sessionFactory.openSession();
		UsuarioEntity entity = (UsuarioEntity)
				session.createQuery("from UsuarioEntity"
						+ " where nombre = :usuarioNombre"
						+ " and password = :password")
				.setParameter("usuarioNombre", usuario.getNombre())
				.setParameter("password", usuario.getPassword())
				.setMaxResults(1)
				.uniqueResult();
		EmpleadoEntity empleado = (EmpleadoEntity) 
				session.get(
				EmpleadoEntity.class, entity.getIdEmpleado());
		PlazaEntity plaza = (PlazaEntity)
				session.createQuery("from PlazaEntity"
						+ " where empleadoId = :empleadoId")
				.setParameter("empleadoId", empleado.getId())
				.setMaxResults(1)
				.uniqueResult();
		PlantillaEntity plantilla = (PlantillaEntity)
				session.get(PlantillaEntity.class, 
						plaza.getPlantillaId());
		CafeteriaEntity cafeteria = (CafeteriaEntity)
				session.get(CafeteriaEntity.class,
						plantilla.getCafeteriaId());
		usuario.setLineaId(cafeteria.getMarcaId());
		return usuario;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
