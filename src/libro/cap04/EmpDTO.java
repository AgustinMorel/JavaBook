package libro.cap04;

import java.sql.Date;

public class EmpDTO {
	private int empno;
	private String ename;
	private Date efecha;
	private int deptno;

	public String toString() {
		return empno + ", " + ename + ", " + efecha + ", " + deptno;
	}

	public void setEmpno(int eno) {
		this.empno = eno;
	}

	public void setEname(String enam) {
		this.ename = enam;
	}

	public void setEfecha(Date efech) {
		this.efecha = efech;
	}

	public void setDeptno(int dno) {
		this.deptno = dno;
	}
	
	public int getEmpno () {
		return empno;
	}
	
	public String getEname () {
		return ename;
	}
	 public Date getEfecha () {
		 return efecha;
	 }
}
