package libro.cap08.app.ver2;

import java.util.Collection;

public class ClientePruebaRMI {
	public static void main(String[] args) throws Exception {
		// obtengo una referencia al objeto remoto
		FacadeRemoto f = (FacadeRemoto) ServiceLocatorRMI.lookup("FacadeRemoto");
		// incovo un metodo
		Collection<String> sDepts = f.obtenerDepartamentos();

		for (String s : sDepts) {
			System.out.println(s);
		}

		// incovo otro metodo
		Collection<String> sEmps = f.obtenerEmpleados(1);

		for (String s : sEmps) {
			System.out.println(s);
		}
	}
}
