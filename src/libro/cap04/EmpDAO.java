package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import libro.cap03.demo.UConnection;
import libro.cap08.app.sql.ConnectionPool;

public abstract class EmpDAO {
	protected abstract String queryBuscarUltimosEmpleados();

	public Collection<EmpDTO> buscarUltimosEmpleados(int n) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = ConnectionPool.getPool().getConnection();
			// sentencia SQL propietaria de HSQLDB
			String sql = queryBuscarUltimosEmpleados();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, n);
			rs = pstm.executeQuery();
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			while (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setEfecha(rs.getDate("efecha"));
				dto.setDeptno(rs.getInt("deptno"));
				ret.add(dto);
			}
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if( con!=null ) 
				 {
				 ConnectionPool.getPool().releaseConnection(con);
				 }
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public Collection<EmpDTO> buscarXDept(int deptno) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = UConnection.getConnection();
			String sql = "";
			sql += "SELECT empno, ename, efecha, deptno ";
			sql += "FROM emp ";
			sql += "WHERE deptno = ? ";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			rs = pstm.executeQuery();
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			while (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setEfecha(rs.getDate("efecha"));
				dto.setDeptno(rs.getInt("deptno"));

				ret.add(dto);
			}
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
