
public class Controlador {
    public class Controlador {
	
        private Vista vista;
        private Modelo modelo;
        
        public Controlador(Vista v, Modelo m) {
            
            this.vista = v;
            this.modelo = m;
            this.vista.addCalcularListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double a = Double.parseDouble(vista.textA.getText());
                    double b = Double.parseDouble(vista.textB.getText());
                    double tol = Double.parseDouble(vista.textTol.getText());

                    if(a<tol){
                        this.MuestraError("Valores de a es menor a la tolerancia")
                    }
                    if(b <tol){
                        this.MuestraError("Valores de b es menor a la tolerancia")
                    }
                    double x = 0.0;
                    try{
                        x = modelo.regresaX(a,b,tol);
                    }
                    catch(InvalidParameterException e){
                        this.MuestraError("No hay valores críticos reales")
                    }
                    if(x==null){
                        this.MuestraError("No hay valores máxmimos para los valores de a y b dados")
                    }
                    else if(x!=null){
                        this.result.setText(String.valueOf(x));
                    }
                    else{
                        this.result.setText("Indefinido");
                    }
                }
            });
        }

        public void MuestraError(String string){
            vista.error.setText(string);
        }
}
