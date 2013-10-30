package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.*;
import dao.mysql.*;

public class MySqlDaoFactory extends DaoFactory {
	
	public UsuarioDao getUsuarioDao(){
		return new MySql_UsuarioDao();
	}	
	public AutorbaseDao getAutorbaseDao(){
		return new MySql_AutorbaseDao();
	}	
	public CuentaDao getCuentaDao() {
		return new MySql_CuentaDao();
	}	
	public AutorDao getAutorDao() {
		return new MySql_AutorDao();
	}

	
	public static Connection obtenerConexion(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bdautor";
			con = DriverManager.getConnection(url, "root", "root");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return con;
	}

}