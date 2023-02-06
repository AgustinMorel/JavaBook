package libro.cap02.instancias;

public class TestGC {
	private static int cont = 0;

	public TestGC() {
		cont++;
		System.out.println(cont);
	}

	public void finalize() {
		cont--;
	}

	public static void main(String args[]) {
		while (true) {
			new TestGC();
		}
	}
}
