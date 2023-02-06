package libro.cap10;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestXML {
	public static void main(String[] args) {
		try {
			// obtenemos el parser
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			// parseamos el archivo depts.xml
			sp.parse("connectionpool.xml", new CPoolXMLHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
