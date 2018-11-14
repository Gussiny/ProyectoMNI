import java.security.InvalidParameterException;

public class ModeloEscenario1{

  public Double[] calcularLados(Double volumen) throws InvalidParameterException{
    if(volumen <= 0){
      throw new InvalidParameterException();
    }
    Double[] lados = new Double[3];
    lados[0] = volumen + 1;
    lados[1] = volumen + 2;
    lados[2] = volumen + 3;
    return lados;
  }

}
