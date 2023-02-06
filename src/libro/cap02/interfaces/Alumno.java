package libro.cap02.interfaces;

public class Alumno implements Comparable<Alumno> {
	private String nombre;
	private int edad;
	private double notaPromedio;

	// constructor
	public Alumno(String nom, int e, double np) {
		this.nombre = nom;
		this.edad = e;
		this.notaPromedio = np;
	}

	// metodo heredado de la interface Comparable
	public int compareTo(Alumno otroAlumno) {
		return this.edad - otroAlumno.edad;
	}

	public String toString() {
		return nombre + ", " + edad + ", " + notaPromedio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getNotaPromedio () {
		return notaPromedio;
	}

}
