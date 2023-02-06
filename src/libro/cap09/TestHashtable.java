package libro.cap09;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashtable {
	public static void main(String[] args) {
		// instancio varias personas
		Persona p1 = new Persona("Pablo", 33, "Argentino");
		Persona p2 = new Persona("Juan", 25, "Mexicano");
		Persona p3 = new Persona("Pedro", 18, "Espanol");
		// creo la tabla de hash
		Hashtable<String, Persona> tabla = new Hashtable<String, Persona>();
		// agrego las personas a la tabla tomando su nombre como clave
		tabla.put(p1.getNombre(), p1);
		tabla.put(p2.getNombre(), p2);
		tabla.put(p3.getNombre(), p3);
		// acceso a cada elemento de la tabla por su clave
		System.out.println(tabla.get("Pablo"));
		System.out.println(tabla.get("Juan"));
		System.out.println(tabla.get("Pedro"));
		// en este caso la tabla retornara null ya que no hay ningun
		// objeto asociado a la clave "Rolo"
		System.out.println(tabla.get("Rolo"));
		// obtengo una enumeracion de las clave existentes en la tabla,
		// la recorro y por cada una accedo al elemento asociado para
		// mostrar "clave = valor"
		String aux;
		Enumeration<String> keys = tabla.keys();
		while (keys.hasMoreElements()) {
			aux = keys.nextElement();
			System.out.println(aux + " = " + tabla.get(aux));
		}
	}
}
