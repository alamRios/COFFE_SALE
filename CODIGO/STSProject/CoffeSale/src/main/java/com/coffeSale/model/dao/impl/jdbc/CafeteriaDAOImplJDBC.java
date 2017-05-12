package com.coffeSale.model.dao.impl.jdbc;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.coffeSale.model.dao.CafeteriaDAO;
import com.coffeSale.model.dto.CafeteriaDTO;
import com.coffeSale.model.entity.Cafeteria;
import com.coffeSale.util.Constantes;

public class CafeteriaDAOImplJDBC implements CafeteriaDAO, Serializable{
	private static final long serialVersionUID = -8043486670737859511L;

	@Override
	public List<Cafeteria> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cafeteria update(Cafeteria entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cafeteria create(Cafeteria entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cafeteria entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CafeteriaDTO> findAll_DTO() throws Exception {
		List<CafeteriaDTO> res = new ArrayList<CafeteriaDTO>();
		
		Connection conn = null;
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", Constantes.userDB);
		connectionProps.put("password", Constantes.passDB);
		CallableStatement cs = null; 
		ResultSet rs = null; 
		try{
			conn = DriverManager.getConnection(
						"jdbc:"+Constantes.dbManager+":"+
						"//"+Constantes.dbPath+
						"/"+Constantes.dbName +
						";create=true",
						connectionProps
					);
			cs = conn.prepareCall("{call SP_TODAS_CAFETERIAS}");
			rs = cs.executeQuery(); 
			
			//CafeteriaDTO cafeteria = null; 
			while(rs.next()){
				//TODO: Consumir resultset y hacer instancias de todo 
				//para llenar la instancia
			}
		}catch(SQLException sqlEx){
			throw sqlEx;
		}
		
		return res;
	}

	@Override
	public CafeteriaDTO findById_DTO(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
