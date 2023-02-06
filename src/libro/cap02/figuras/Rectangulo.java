package libro.cap02.figuras;

public class Rectangulo extends FiguraGeometrica {
	private double base;
	private double altura;

	public Rectangulo(double b, double h)
	 {
	 super("Rectangulo"); // constructor del padre
	 base = b;
	 altura = h;
	 }

	public double area() {
		return base * altura;
	}
	// :
	// setters y getters
	// :
}
