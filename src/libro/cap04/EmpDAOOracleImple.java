package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;
import libro.cap03.demo.UConnection;

public class EmpDAOOracleImple extends EmpDAO {
	public String queryBuscarUltimosEmpleados() {
		String sql = "";
		sql += "SELECT empno, ename, efecha, deptno, ROWNUM AS rn ";
		sql += "FROM (SELECT empno, ename, efecha, deptno ";
		sql += " FROM emp ";
		sql += " ORDER BY efecha DESC) ";
		sql += "WHERE rm <= ? ";
		return sql;
	}
}
