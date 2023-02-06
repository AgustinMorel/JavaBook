package libro.cap07;

import java.io.*;
import java.net.*;

public class DemoServerMT {
	public static void main(String[] args) throws Exception {
		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);
		while (true) {
			try {
				// ServerSocket me da el Socket
				s = ss.accept();
				// instancio un Thread
				(new Tarea(s)).start();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	static class Tarea extends Thread {
		private Socket s = null;
		private ObjectInputStream ois = null;
		private ObjectOutputStream oos = null;

		public Tarea(Socket socket) {
			this.s = socket;
		}

		public void run() {
			try {
				// informacion en la consola
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				// enmascaro la entrada y salida de bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				// leo el nombre que envia el cliente
				String nom = (String) ois.readObject();

				// armo el saludo personalizado que le quiero enviar
				String saludo = "Hola Mundo (" + nom + ") _ " + System.currentTimeMillis();
				// envio el saludo al cliente
				oos.writeObject(saludo);
				System.out.println("Saludo enviado...");
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (oos != null)
						oos.close();
					if (ois != null)
						ois.close();
					if (s != null)
						s.close();
					System.out.println("Conexion cerrada!");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
