import java.security.InvalidParameterException;

public class Modelo {
    public Double regresarX(Double a,Double b, Double tol){
        boolean x1b = true;
        boolean x2b = true;
        boolean esMaximo = true;
        Double xsqrt = 16*a*a+32*a*b+16*b*b-48*a*b;

        if(xsqrt<tol){
            throw new InvalidParameterException();
        }
        Double x1 = (4*a+4*b+Math.sqrt(xsqrt))/24;
        Double x2 = (4*a+4*b-Math.sqrt(xsqrt))/24;

        if(2*x1>=b || 2*x1>=a){
            x1b = false;
        }   
        if(2*x2>=b || 2*x2>=a){
            x2b = false;
        }

        Double y1 = x1*(b-2*x1)*(a-2*x1);
        Double y2 = x2*(b-2*x2)*(a-2*x2);

        if(x1b && x2b){
            if(y2>y1){
                x1b = false;
            }
            else{
                x2b = false;
            }
        }

        if(x1b){
            Double cercanoA = x1 + 1;
            Double cercanoB = x1 - 1;
            Double yA = cercanoA*(b-2*cercanoA)*(a-2*cercanoA);
            Double yB = cercanoB*(b-2*cercanoB)*(a-2*cercanoB);

            if(yA>y1 || yB>y1){
                esMaximo = false;
            }
        }
        else{
            Double cercanoA = x2 + 1;
            Double cercanoB = x2 - 1;
            Double yA = cercanoA*(b-2*cercanoA)*(a-2*cercanoA);
            Double yB = cercanoB*(b-2*cercanoB)*(a-2*cercanoB);

            if(yA>y2 || yB>y2){
                esMaximo = false;
            }
        }

        if(esMaximo && x1b){
            return x1;
        }

        else if(esMaximo && x2b){
            return x2;
        }


        return  null;

        

    }
}
