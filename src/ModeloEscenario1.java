import java.security.InvalidParameterException;
import java.util.InputMismatchException;

//import com.sun.javafx.css.CalculatedValue;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.InternalError;
//import com.sun.org.apache.xpath.internal.operations.Div;
//
//import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

public class ModeloEscenario1 {

	double func(double x, double v) {
		// 3x^5-2Vy-4V
		return 3 * x * x * x * x * x - 2 * x * v - 4 * v;
	}

	double derivFunc(double x, double v) {
		return 15 * x * x * x * x - 2 * v;
	}

	double newtonRaphson(double x, double v, double tol) {

		int maxIter = 1000000;
		int i = 0;
		double derivada = derivFunc(x, v);
		if (derivada <= tol) {
			throw new ArithmeticException("Indeterminado");
		}
		double h = func(x, v) / derivada;
		while (Math.abs(h) >= tol) {
			if (i > maxIter) {
				break;
			}
			h = func(x, v) / derivFunc(x, v);
			x = x - h;
			i++;
		}

		return x;
	}

	public Double[] calcularLados(Double volumen, double tol){
		if (volumen <= 0) {
			throw new InvalidParameterException();
		}
		double x0 = Math.cbrt(volumen);
		double y = newtonRaphson(x0, volumen, tol);
		double x = y * y;
		double z = volumen / (y * x);

		double tieneQueSer0 = func(y, volumen);
		if (tieneQueSer0 > tol) {
			throw new InputMismatchException("Raíz falsa uwu");
		}


		Double[] lados = new Double[3];
		lados[0] = Math.round(x*10000.0)/10000.0;
		lados[1] = Math.round(y*10000.0)/10000.0;
		lados[2] = Math.round(z*10000.0)/10000.0;
		return lados;
	}
	/*
	 * public static void main(String[] args) { calcularLados(1.0, 0.01); }
	 */

}
