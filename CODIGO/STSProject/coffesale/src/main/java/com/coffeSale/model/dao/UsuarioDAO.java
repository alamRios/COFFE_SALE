package com.coffeSale.model.dao;

import com.coffeSale.model.dto.Usuario;

public interface UsuarioDAO {
	public Usuario validarLogIn(Usuario usuario) throws Exception;
}
