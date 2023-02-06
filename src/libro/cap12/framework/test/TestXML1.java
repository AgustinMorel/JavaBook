package libro.cap12.framework.test;

import libro.cap12.framework.xml.XMLFactory;
import libro.cap12.framework.xml.XTag;

public class TestXML1 {
	public static void main(String[] args) {
		// leemos el archivo y lo cargamos en memoria
		XMLFactory.load("configuracion.xml");
		// accedo al tag especificando su "ruta"
		String path = "/framework/data-access/connection-pool";
		XTag tag = XMLFactory.getByPath(path);
		
		System.out.println(tag);
		
		/*// accedo a los valores de los atributos
		String usr = tag.getAtts().get("usr");
		String pwd = tag.getAtts().get("pwd");
		String url = tag.getAtts().get("url");
		String driver = tag.getAtts().get("driver");
		String sMinsize = tag.getAtts().get("minsize");
		String sMaxsize = tag.getAtts().get("maxsize");
		String sSteep = tag.getAtts().get("steep");
		
		System.out.println(usr);
		System.out.println(pwd);
		System.out.println(url);
		System.out.println(driver);
		System.out.println(sMinsize);
		System.out.println(sMaxsize);
		System.out.println(sSteep);
		*/
	}
}
