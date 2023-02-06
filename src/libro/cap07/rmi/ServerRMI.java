package libro.cap07.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		System.setProperty("java.rmi.server.hostname","127.0.0.1");
		ObjetoRemotoImple obj = new ObjetoRemotoImple();
		Registry registry = LocateRegistry.getRegistry(1099);

		registry.rebind("OBJRemoto", obj);
	}

}
