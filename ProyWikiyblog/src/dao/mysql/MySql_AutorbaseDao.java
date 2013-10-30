package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import beans.AutorBase;

import dao.interfaces.AutorbaseDao;
import daofactory.MySqlDaoFactory;

public class MySql_AutorbaseDao 
				extends MySqlDaoFactory implements AutorbaseDao {

	@Override
	public AutorBase verificar(String nombres, String apellidopate, String apellidomate) throws Exception {
		AutorBase autor = null;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = 
					stmt.executeQuery("select * from t_autor " +
					"where nombres='"+nombres+"' and apellidopate='"+apellidopate+"'and apellidomate='"+apellidomate+"' and tipo='acreditado'");
			
			if(rs.next()){
				autor= new AutorBase();
				autor.setId(rs.getInt("id"));
		
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		
		return autor;
	}	

}
