package libro.cap12.framework.xml;

import java.util.Hashtable;
import java.util.Stack;
import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLFactory extends DefaultHandler {
	private static XMLFactory instancia = null;
	private Stack<XTag> pila;
	private XTag raiz;

	private XMLFactory() {
		pila = new Stack<XTag>();
	}

	public static void load(String xmlfilename) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			instancia = new XMLFactory();
			sp.parse(xmlfilename, instancia);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// paso los atributos a una hashtable
		Hashtable<String, String> atts = _cloneAttributes(attributes);
		XTag t = new XTag(name, atts);
		if (pila.empty()) {
			raiz = t;
		}
		pila.push(t);
	}

	public void endElement(String uri, String localName, String name) throws SAXException {
		if (pila.size() > 1) {
			XTag hijo = pila.pop();
			XTag padre = pila.pop();
			padre.addSubtag(hijo);
			pila.push(padre);
		}
	}

	private Hashtable<String, String> _cloneAttributes(Attributes attributes) {
		Hashtable<String, String> atts = new Hashtable<String, String>();
		for (int i = 0; i < attributes.getLength(); i++) {
			atts.put(attributes.getQName(i), attributes.getValue(i));
		}

		return atts;
	}

	public static XTag getByPath(String path) {
		return instancia.raiz.getSubtag(path);
	}

	public static XTag getByAttribute(String path, String attname, String value) {
		return instancia.raiz.getSubtagByAttribute(path, attname, value);
	}
}
