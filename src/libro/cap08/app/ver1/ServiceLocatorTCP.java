package libro.cap08.app.ver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;

import libro.cap04.DeptDTO;
import libro.cap04.EmpDTO;

public class ServiceLocatorTCP {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 5432;

	public static Collection<DeptDTO> obtenerDepartamentos() {
		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			// me conecto...
			s = new Socket(SERVER_IP, SERVER_PORT);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			// solicito servicio codigo 1 (obtenerDepartamentos)
			dos.writeInt(1);
			// el server me indica cuantos departamentos va a enviar
			int n = dis.readInt();
			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			String aux;
			for (int i = 0; i < n; i++) {
				// leo el i-esimo string
				aux = dis.readUTF();
				// cada string que recibo lo convierto a DeptDTO
				// y lo agrego a la coleccion de retorno
				ret.add(UDto.stringToDeptDTO(aux));
			}
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (dos != null)
					dos.close();
				if (s != null)
					s.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public static Collection<EmpDTO> obtenerEmpleados(int deptno) {
		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			// me conecto
			s = new Socket(SERVER_IP, SERVER_PORT);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			// solicito servicio codigo 2 (obtenerEmpleados)
			dos.writeInt(2);
			// envio el numero de departamento
			dos.writeInt(deptno);
			// el server me indica cuantos empleados va a enviar
			int n = dis.readInt();
			Vector<EmpDTO> ret = new Vector<EmpDTO>(n);
			String aux;
			for (int i = 0; i < n; i++) {
				// leo el i-esimo string
				aux = dis.readUTF();
				// cada string que recibo lo convierto a EmpDTO
				// y lo agrego a la coleccion de retorno
				ret.add(UDto.stringToEmpDTO(aux));
			}
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (dos != null)
					dos.close();
				if (s != null)
					s.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

}
