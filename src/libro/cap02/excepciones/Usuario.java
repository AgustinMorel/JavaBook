package libro.cap02.excepciones;

import libro.cap02.interfaces.Alumno;

public class Usuario {
	private String usrname;
	private String password;
	private String nombre;
	private String email;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setUsrname(String usr) {
		this.usrname = usr;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public void setNombre(String name) {
		this.nombre = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString () {
		return nombre + " se ha logueado correctamente";
	}
}
