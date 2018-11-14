import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import javax.swing.JOptionPane;

public class Controlador {


        private Vista vista;
        private Modelo modelo;
        private PanelDibujo pd;
        public Double a= 0.,b=0.;
        public Controlador(Vista v, Modelo m, PanelDibujo pd2) {

            this.vista = v;
            this.modelo = m;
            this.pd = pd2;
            this.vista.addCalcularListener(new ActionListener() {
                @SuppressWarnings("unused")
				public void actionPerformed(ActionEvent e) {
                	try {
                		a = Double.parseDouble(vista.textA.getText());
                        b = Double.parseDouble(vista.textB.getText());
                        Double tol = Double.parseDouble(vista.textTol.getText());

                        if(a<tol){
                            this.MuestraError("Valor de 'a' es MENOR a la TOLERANCIA");
                        }
                        if(b <tol){
                            this.MuestraError("Valor de 'b' es MENOR a la TOLERANCIA");
                        }
                        Double x = 0.0;
                        try{
                            x = modelo.regresarX(a,b,tol);
                        }
                        catch(InvalidParameterException ex){
                            this.MuestraError("No hay valores criticos reales");
                        }
                        if(x==null){
                            this.MuestraError("No hay valores maximos para los valores de a y b dados");
                        }
                        else if(x!=null){
                        	String xS =  String.valueOf(Math.round(x*10000.0)/10000.0);
                            vista.result.setText("X = " + xS + pd.valorMedida);
                            pd.redibujarPanelDibujo(a, b, xS);

                        }
                        else{
                            vista.result.setText("Indefinido");
                        }
                	}
                	catch(NumberFormatException exc) {
                		this.MuestraError("Por favor ingrese el formato correcto");
                	}
                }
                public void MuestraError(String string){
                	JOptionPane.showMessageDialog(null, string, "Error", JOptionPane.WARNING_MESSAGE);
                    //vista.error.setText(string);
                }
            });
        }


}
