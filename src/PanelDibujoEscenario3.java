import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDibujoEscenario3 extends JPanel{
	public String valorMedida,valorR,valorL,valorX;
	public PanelDibujoEscenario3(Double r, Double l) {
		super();
		this.setPreferredSize(new Dimension(810,480));
		this.setBackground(Color.WHITE);
		this.valorR = r.toString();
		this.valorL = l.toString();
		this.valorX = "0.0";
		this.valorMedida = " m";

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(230,170,270,180); // Cara frontal
		g.drawLine(280,110,550,110); // Linea hasta arriba
		g.drawLine(230,170,280,110); // Diagonal izq
		g.drawLine(500,170,550,110); // Diagonal centro
		g.drawLine(500,350,550,290); // Diagonal der
		g.drawLine(550,110,550,290); // Vertical de caja

		g.drawOval(315,125,150,30); // Agujero arriba
		g.drawLine(390,140,465,140); // Radio

		g.drawString("Radio = " + this.valorR + this.valorMedida,390,90);
		g.drawString("L = " + this.valorL + this.valorMedida,330,380);
		g.drawString("L = " + this.valorL + this.valorMedida,535,325);
		g.drawString("L = " + this.valorL + this.valorMedida,560,230);
		g.drawString("x = " + this.valorX + this.valorMedida,330,250);

		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(315,140,315,290); // Vertical izq de hoyo
		g.drawLine(465,140,465,290); // Vertical der de hoyo
		g.drawOval(315,275,150,30); // Ovalo inferior
		this.repaint();
	}


	public void redibujarPanelDibujo(Double x,String rS,String lS) {
		this.valorX = x.toString();
		this.valorR = rS;
		this.valorL = lS;
		repaint();
	}

}
