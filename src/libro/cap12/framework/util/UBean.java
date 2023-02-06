package libro.cap12.framework.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SuppressWarnings("unchecked")

public class UBean {
	public static void invoqueSetter(Object dto, String attName, Object value) {
		try {
			// dado el attName obtengo el nombre del setter
			String mtdName = getSetterName(attName);
			Class[] argsType = null;
			Method mtd = null;
			try {
				// intento obtener el metodo...
				argsType[0] = value.getClass();
				mtd = dto.getClass().getMethod(mtdName, argsType);
			} catch (NoSuchMethodException ex) {
				// fallo... pruebo con el tipo primitivo
				argsType[0] = _wrapperToType(value.getClass());
				mtd = dto.getClass().getMethod(mtdName, argsType);
			}
			// invoco al setter
			mtd.invoke(dto, value);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	private static Class _wrapperToType(Class clazz) {
		if (clazz.equals(Byte.class))
			return Byte.TYPE;
		if (clazz.equals(Short.class))
			return Short.TYPE;
		if (clazz.equals(Integer.class))
			return Integer.TYPE;
		if (clazz.equals(Long.class))
			return Long.TYPE;
		if (clazz.equals(Character.class))
			return Character.TYPE;
		if (clazz.equals(Float.class))
			return Float.TYPE;
		if (clazz.equals(Double.class))
			return Double.TYPE;
		return clazz;
	}

	public static String getSetterName(String attName) {
		return UString.switchCase("set" + attName, 3);
	}
}
