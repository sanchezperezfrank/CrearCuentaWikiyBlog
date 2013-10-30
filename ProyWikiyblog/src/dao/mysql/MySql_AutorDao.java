package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import beans.*;
import dao.interfaces.*;
import daofactory.MySqlDaoFactory;
import beans.Autor;


public class MySql_AutorDao 
				extends MySqlDaoFactory implements AutorDao {

	@Override
	public boolean registro(String tipocuenta,String nombres,String apellidopate,String apellidomate,String correo,String password,String fechaNacimiento,String tituloblog,String direccionblog) throws Exception {
		// TODO Auto-generated method stub
     boolean flag = false;
		
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i= stmt.executeUpdate("insert into t_autorblog(tipocuenta, nombres,apellidopate,apellidomate,correo,password,fechaNacimiento,tituloblog,direccionblog) " +
					"values ('"+tipocuenta+"','"+nombres+"','"+apellidopate+"','"+apellidomate+"','"+correo+"','"+password+"','"+fechaNacimiento+"','"+tituloblog+"','"+direccionblog+"')");
			;
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
	public Vector<Autor> reporte() throws Exception {
		Vector<Autor> billetera = null;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select  tipocuenta,nombres, apellidopate, apellidomate,correo ,password,fechaNacimiento,tituloblog,direccionblog from t_autorblog");
			
			billetera = new Vector<Autor>();
			while(rs.next()){
				Autor autor = new Autor();
				autor.setTipocuenta(rs.getString("tipocuenta"));
				autor.setNombres(rs.getString("nombres"));
				autor.setApellidopate(rs.getString("apellidopate"));
				autor.setApellidomate(rs.getString("apellidomate"));
				autor.setCorreo(rs.getString("correo"));
				autor.setPassword(rs.getString("password"));
				autor.setFechaNacimiento(rs.getString("fechaNacimiento"));
				autor.setTituloblog(rs.getString("tituloblog"));
				autor.setDireccionblog(rs.getString("direccionblog"));
				
				billetera.add( autor);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return billetera;
		}

	@Override
	public double seleccionarGasto() throws Exception {
		double gasto = 0;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select gasto from t_registrocompras");
			
			while(rs.next()){
				gasto = (gasto+(rs.getDouble("gasto")));
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return gasto;
	}

	
	
	public Autor verificar(String nombres) throws Exception {
		Autor autor= null;
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = 
					stmt.executeQuery("select * from t_autorblog" +
					"where  nombres ='"+nombres+"' ");
			
			if(rs.next()){
				autor = new Autor();
				
				autor.setId(rs.getInt("id"));
				
				
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		
		return autor;
	}	

	

}
