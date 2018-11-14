import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;

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
				try {
					Double tol = Double.parseDouble(vista.textTol.getText());
					Double[] lados = modelo.calcularLados(Double.parseDouble(volumen), tol);
					pd.redibujarPanelDibujo(lados[0], lados[1], lados[2], volumen);
					vista.resultX.setText("X = " + lados[0] + " " + vista.unidadesMedicion.getSelectedItem()); 
					vista.resultY.setText("Y = " + lados[1] + " " + vista.unidadesMedicion.getSelectedItem()); 
					vista.resultZ.setText("Z = " + lados[2] + " " + vista.unidadesMedicion.getSelectedItem()); 
				} catch (InputMismatchException e2) {
					this.MuestraError("Raíz falsa");
				} catch (InvalidParameterException ex) {
					this.MuestraError(volumen + " No es un valor valido para el volumen");
				} catch (ArithmeticException e3) {
					this.MuestraError("Indeterminación");
				}catch (NumberFormatException e2) {
					this.MuestraError("Por favor ingresa el formato correcto");
				}
			}

			public void MuestraError(String string) {
				JOptionPane.showMessageDialog(null, string, "Error", JOptionPane.WARNING_MESSAGE);
			}

		});

	}
}
