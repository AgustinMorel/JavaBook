package libro.cap12.framework.test;

import libro.cap04.DeptDTO;
import libro.cap04.EmpDTO;
import libro.cap12.framework.XFactory;
import libro.cap12.framework.XSession;

public class TestDB1 {
	public static void main(String[] args) {
		// leo el archivo de configuracion
		XFactory.load("configuracion.xml");
		// obtengo una session
		XSession session = XFactory.getInstancia().getSession();
		// busco el departamento cuyo deptno es 1
		DeptDTO dept;
		dept = (DeptDTO) session.findByPrimaryKey(DeptDTO.class, 1);
		System.out.println(dept);
		// busco el empleado cuyo empno es 10
		EmpDTO emp = (EmpDTO) session.findByPrimaryKey(EmpDTO.class, 10);
		System.out.println(emp);
	}
}
