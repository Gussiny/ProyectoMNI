import java.security.InvalidParameterException;

public class ModeloEscenario3 {

  public Double calcularProfundidad(Double radio, Double lado, double tol) throws InvalidParameterException{
    if(radio <= 0 || lado <= 0){
      throw new InvalidParameterException();
    }
    int i = 0;
    double x0 = 100.0;
    double diametro = radio*2.0;
    double nextX = 0.0;
    double eRN = 1.0;
    double a1 = lado*lado;
    double a2 = diametro * x0;
    double zg1 = lado/2.0;
    double a,b,c,divisor,d,division = 0;
    int maxIter = 100000;
    while (eRN>tol) {
    	if(i>maxIter) {
    		break;
    	}
    	a = (-lado*diametro*a1) + (zg1*a1*diametro);
    	b = (a1*diametro*x0);
    	c = (radio*diametro*Math.pow(x0, 2));
    	divisor = (a+b-c);
    	d = divisor/Math.pow(a1-a2, 2);
    	
    	i++;
    }
    return radio+lado;

  }

}
