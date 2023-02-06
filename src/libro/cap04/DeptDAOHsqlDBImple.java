package libro.cap04;

import java.util.Collection;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import libro.cap03.demo.UConnection;
import libro.cap08.app.sql.ConnectionPool;

public class DeptDAOHsqlDBImple extends DeptDAO {
	public Collection<DeptDTO> buscarTodos() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = ConnectionPool.getPool().getConnection();
			String sql = "SELECT deptno, dname, dciudad FROM dept ";

			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			DeptDTO dto = null;

			while (rs.next()) {
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setDciudad(rs.getString("dciudad"));
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
				if (con != null) {
					ConnectionPool.getPool().releaseConnection(con);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
