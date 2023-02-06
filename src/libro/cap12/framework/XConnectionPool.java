package libro.cap12.framework;

import java.util.Vector;
import java.sql.Connection;

public class XConnectionPool {
	private Vector<Connection> libres;
	private Vector<Connection> usadas;
	private Hashtable<Long, Connection> enTransaccion;

	// ...
	Connection getConnectionForTransaction() {
		Connection con = getConnection();
		long threadID = Thread.currentThread().getId();
		enTransaccion.put(threadID, con);
		return con;
	}

	public synchronized Connection getConnection() {
		// verifico si hay una transaccion abierta
		long threadID = Thread.currentThread().getId();
		Connection con = enTransaccion.get(threadID);
		if (con != null) {
			return con;
		}
		if (libres.size() <= 0) {
			if (!_crearMasConexiones()) {
				throw new RuntimeException("No hay conexiones ...");
			}
		}
		con = libres.remove(0);
		usadas.add(con);
		return con;
	}

	void releaseConnectionForTransaction(Connection con) {
		long threadID = Thread.currentThread().getId();
		enTransaccion.remove(threadID);
		releaseConnection(con);
	}

}
