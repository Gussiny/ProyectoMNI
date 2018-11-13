import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDibujo extends JPanel implements ActionListener{
	public String valorA, valorB, valorX, valorMedida;
	private JButton refresh = new JButton("REFRESCA");
	public PanelDibujo(Double a, Double b) {
		super();
		this.setPreferredSize(new Dimension(810,480));
		this.setBackground(Color.WHITE);
		//this.add(refresh);
		this.valorA = a.toString();
		this.valorB = b.toString();
		this.valorX = "0.0";
		this.valorMedida = " m";
		//this.refresh.addActionListener(this);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println(this.valorA);
		//System.out.println(this.valorB);
		g.drawRect(50, 100, 400, 200);	//	EXTERIOR DE LA CAJA
		g.drawRect(100, 150, 300, 100);	//	INTERIOR DE LA CAJA
		g.setColor(Color.BLACK);
		
		g.fillRect(50, 100, 50, 50);	//	ESQUINA SUPERIOR IZQUIERDA
		g.fillRect(50, 250, 50, 50);	//	ESQUINA SUPERIOR DERECHA
		g.fillRect(400, 100, 50, 50);	//	ESQUINA INFERIOR IZQUIERDA
		g.fillRect(400, 250, 50, 50);	//	ESQUINA INFERIOR DERECHA
		
		g.drawLine(50, 330, 450, 330);	//	LINEA DE MEDIDA DE a
		g.drawLine(480, 300, 480, 100);	//	LINEA DE MEDIDA DE b
		g.drawLine(400, 90, 450, 90);	//	LINEA DE MEDIDA DE x
		
		g.drawString("a = " + this.valorA + this.valorMedida, 230, 350);	//	VALOR DE a
		g.drawString("b = " + this.valorB + this.valorMedida, 500, 200);	//	VALOR DE b
		g.drawString("x = " + this.valorX + this.valorMedida, 400, 80);		//	VALOR DE x
		this.repaint();
	}
	
	
	public void redibujarPanelDibujo(Double a, Double b, String xS) {
		this.valorA = a.toString();
		this.valorB = b.toString();
		this.valorX = xS;
		int escA = String.valueOf((int) Math.round(a)).length();
        int escB = String.valueOf((int) Math.round(b)).length();
        int ex = (int) Math.pow(10., escA);
        int az =  (int) (a%ex);
        System.out.println(az);
        System.out.println(ex);
        System.out.println(escA);
        System.out.println(escB);
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.refresh) {
			//System.out.println("hola");
			this.repaint();
		}
		
	}
}
