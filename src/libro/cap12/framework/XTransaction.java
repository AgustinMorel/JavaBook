package libro.cap12.framework;

import java.sql.Connection;

public class XTransaction {	
	private static XFactory tm;
	private XConnectionPool pool;
	
	public XTransaction beginTransaction() {
		// instancio un XTransactionManager
		XTransaction tm = new XTransaction();

		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();

		// el tm manejara su propia conexion
		tm.setConnection(pool.getConnectionForTransaction());
		return tm;
	}
	
	public void setConnection(Connection con) {
		this.pool = (XConnectionPool) con;
	}
	

	public void commit() {
		try {
			connection.commit();
			XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
			pool.releaseConnectionForTransaction(connection);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void rollback() {
		try {
			connection.rollback();
			XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
			pool.releaseConnectionForTransaction(connection);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
