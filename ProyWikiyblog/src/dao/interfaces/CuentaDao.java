package dao.interfaces;

public interface CuentaDao {
	
	public boolean ingresar(double saldoTotal) throws Exception;
	
	public double seleccionarSaldoTotal() throws Exception;
	
	

}
