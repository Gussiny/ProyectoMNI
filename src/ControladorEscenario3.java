import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import javax.swing.JOptionPane;

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
                        Double profundidad = modelo.calcularProfundidad(Double.parseDouble(radio),Double.parseDouble(lado));
                        pd.redibujarPanelDibujo(profundidad,radio,lado);
                      } catch(InvalidParameterException ex){
                        this.MuestraError("No es un valor valido para el volumen");
                      }
                    }

                    public void MuestraError(String string){
                    	JOptionPane.showMessageDialog(null, string);
                    }

        });


}
}
