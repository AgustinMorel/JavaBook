package libro.cap12.framework.test;

import libro.cap04.DeptDTO;
import libro.cap04.EmpDTO;
import libro.cap12.framework.XSession;

public class Test3 {
	public static void main(String[] args) {
		XFactory.load("configuracion.xml");

		// defino un DeptDTO
		DeptDTO ddto = new DeptDTO();
		// seteo sus atributos...
		// defino un EmpDTO
		EmpDTO edto = new EmpDTO();
		// seteo sus atributos...

		// obtengo la session
		XSession sess = XFactory.getInstancia().getSession();

		// comienzo una transaccion
		XTransaction trx = sess.beginTransaction();
		sess.insert(ddto);
		sess.insert(edto);
		trx.commint(); // COMMIT !!!
	}
}
