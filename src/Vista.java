
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JPanel{

	public JLabel titulo = new JLabel();
	public JLabel labelA = new JLabel(" a:  ");
	public JLabel labelB = new JLabel(" b:  ");
	public JLabel labelTol = new JLabel("Tolerancia: ");
	public JTextField textA = new JTextField();
	public JTextField textB = new JTextField();
	public JTextField textTol = new JTextField();

	public JPanel panelA = new JPanel();
	public JPanel panelB = new JPanel();
	public JPanel panelTol = new JPanel();
	public JPanel panelX = new JPanel();
	public JPanel panelBtCalcular = new JPanel();
	public JPanel panelUnidades = new JPanel();

	public JButton bCalcular = new JButton("Calcular");
	public JLabel result = new JLabel();
	public JLabel error = new JLabel();
	public JLabel panelMedidaA = new JLabel(" m");
	public JLabel panelMedidaB = new JLabel(" m");
	public JComboBox<String> unidadesMedicion = new JComboBox<String>();


	private PanelDibujo pd;

	public Vista(PanelDibujo pd2){
		//super("CREADOR DE CAJAS");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1080,480);
		//this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(1,1));
		//this.setResizable(false);

		//JPanel panelDibujo = new JPanel();
		//ImageIcon image = new ImageIcon("Box-Image.png");
		//JLabel labelDibujo = new JLabel(image);
		//panelDibujo.setBackground(Color.LIGHT_GRAY);
		JPanel panelControl = new JPanel();

		panelControl.setLayout(new BoxLayout(panelControl,BoxLayout.Y_AXIS));
		panelControl.setPreferredSize(new Dimension(200, 120));
		this.inicarCombo();

		panelA.setLayout(new GridBagLayout());
		panelB.setLayout(new GridBagLayout());
		panelTol.setLayout(new GridBagLayout());
		panelX.setLayout(new GridBagLayout());
		panelBtCalcular.setLayout(new GridBagLayout());
		panelUnidades.setLayout(new GridBagLayout());

		titulo.setText("PANEL DE CONTROL\n");
		textA.setPreferredSize(new Dimension(100,25));
		textB.setPreferredSize(new Dimension(100,25));
		textTol.setPreferredSize(new Dimension(100,25));
		result.setFont(new Font("Arial",Font.BOLD, 26));
		result.setText("X = ");
		//error.setText("No hay error");

		panelUnidades.add(new JLabel("Unidad de medida: "));
		panelUnidades.add(unidadesMedicion);

		panelA.add(labelA);
		panelA.add(textA);
		panelA.add(panelMedidaA);

		panelB.add(labelB);
		panelB.add(textB);
		panelB.add(panelMedidaB);

		panelTol.add(labelTol);
		panelTol.add(textTol);
		textTol.setText("0.001");

		panelX.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelX.add(result);

		panelBtCalcular.add(bCalcular);


		//panelControl.add(titulo);
		panelControl.add(panelUnidades);
		panelControl.add(panelA);
		panelControl.add(panelB);
		panelControl.add(panelTol);
		panelControl.add(panelX);
		panelControl.add(panelBtCalcular);
		//panelControl.add(result);
		//panelControl.add(bCalcular);
		//panelControl.add(error);
		this.panelUnidades.setBackground(Color.LIGHT_GRAY);
		this.panelA.setBackground(Color.LIGHT_GRAY);
		this.panelB.setBackground(Color.LIGHT_GRAY);
		this.panelTol.setBackground(Color.LIGHT_GRAY);
		this.panelBtCalcular.setBackground(Color.LIGHT_GRAY);
		this.panelX.setBackground(Color.WHITE);

		this.pd = pd2;
		this.add(pd,BorderLayout.CENTER);

		panelControl.setBackground(Color.LIGHT_GRAY);
		this.add(panelControl,BorderLayout.EAST);
		this.setVisible(true);
		//this.pack();
	}

	public void addCalcularListener(ActionListener actionListener) {
		this.bCalcular.addActionListener(actionListener);
	}

	public void inicarCombo() {
		this.unidadesMedicion.addItem("m");
		this.unidadesMedicion.addItem("cm");
		this.unidadesMedicion.addItem("mm");
		this.unidadesMedicion.addItem("ft");
		this.unidadesMedicion.addItem("in");
		this.unidadesMedicion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelMedidaA.setText(" " + unidadesMedicion.getSelectedItem().toString());
				panelMedidaB.setText(" " +unidadesMedicion.getSelectedItem().toString());
				pd.valorMedida = " " + unidadesMedicion.getSelectedItem().toString();
				pd.repaint();
			}
		});

	}
}
