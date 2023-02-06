package libro.cap04;

import java.util.Collection;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		// instancio el facade a traves del factory method
		Facade facade = (Facade) UFactory.getInstancia("FACADE");
		Collection<DeptDTO> collDepts = facade.obtenerDepartamentos();
		_mostrarDepartamentos(collDepts);

		Scanner scanner = new Scanner(System.in);
		int deptno = scanner.nextInt();
		Collection<EmpDTO> collEmps = facade.obtenerEmpleados(deptno);
		_mostrarEmpleados(collEmps, deptno);
	}

	private static void _mostrarDepartamentos(Collection<DeptDTO> collDepts) {
		System.out.println("Departamentos: ");
		System.out.println("-------------------->");
		for (DeptDTO dto : collDepts) {
			System.out.print("| " + dto.getDeptno() + "\t");
			System.out.print("| " + dto.getDname() + "\t");
			System.out.println("| " + dto.getDciudad() + "\t|");
		}
		System.out.println("<--------------------");
		System.out.print("Ingrese deptno: ");
	}

	private static void _mostrarEmpleados(Collection<EmpDTO> collEmps, int deptno) {
		System.out.println("Empleados del departamento: " + deptno);
		System.out.println("-------------------->");
		for (EmpDTO dto : collEmps) {
			System.out.print("| " + dto.getEmpno() + "\t");
			System.out.print("| " + dto.getEname() + "\t");
			System.out.println("| " + dto.getEfecha() + "\t|");
		}
		System.out.println("<--------------------");
	}
}
