package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.interfaces.CuentaDao;
import daofactory.MySqlDaoFactory;

public class MySql_CuentaDao 
				extends MySqlDaoFactory implements CuentaDao {

	@Override
	public boolean ingresar(double saldoTotal) throws Exception {
		boolean flag = false;
		
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i= stmt.executeUpdate("insert into t_cuenta (saldoTotal)" +
									"values ('"+saldoTotal+"')");
			if(i==1){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	@Override
	public double seleccionarSaldoTotal( )
			throws Exception {
		// TODO Auto-generated method stub
		double saldo = 0;
		
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM t_cuenta");
			
			while(rs.next()){
				
				saldo = ((rs.getDouble("saldoTotal")));
	
			}			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return saldo;
	}
	
	
	
	

}
