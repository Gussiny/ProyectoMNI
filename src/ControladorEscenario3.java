import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;

import javax.swing.JOptionPane;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class ControladorEscenario3 {


        private VistaEscenario3 vista;
        private ModeloEscenario3 modelo;
        private PanelDibujoEscenario3 pd;
        public String radio,lado;
        public ControladorEscenario3(VistaEscenario3 v, ModeloEscenario3 m, PanelDibujoEscenario3 pd2) {
            this.vista = v;
            this.modelo = m;
            this.pd = pd2;
            this.vista.addCalcularListener(new ActionListener() {
                            @SuppressWarnings("unused")
            				public void actionPerformed(ActionEvent e) {
                      radio = vista.textR.getText();
                      lado = vista.textL.getText();

                      try{
                    	double tol = Double.parseDouble(vista.textTol.getText());
                        Double profundidad = modelo.calcularProfundidad(Double.parseDouble(radio),Double.parseDouble(lado),tol);
                        pd.redibujarPanelDibujo(profundidad,radio,lado);
                        vista.resultX.setText("X= " + profundidad);
                      } catch(InvalidParameterException ex){
                        this.MuestraError("No es un valor valido para el volumen");
                      }catch(NumberFormatException e2) {
                    	  this.MuestraError("Por Favor Ingresa El Formato Correcto");
                      }
                      catch (IllegalAnnotationException e3) {
						this.MuestraError("El radio debe ser menor al lado");
					}
                    }

                    public void MuestraError(String string){
                    	JOptionPane.showMessageDialog(null, string);
                    }

        });


}
}
