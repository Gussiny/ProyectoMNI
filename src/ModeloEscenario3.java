import java.security.InvalidParameterException;

public class ModeloEscenario3 {

  public Double calcularProfundidad(Double radio, Double lado) throws InvalidParameterException{
    if(radio <= 0 || lado <= 0){
      throw new InvalidParameterException();
    }

    return radio+lado;

  }

}
