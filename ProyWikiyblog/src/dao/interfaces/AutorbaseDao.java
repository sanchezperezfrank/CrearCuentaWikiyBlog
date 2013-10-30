package dao.interfaces;

import beans.AutorBase;

public interface AutorbaseDao {
	
	public AutorBase
	verificar(String nombres, String apellidopate, String apellidomate) throws Exception;
	
}