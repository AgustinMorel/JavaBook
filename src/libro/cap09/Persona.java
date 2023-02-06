package libro.cap09;

public class Persona {
	private String nombre;
	private int edad;
	private String nacionalidad;

	public Persona(String nombre, int edad, String nacionalidad) {
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return nombre + ", " + edad + " anios, " + nacionalidad;
	}

}
