package libro.cap10.mapping;

public class ConnectionTag {
	private String name;
	private String usr;
	private String pwd;
	private String driver;
	private String url;
	

	public String toString() {
		return name + ", " + usr + ", " + pwd + ", " + url + ", " + driver;
	}

	public String getName() {
		return name;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUsr() {
		return usr;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setUsr(String u) {
		this.usr = u;
	}

	public void setPwd(String p) {
		this.pwd = p;
	}

	public void setUrl(String u) {
		this.url = u;
	}

	public void setDriver(String d) {
		this.driver = d;
	}

}
