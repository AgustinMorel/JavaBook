package libro.cap08.app.ver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;

import java.util.Collection;
import libro.cap04.DeptDTO;

public class TestSrv1 {
	public static void main(String[] args) throws Exception {
		Collection<DeptDTO> coll;
		coll = ServiceLocatorTCP.obtenerDepartamentos();
		for (DeptDTO dto : coll) {
			System.out.println(dto);
		}
	}

}
