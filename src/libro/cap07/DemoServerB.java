package libro.cap07;

import java.io.*;
import java.net.*;

public class DemoServerB {
	private static final int BUFFER_LENGTH = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		BufferedWriter bw = null;

		Socket s = null;
		ServerSocket ss = new ServerSocket(5432);

		while (true) {
			try {
				// espero la conexion
				s = ss.accept();

				// informacion en la consola
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));

				char bEnviar[];
				char bRecive[] = new char[BUFFER_LENGTH];

				StringBuffer sb = new StringBuffer();
				// leo el nombre que envia el cliente
				int n;
				while ((n = br.read(bRecive)) == BUFFER_LENGTH) {
					sb.append(bRecive);
				}
				sb.append(bRecive, 0, n);

				String saludo = "Hola Mundo (" + sb + ") _ " + System.currentTimeMillis();
				// envio el saludo al cliente
				bEnviar = saludo.toCharArray();
				bw.write(bEnviar);
				bw.flush();
				System.out.println("Saludo enviado...");
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
				if (s != null)
					s.close();
				System.out.println("Conexion cerrada!");
			}

		}
	}
}
