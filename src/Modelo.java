
public class Modelo {
    public double regresarX(double a,double b, double tol){
        boolean x1b = true;
        boolean x2b = true;
        boolean esMaximo = true;
        double xsqrt = 3*a*a+6*a*b+3*b*b-64*a*b;

        if(xsqrt<tol){
            throw new InvalidParameterException();
        }
        double x1 = (3*a+3*b+Math.sqrt(xsqrt))/16;
        double x2 = (3*a+3*b-Math.sqrt(xsqrt))/16;

        if(2*x1>=b || 2*x1>=a){
            x1b = false;
        }   
        if(2*x2>=b || 2*x2>=a){
            x2b = false;
        }

        double y1 = x1*(b-2*x1)(a-2*x1);
        double y2 = x2*(b-2*x2)(a-2*x2);

        if(x1b && x2b){
            if(y2>y1){
                x1b = false;
            }
            else{
                x2b = false;
            }
        }

        if(x1b){
            double cercanoA = x1 + 1;
            double cercanoB = x1 - 1;
            double yA = cercanoA*(b-2*cercanoA)(a-2*cercanoA);
            double yB = cercanoB*(b-2*cercanoB)(a-2*cercanoB);

            if(yA>y1 || yB>y1){
                esMaximo = false;
            }
        }
        else{
            double cercanoA = x2 + 1;
            double cercanoB = x2 - 1;
            double yA = cercanoA*(b-2*cercanoA)(a-2*cercanoA);
            double yB = cercanoB*(b-2*cercanoB)(a-2*cercanoB);

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


        return null;

        

    }
}
