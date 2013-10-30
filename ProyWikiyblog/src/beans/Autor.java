package beans;
import java.util.Date;
public class Autor {
 private int id ;
 private String tipocuenta;
 private String nombres;
 private String apellidopate;
 private String apellidomate;
 private String correo;
 private String password;
 private String fechaNacimiento;
 private String tituloblog;
 private String direccionblog;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTipocuenta() {
	return tipocuenta;
}
public void setTipocuenta(String tipocuenta) {
	this.tipocuenta = tipocuenta;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApellidopate() {
	return apellidopate;
}
public void setApellidopate(String apellidopate) {
	this.apellidopate = apellidopate;
}
public String getApellidomate() {
	return apellidomate;
}
public void setApellidomate(String apellidomate) {
	this.apellidomate = apellidomate;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getFechaNacimiento() {
	return fechaNacimiento;
}
public void setFechaNacimiento(String fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
public String getTituloblog() {
	return tituloblog;
}
public void setTituloblog(String tituloblog) {
	this.tituloblog = tituloblog;
}
public String getDireccionblog() {
	return direccionblog;
}
public void setDireccionblog(String direccionblog) {
	this.direccionblog = direccionblog;
}
 
 
}
