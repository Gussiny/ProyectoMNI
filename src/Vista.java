
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame{

   public JLabel titulo = new JLabel();
   public JLabel labelA = new JLabel("a:");
   public JLabel labelB = new JLabel("b:");
   public JLabel labelTol = new JLabel("Tol:");
   public JTextField textA = new JTextField();
   public JTextField textB = new JTextField();
   public JTextField textTol = new JTextField();
   public JPanel panelA = new JPanel();
   public JPanel panelB = new JPanel();
   public JPanel panelTol = new JPanel();
   public JButton bCalcular = new JButton("Calcular");
   public JLabel result = new JLabel();
   public JLabel error = new JLabel();

   public Vista(){

     JPanel panelDibujo = new JPanel();
     ImageIcon image = new ImageIcon("Box-Image.png");
     JLabel labelDibujo = new JLabel(image);
     panelDibujo.setBackground(Color.white);
     JPanel panelControl = new JPanel();
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setSize(1000,500);
     this.setLocation(175,80);
     this.setLayout(new BorderLayout(10,10));
     this.setResizable(false);

     panelControl.setLayout(new BoxLayout(panelControl,BoxLayout.Y_AXIS));
     panelA.setLayout(new FlowLayout());
     panelB.setLayout(new FlowLayout());
     panelTol.setLayout(new FlowLayout());


     titulo.setText("Proyecto Final\n");
     textA.setPreferredSize(new Dimension(100,25));
     textB.setPreferredSize(new Dimension(100,25));
     textTol.setPreferredSize(new Dimension(100,25));
     result.setText("Se necesita que 'x' sea de tamaño: ");
     error.setText("No hay error");



     panelA.add(labelA);
     panelA.add(textA);
     panelB.add(labelB);
     panelB.add(textB);
     panelTol.add(labelTol);
     panelTol.add(textTol);

     panelControl.add(titulo);
     panelControl.add(panelA);
     panelControl.add(panelB);
     panelControl.add(panelTol);
     panelControl.add(bCalcular);
     panelControl.add(result);
     panelControl.add(error);

     panelDibujo.add(labelDibujo);


     this.add(panelDibujo,BorderLayout.CENTER);
     this.add(panelControl,BorderLayout.EAST);
     this.setVisible(true);
   }

public void addCalcularListener(ActionListener actionListener) {
	this.bCalcular.addActionListener(actionListener);
	
}

}
