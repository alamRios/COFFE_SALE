package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class UsuarioEntity implements Serializable{
	private static final long serialVersionUID = 383258231822845046L;
	
	@Id
	@Column(name="USUARIO_ID", columnDefinition = "serial")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="usuario_usuario_id_seq", name="usuario_usuario_id_seq")
	@GeneratedValue(generator="usuario_usuario_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="USUARIO_PASSWORD")
	private String password; 
	
	@Column(name="USUARIO_EMPLEADO_ID")
	private int idEmpleado; 
	
	@Column(name="USUARIO_NOMBRE")
	private String nombre;

	public UsuarioEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", password=" + password + ", idEmpleado=" + idEmpleado + ", nombre="
				+ nombre + "]";
	}
}
