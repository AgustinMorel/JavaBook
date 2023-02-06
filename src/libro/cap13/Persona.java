package libro.cap13;

import java.io.Serializable;

public class Persona implements Serializable {
	private int edad;
	private String nombre;
	private String dni;

	public Persona(int e, String n, String d) {
		edad = e;
		nombre = n;
		dni = d;
	}

	public String toString() {
		return nombre + ", " + edad + ", " + dni;
	}
}
