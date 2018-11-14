
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaEscenario3 extends JPanel{

	public JLabel titulo = new JLabel();
	public JLabel labelR = new JLabel(" Radio:  ");
	public JLabel labelL = new JLabel(" Lado:  ");
	public JLabel labelTol = new JLabel("Tolerancia: ");
	public JTextField textR = new JTextField();
	public JTextField textL = new JTextField();
	public JTextField textTol = new JTextField();

	public JPanel panelR = new JPanel();
	public JPanel panelL = new JPanel();
	public JPanel panelTol = new JPanel();
	public JPanel panelX = new JPanel();
	public JPanel panelBtCalcular = new JPanel();
	public JPanel panelUnidades = new JPanel();

	public JButton bCalcular = new JButton("Calcular");
	public JLabel resultX = new JLabel();
	public JLabel error = new JLabel();
	public JLabel panelMedidaR = new JLabel(" m");
	public JLabel panelMedidaL = new JLabel(" m");
	public JComboBox<String> unidadesMedicion = new JComboBox<String>();

	private PanelDibujoEscenario3 pd;

	public VistaEscenario3(PanelDibujoEscenario3 pd2){
		//super("ESCENARIO 3");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1080,480);
		//this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(1,1));
		//this.setResizable(false);
		JPanel panelControl = new JPanel();

		panelControl.setLayout(new BoxLayout(panelControl,BoxLayout.Y_AXIS));
		panelControl.setPreferredSize(new Dimension(200, 120));
		this.inicarCombo();

		panelR.setLayout(new GridBagLayout());
		panelL.setLayout(new GridBagLayout());
		panelTol.setLayout(new GridBagLayout());
		panelX.setLayout(new GridBagLayout());
		panelBtCalcular.setLayout(new GridBagLayout());
		panelUnidades.setLayout(new GridBagLayout());

		titulo.setText("PANEL DE CONTROL\n");
		textR.setPreferredSize(new Dimension(100,25));
		textL.setPreferredSize(new Dimension(100,25));
		textTol.setPreferredSize(new Dimension(100,25));
		resultX.setFont(new Font("Arial",Font.BOLD, 26));
		resultX.setText("X = ");

		panelUnidades.add(new JLabel("Unidad de medición: "));
		panelUnidades.add(unidadesMedicion);

		panelR.add(labelR);
		panelR.add(textR);
		panelR.add(panelMedidaR);

		panelL.add(labelL);
		panelL.add(textL);
		panelL.add(panelMedidaL);

		panelTol.add(labelTol);
		panelTol.add(textTol);
		textTol.setText("0.001");

		panelX.add(resultX);

		panelBtCalcular.add(bCalcular);


		//panelControl.add(titulo);
		panelControl.add(panelUnidades);
		panelControl.add(panelR);
		panelControl.add(panelL);
		panelControl.add(panelTol);
		panelControl.add(panelX);
		panelControl.add(panelBtCalcular);
		//panelControl.add(resultX);
		//panelControl.add(bCalcular);
		//panelControl.add(error);
		this.panelUnidades.setBackground(Color.LIGHT_GRAY);
		this.panelR.setBackground(Color.LIGHT_GRAY);
		this.panelL.setBackground(Color.LIGHT_GRAY);
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
				panelMedidaR.setText(" " + unidadesMedicion.getSelectedItem().toString());
				panelMedidaL.setText(" " + unidadesMedicion.getSelectedItem().toString());
				pd.valorMedida = " " + unidadesMedicion.getSelectedItem().toString();
				pd.repaint();
			}
		});

	}
}
