package libro.cap04;

public class DeptDTO {
	private int deptno;
	private String dname;
	private String dciudad;

	public String toString() {
		return deptno + ", " + dname + ", " + dciudad;
	}
	public void setDeptno (int dnum) {
		this.deptno = dnum;
	}
	
	public void setDname (String dnam) {
		this.dname = dnam;
	}
	
	public void setDciudad (String dciu) {
		this.dciudad = dciu;
	}
	
	public int getDeptno() {
		return deptno;
	}
	
	public String getDname () {
		return dname;
	}
	
	public String getDciudad() {
		return dciudad;
	}
	
}
