package dao.interfaces;

import java.util.Vector;
import java.util.Date;

import beans.Autor;
import beans.UsuarioBean;

public interface AutorDao {

	public boolean registro(String tipocuenta,String nombres,String apellidopate,String apellidomate,String correo,String password,String fechaNacimiento,String tituloblog,String direccionblog) throws Exception;
	
	public Vector<Autor> reporte() throws Exception;
	
    public double seleccionarGasto() throws Exception;
	
    public Autor verificar(String nombres) throws Exception;
			
}
