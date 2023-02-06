package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import libro.cap03.demo.UConnection;

public class EmpDAOHsqlDBImple extends EmpDAO {
	public String queryBuscarUltimosEmpleados() {
		String sql = "";
		sql += "SELECT empno, ename, hiredate, deptno ";
		sql += "FROM emp ";
		sql += "ORDER BY hiredate DESC ";
		sql += "LIMIT ? ";
		return sql;
	}
}
