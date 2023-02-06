package libro.cap10.mapping;

import libro.cap10.mapping.ConnectionPoolTag;
import libro.cap10.mapping.ConnectionTag;
import libro.cap10.mapping.PoolTag;

public class TestXML {
	public static void main(String[] args)
	 {
	 //ConnectionPoolTag cpt = new ConnectionPoolTag();
	 ConnectionPoolTag cp = ConnectionPoolTag.getInstancia();
	 System.out.println(cp);
	 
	 // obtengo y muestro los datos de la conexion HSQLDB
	 ConnectionTag c1 = cp.getJdbc().getConnectionTag("HSQLDB");
	 //System.out.println(c1);
	 System.out.println(c1.getDriver());
	 System.out.println(c1.getUrl());
	 System.out.println(c1.getUsr());
	 System.out.println(c1.getPwd());
	 
	 // obtengo y muestro los datos de la conexion ORACLE
	 
	 ConnectionTag c2 = cp.getJdbc().getConnectionTag("ORACLE");
	 System.out.println(c2.getDriver());
	 System.out.println(c2.getUrl());
	 System.out.println(c2.getUsr());
	 System.out.println(c2.getPwd());
	 
	// obtengo y muestro los datos del pool P1
	 PoolTag t1 = cp.getPools().getPoolTag("P1");
	 System.out.println(t1.getMaxsize());
	 System.out.println(t1.getMinsize());
	 System.out.println(t1.getSteep());
	 // obtengo y muestro los datos del pool P2
	 PoolTag t2 = cp.getPools().getPoolTag("P2");
	 System.out.println(t2.getMaxsize());
	 System.out.println(t2.getMinsize());
	 System.out.println(t2.getSteep());
	 }

}
