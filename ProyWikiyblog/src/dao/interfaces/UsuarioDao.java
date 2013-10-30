package dao.interfaces;

import beans.UsuarioBean;

public interface UsuarioDao {
	
	public UsuarioBean
	login(String usuario, String password) throws Exception;
	
}