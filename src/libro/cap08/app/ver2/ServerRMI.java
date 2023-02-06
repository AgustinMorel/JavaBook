package libro.cap08.app.ver2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import libro.cap08.app.ver2.FacadeRemotoImple;

public class ServerRMI {
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		System.setProperty("java.rmi.server.hostname","127.0.0.1");
		FacadeRemotoImple f = new FacadeRemotoImple();
		Registry registry = LocateRegistry.getRegistry(1099);

		registry.rebind("FacadeRemoto", f);
	}
}
