import java.security.InvalidParameterException;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class ModeloEscenario3 {

	static public Double calcularProfundidad(Double radio, Double lado, double tol) throws InvalidParameterException {
		if (radio <= 0 || lado <= 0) {
			throw new InvalidParameterException();
		}
		if(radio>=lado) {
			throw new IllegalAnnotationException("El radio debe ser menor al lado");
		}
		int i = 0;
		double x0 = lado / 2.0;
		double diametro = radio * 2.0;
		double nextX = 0.0;
		double eRN = 1.0;
		double a1 = lado * lado;
		double a2 = diametro * x0;
		double zg1 = x0;
		double a, b, c, divisor, d, division, derivada = 0;
		int maxIter = 1000;
		while (eRN > tol) {
			if (i > maxIter) {
				break;
			}
			a = (-lado * diametro * a1) + (zg1 * a1 * diametro);
			b = (a1 * diametro * x0);
			c = (radio * diametro * Math.pow(x0, 2));
			divisor = round(a + b - c);
			d = divisor / Math.pow(a1 - a2, 2);
			divisor = round(d);

			derivada = round( ((b / x0) - (2 * c / x0)) * Math.pow(a1 - a2, 2) - ((a + b - c) * (2 * -a2 / x0) * (a1 - a2)));
			derivada = round(derivada / Math.pow(a1 - a2, 4));
			nextX = x0 - (divisor / derivada);
			eRN = calcularError(nextX, x0);


			x0 = round(nextX);
			i++;

		}
		return x0;

	}

	private static double round(double d) {
		// TODO Auto-generated method stub
		return Math.round(d * 1000.0) / 1000.0;
	}

	static private double calcularError(double nextX, double x0) {

		return Math.abs(nextX - x0) / nextX;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(calcularProfundidad(5.0, 50.0, 0.001));
	 * 
	 * }
	 */
}
