package libro.cap03.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoDelete {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			// obtengo la conexion
			con = UConnection.getConnection();
			// seteo el autocommit en false
			con.setAutoCommit(false);
			// defino y ejecuto la sentencia DELETE
			String sql = "DELETE FROM emp WHERE empno = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, 20);
			int rtdo = pstm.executeUpdate();
			// se afecto una sola fila como esperabamos...
			if (rtdo == 1) {
				// todo OK entonces commiteo la operacion
				con.commit();
			} else {
				throw new RuntimeException("Error...");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				// rollback "por las dudas"
				if (con != null)
					con.rollback();
				if (pstm != null)
					pstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
