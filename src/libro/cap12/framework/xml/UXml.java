package libro.cap12.framework.xml;

public class UXml {
	public static XTag getTableTAG(String dtoName) {
		String path = "/framework/data-access/mapping/table";
		String attname = "type";
		String attvalue = dtoName;
		return XMLFactory.getByAttribute(path, attname, attvalue);
	}

	public static XTag[] getFieldsTAG(String dtoName) {
		return getTableTAG(dtoName).getSubtags("field");
	}

	public static XTag getConnectionPoolTAG() {
		String path = "/framework/data-access/connection-pool";
		return XMLFactory.getByPath(path);
	}
}
