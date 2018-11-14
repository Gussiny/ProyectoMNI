import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDibujoEscenario1 extends JPanel{
	public String valorX,valorY,valorZ,valorMedida,valorV;
	public PanelDibujoEscenario1(Double v) {
		super();
		this.setPreferredSize(new Dimension(810,480));
		this.setBackground(Color.WHITE);
		this.valorV = v.toString();
		this.valorX = "0.0";
		this.valorY = "0.0";
		this.valorZ = "0.0";
		this.valorMedida = " m";

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(160,150,550,150); //Horizontal arriba izq
		g.drawLine(160,360,550,360); //Horizontal abajo
		g.drawLine(230,80,630,80); // Horizontal hasta arriba
		g.drawLine(160,150,160,360); // Vertical izq
		g.drawLine(550,150,550,360); //Vertical mitad
		g.drawLine(630,80,630,280); // Vertical derecha
		g.drawLine(160,150,230,80); //Diagonal arriba izq
		g.drawLine(550,150,630,80); //Diagonal arriba der
		g.drawLine(550,360,630,280); //Diagonal abajo der

		g.drawString("x = " + this.valorX + this.valorMedida,330,380);
		g.drawString("y = " + this.valorY + this.valorMedida,600,330);
		g.drawString("z = " + this.valorZ + this.valorMedida,640,190);
		g.drawString("Volumen = " + this.valorV + this.valorMedida + "^3",160,430);
		this.repaint();
	}


	public void redibujarPanelDibujo(Double x, Double y, Double z, String vS) {
		this.valorX = x.toString();
		this.valorY = y.toString();
		this.valorZ = z.toString();
		this.valorV = vS;
		repaint();
	}
}
