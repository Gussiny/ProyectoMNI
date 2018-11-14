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

	public int extX = 400;
	public int extY = 200;
	public int extXi = 50;
	public int extYi = 100;

	public int intX = 300;
	public int intY = 100;
	public int intXi = 100;
	public int intYi = 150;

	public int lineaAxi = 50;
	public int lineaAx = 450;
	public int lineaAy = 320; // 330

	public int lineaByi = 100;
	public int lineaBx = 465; // 480
	public int lineaBy = 300;

	public int lineaXxi = 400;
	public int lineaXx = 450;
	public int lineaXy = 90;

	public int esq1x = 50;
	public int esq1y = 100;
	public int esq2x = 50;
	public int esq2y = 250;
	public int esq3x = 400;
	public int esq3y = 100;
	public int esq4x = 400;
	public int esq4y = 250;

	public int strAx = 230;
	public int strAy = 350;
	public int strBx = 470;
	public int strBy = 200;
	public int strXx = 400;
	public int strXy = 80;

	public PanelDibujo(Double a, Double b) {
		super();
		this.setPreferredSize(new Dimension(810,480));
		this.setBackground(Color.WHITE);
		this.valorA = a.toString();
		this.valorB = b.toString();
		this.valorX = "0.0";
		this.valorMedida = " m";

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.drawRect(extXi, extYi, extX, extY);	//	EXTERIOR DE LA CAJA
		g.setColor(Color.DARK_GRAY);
		g.drawRect(intXi, intYi, intX, intY);	//	INTERIOR DE LA CAJA
		g.setColor(Color.BLACK);

		g.fillRect(esq1x, esq1y, 50, 50);	//	ESQUINA SUPERIOR IZQUIERDA
		g.fillRect(esq2x, esq2y, 50, 50);	//	ESQUINA SUPERIOR DERECHA
		g.fillRect(esq3x, esq3y, 50, 50);	//	ESQUINA INFERIOR IZQUIERDA
		g.fillRect(esq4x, esq4y, 50, 50);	//	ESQUINA INFERIOR DERECHA

		g.drawLine(lineaAxi, lineaAy, lineaAx, lineaAy);	//	LINEA DE MEDIDA DE a
		g.drawLine(lineaBx, lineaByi, lineaBx, lineaBy);	//	LINEA DE MEDIDA DE b
		g.drawLine(lineaXxi, lineaXy, lineaXx, lineaXy);	//	LINEA DE MEDIDA DE x

		g.drawString("a = " + this.valorA + this.valorMedida, strAx, strAy);	//	VALOR DE a
		g.drawString("b = " + this.valorB + this.valorMedida, strBx, strBy);	//	VALOR DE b
		g.drawString("x = " + this.valorX + this.valorMedida, strXx, strXy);		//	VALOR DE x

		//	CAJA MOLDEADA
		g.drawRect(500, 250, 160, 40); // Cara delantera
		g.drawRect(600, 200, 160, 40); // Cara trasera
		
		g.drawLine(660, 250, 760, 200);
		g.drawLine(660, 290, 760, 240);
		g.drawLine(500, 250, 600, 200);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(500, 290, 600, 240);
		g.setColor(Color.BLACK);
		
		//	LINEAS DE MEDIDA CAJA MOLDEADA
		
		g.drawLine(770, 200, 770, 240); // Linea que mide el lado x
		g.drawString("x",775,225);
		g.drawLine(665, 300, 760, 250);	//	LINEA B 
		g.drawLine(500, 300, 660, 300);	//	LINEA A

		//this.repaint();
	}


	public void redibujarPanelDibujo(Double a, Double b, String xS) {
		//rotarFigura(a, b);
		
		int difX = (int) Math.round(a) -(int) Double.parseDouble(this.valorA);
		int difY = (int) Math.round(b) -(int) Double.parseDouble(this.valorB);
		if(difX >= 50) {
			difX = 25;
		}else if(difX < -200) {
			difX = -100;
		}
		if(difY >= 100) {
			difY = 50;
		}else if(difY < -50) {
			difY = -25;
		}
		System.out.println(difX);
		if(difX > 0) {
			//System.out.println(this.valorA + " < " + a.toString() );
			this.extX += difX;
			this.intX += difX;
			this.strBx += difX;
			this.lineaBx += difX;
			this.esq3x += difX;
			this.esq4x += difX;
			this.lineaAx += difX;
			this.lineaXxi += difX;
			this.lineaXx += difX;
			this.strAx += difX;
			this.strXx += difX;
		}else if(difX < 0){
			this.extX += difX;
			this.intX += difX;
			this.strBx += difX;
			this.lineaBx += difX;
			this.esq3x += difX;
			this.esq4x += difX;
			this.lineaAx += difX;
			this.lineaXxi += difX;
			this.lineaXx += difX;
			this.strAx += difX;
			this.strXx += difX;
		}
		
		if(difY > 0) {
			//System.out.println(this.valorA + " < " + a.toString() );
			this.extY += difY;
			this.intY += difY;
			this.strBy += difY;
			this.lineaBy += difY;
			this.lineaXy += difY;
			this.esq2y += difY;
			this.esq4y += difY;
			this.lineaAy += difY;
			this.strAy += difY;
			this.strXy = this.esq3y - 20;
			this.lineaXy = this.esq3y - 10;
		}else if(difY < 0){
			this.extY += difY;
			this.intY += difY;
			this.strBy += difY;
			this.lineaBy += difY;
			this.lineaXy += difY;
			this.esq2y += difY;
			this.esq4y += difY;
			this.lineaAy += difY;
			this.strAy += difY;
			this.strXy = this.esq3y - 20;
			this.lineaXy = this.esq3y - 10;
			
		}
		
		this.valorA = a.toString();
		this.valorB = b.toString();
		this.valorX = xS;
		repaint();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.refresh) {
			//System.out.println("hola");
			this.repaint();
		}

	}

	private void rotarFigura(Double a, Double b) {
		  if(a < b) {
	        	this.extX = 200;
	        	this.extY = 400;
	        	this.extYi = 25;
	        	this.intX = 100;
	        	this.intY = 300;
	        	this.intYi = 75;
	        	this.esq1x = this.esq2x = extXi;
	        	this.esq1y = this.esq3y = extYi;
	        	this.esq2y = this.esq4y = 375;
	        	this.esq3x = this.esq4x = 200;
	        	this.lineaAxi = 50;
	        	this.lineaAx = 250;
	        	this.lineaAy = extY + 40; // 330

	        	lineaByi = 25;
	        	lineaBx = lineaAx + 20; // 480
	        	lineaBy = lineaByi + 400;

	        	lineaXxi = this.esq3x;
	        	lineaXx = lineaXxi + 40;
	        	lineaXy = this.esq3y - 10;

	        	this.strAx = 125;
	        	this.strAy = lineaAy + 20;
	        	this.strBx = lineaBx + 20;
	        	this.strBy = 200;
	        	this.strXx = this.esq3x;
	        	this.strXy = lineaXy - 2;


	        }else {
	        	extX = 400;
	        	extY = 200;
	        	extXi = 50;
	        	extYi = 100;

	        	intX = 300;
	        	intY = 100;
	        	intXi = 100;
	        	intYi = 150;

	        	this.esq1x = this.esq2x = extXi;
	        	this.esq1y = this.esq3y = extYi;
	        	this.esq2y = this.esq4y = 250;
	        	this.esq3x = this.esq4x = 400;

	        	lineaAxi = 50;
	        	lineaAx = 450;
	        	lineaAy = 320; // 330

	        	lineaByi = 100;
	        	lineaBx = 460; // 480
	        	lineaBy = 300;

	        	lineaXxi = 400;
	        	lineaXx = 450;
	        	lineaXy = 90;
	        	strAx = 230;
	        	strAy = 350;
	        	strBx = 470;
	        	strBy = 200;
	        	strXx = 400;
	        	strXy = 80;

	        }
	}
}
