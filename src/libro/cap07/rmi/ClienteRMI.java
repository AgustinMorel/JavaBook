package libro.cap07.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class ClienteRMI {
	public static void main(String[] args) throws Exception {
		// obtengo referencia a la registry del servidor (IP+PORT)
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);

		// ubico el objeto remoto identificado por "OBJRemoto"
		ObjetoRemoto objRemoto;
		objRemoto = (ObjetoRemoto) reg.lookup("OBJRemoto");
		// invoco sus metodos como lo hago con cualquier otro objeto
		String saludo = objRemoto.obtenerSaludo("Pablo");
		System.out.println(saludo);
	}
}
