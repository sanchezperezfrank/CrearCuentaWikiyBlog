package daofactory;

import dao.interfaces.*;

public abstract class DaoFactory {
	public static final int MYSQL 		=1;
	public static final int SQLSERVER 	=2;
	public static final int ORACLE 		=3;
	
	public abstract AutorbaseDao getAutorbaseDao();
	public abstract UsuarioDao getUsuarioDao();
	public abstract CuentaDao getCuentaDao();
	public abstract AutorDao getAutorDao();

	public static DaoFactory getDAOFactory(int factory){
		switch (factory) {
			case MYSQL:
				return new MySqlDaoFactory();
			case SQLSERVER:
				//return new SqlServerDaoFactory();
				return null;
			case ORACLE:
				//return new OracleDaoFactory();
				return null;
			default:
				return null;
		}
	}
}