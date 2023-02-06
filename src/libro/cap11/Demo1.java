package libro.cap11;

import java.lang.reflect.Method;

public class Demo1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			// definimos el nombre de la clase (incluyendo el paquete)
			String sClass = "libro.cap04.DeptDAO";
			// obtengo una instancia de Class apuntando a la clase
			Class clazz = Class.forName(sClass);
			// obtengo la lista de methods (de tipo Method) de la clase
			Method mtdos[] = clazz.getDeclaredMethods();
			// recorro la lista de methods y muestro sus nombres
			for (Method mtd : mtdos) {
				System.out.println(mtd.getName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
