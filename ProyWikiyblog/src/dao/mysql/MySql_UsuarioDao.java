package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import beans.UsuarioBean;

import dao.interfaces.UsuarioDao;
import daofactory.MySqlDaoFactory;

public class MySql_UsuarioDao 
				extends MySqlDaoFactory implements UsuarioDao {

	@Override
	public UsuarioBean login(String usuario, String password) throws Exception {
		UsuarioBean usuario1 = null;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = 
					stmt.executeQuery("select * from t_usuario " +
					"where usuario='"+usuario+"' and password='"+password+"'");
			
			if(rs.next()){
				usuario1 = new UsuarioBean();
				usuario1.setIdUsuario(rs.getInt("idUsuario"));
				usuario1.setNombre(rs.getString("nombre"));
				usuario1.setApellido(rs.getString("apellido"));
				
				
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		
		return usuario1;
	}	

}
