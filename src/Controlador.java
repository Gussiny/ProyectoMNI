import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

public class Controlador {
   
	
        private Vista vista;
        private Modelo modelo;
        
        public Controlador(Vista v, Modelo m) {
            
            this.vista = v;
            this.modelo = m;
            this.vista.addCalcularListener(new ActionListener() {
                @SuppressWarnings("unused")
				public void actionPerformed(ActionEvent e) {
                	System.out.println("si jaja");
                	/*
                    Double a = Double.parseDouble(vista.textA.getText());
                    Double b = Double.parseDouble(vista.textB.getText());
                    Double tol = Double.parseDouble(vista.textTol.getText());
                  
                    if(a<tol){
                        this.MuestraError("Valores de a es menor a la tolerancia");
                    }
                    if(b <tol){
                        this.MuestraError("Valores de b es menor a la tolerancia");
                    }
                    Double x = 0.0;
                    try{
                        x = modelo.regresarX(a,b,tol);
                    }
                    catch(InvalidParameterException ex){
                        this.MuestraError("No hay valores criticos reales");
                    }
                    if(x==null){
                        this.MuestraError("No hay valores máxmimos para los valores de a y b dados");
                    }
                    else if(x!=null){
                        vista.result.setText(String.valueOf(x));
                    }
                    else{
                        vista.result.setText("Indefinido");
                    }
                    */
                }
                 
                public void MuestraError(String string){
                    vista.error.setText(string);
                }
                
            });
        }


}
