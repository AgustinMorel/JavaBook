package libro.cap03.demo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect {
	public static void main(String[] args) {
		// parametros de la conexion
		String usr = "sa";
		String pwd = "";
		String driver = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:hsql://localhost:9001/testdb";
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// -------------
			// ** PARTE 1 **
			// -------------
			// levanto el driver
			Class.forName(driver);
			// establezco la conexion
			con = UConnection.getConnection();
			// -------------
			// ** PARTE 2 **
			// -------------
			// defino un query
			String sql = "SELECT empno, ename, efecha, deptno FROM emp";

			// preparo la sentencia que voy a ejecutar
			pstm = con.prepareStatement(sql);
			// ejecuto la sentencia y obtengo los resultados en rs
			rs = pstm.executeQuery();
			// itero los resultados (registros)
			while (rs.next()) {
				// muestro los campos del registro actual
				System.out.print(rs.getInt("empno") + ", ");
				System.out.print(rs.getString("ename") + ", ");
				System.out.print(rs.getDate("efecha") + ", ");
				System.out.println(rs.getInt("deptno"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				// -------------
				// ** PARTE 3 **
				// -------------
				// cierro todos los recursos en orden inverso al que
				// fueron adquiridos
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
