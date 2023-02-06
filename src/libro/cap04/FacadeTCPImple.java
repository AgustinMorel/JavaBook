package libro.cap04;

import java.util.Collection;
import libro.cap08.app.ver1.ServiceLocatorTCP;

public class FacadeTCPImple implements Facade {
	public Collection<DeptDTO> obtenerDepartamentos() {
		return ServiceLocatorTCP.obtenerDepartamentos();
	}

	public Collection<EmpDTO> obtenerEmpleados(int deptno) {
		return ServiceLocatorTCP.obtenerEmpleados(deptno);
	}
}
