package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPT")

public class Dept {
	@Id
	 @Column(name="deptno")
	 private Integer deptno;
	 @Column(name="dname")
	 private String dname;
	 @Column(name="loc")
	 private String loc;
}
