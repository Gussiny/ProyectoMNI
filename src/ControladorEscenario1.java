import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import javax.swing.JOptionPane;

public class ControladorEscenario1 {


        private VistaEscenario1 vista;
        private ModeloEscenario1 modelo;
        private PanelDibujoEscenario1 pd;
        public String volumen;
        public ControladorEscenario1(VistaEscenario1 v, ModeloEscenario1 m, PanelDibujoEscenario1 pd2) {

            this.vista = v;
            this.modelo = m;
            this.pd = pd2;
            this.vista.addCalcularListener(new ActionListener() {
                            @SuppressWarnings("unused")
            				public void actionPerformed(ActionEvent e) {
                      volumen = vista.textV.getText();

                      try{
                          Double[] lados = modelo.calcularLados(Double.parseDouble(volumen));
                          pd.redibujarPanelDibujo(lados[0],lados[1],lados[2],volumen);
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
