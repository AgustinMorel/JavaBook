package libro.cap02.colecciones;

import java.util.Scanner;

public class TestMiColeccion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese Nombre: ");
		String nom = scanner.next();
		// instancio una MiColeccion "especializada" en String
		MiColeccion<String> mc = new MiColeccion<String>(5);
		while (!nom.equals("FIN")) {
			mc.insertar(nom, 0);
			nom = scanner.next();
		}

		String aux;
		for (int i = 0; i < mc.cantidad(); i++) {
			// no es necesario castear porque el metodo obtener
			// retorna un String
			aux = mc.obtener(i);

			System.out.println(aux + " - " + aux.length() + " caracteres");
		}
	}
}
