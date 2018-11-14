
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaEscenario1 extends JPanel{

	public JLabel titulo = new JLabel();
	public JLabel labelV = new JLabel(" Volumen:  ");
	public JLabel labelTol = new JLabel("Tolerancia: ");
	public JTextField textV = new JTextField();
	public JTextField textTol = new JTextField();

	public JPanel panelV = new JPanel();
	public JPanel panelTol = new JPanel();
	public JPanel panelX = new JPanel();
	public JPanel panelY = new JPanel();
	public JPanel panelZ = new JPanel();
	public JPanel panelBtCalcular = new JPanel();
	public JPanel panelUnidades = new JPanel();

	public JButton bCalcular = new JButton("Calcular");
	public JLabel resultX = new JLabel();
	public JLabel resultY = new JLabel();
	public JLabel resultZ = new JLabel();
	public JLabel error = new JLabel();
	public JLabel panelMedidaA = new JLabel(" m^3");
	public JComboBox<String> unidadesMedicion = new JComboBox<String>();

	private PanelDibujoEscenario1 pd;

	public VistaEscenario1(PanelDibujoEscenario1 pd2){
		//super("ESCENARIO 1");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1080,480);
		//this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(1,1));
		//this.setResizable(false);
		JPanel panelControl = new JPanel();

		panelControl.setLayout(new BoxLayout(panelControl,BoxLayout.Y_AXIS));
		panelControl.setPreferredSize(new Dimension(200, 120));
		this.inicarCombo();

		panelV.setLayout(new GridBagLayout());
		panelTol.setLayout(new GridBagLayout());
		panelX.setLayout(new GridBagLayout());
		panelY.setLayout(new GridBagLayout());
		panelZ.setLayout(new GridBagLayout());
		panelBtCalcular.setLayout(new GridBagLayout());
		panelUnidades.setLayout(new GridBagLayout());

		titulo.setText("PANEL DE CONTROL\n");
		textV.setPreferredSize(new Dimension(100,25));
		textTol.setPreferredSize(new Dimension(100,25));
		resultX.setFont(new Font("Arial",Font.BOLD, 26));
		resultY.setFont(new Font("Arial",Font.BOLD, 26));
		resultZ.setFont(new Font("Arial",Font.BOLD, 26));
		resultX.setText("X = ");
		resultY.setText("Y = ");
		resultZ.setText("Z = ");
		//error.setText("No hay error");

		panelUnidades.add(new JLabel("Unidad de medida: "));
		panelUnidades.add(unidadesMedicion);

		panelV.add(labelV);
		panelV.add(textV);
		panelV.add(panelMedidaA);

		panelTol.add(labelTol);
		panelTol.add(textTol);
		textTol.setText("0.0001");

		panelX.add(resultX);
		panelY.add(resultY);
		panelZ.add(resultZ);

		panelBtCalcular.add(bCalcular);


		//panelControl.add(titulo);
		panelControl.add(panelUnidades);
		panelControl.add(panelV);
		panelControl.add(panelTol);
		panelControl.add(panelX);
		panelControl.add(panelY);
		panelControl.add(panelZ);
		panelControl.add(panelBtCalcular);
		//panelControl.add(resultX);
		//panelControl.add(bCalcular);
		//panelControl.add(error);
		this.panelUnidades.setBackground(Color.LIGHT_GRAY);
		this.panelV.setBackground(Color.LIGHT_GRAY);
		this.panelTol.setBackground(Color.LIGHT_GRAY);
		this.panelBtCalcular.setBackground(Color.LIGHT_GRAY);
		this.panelX.setBackground(Color.WHITE);
		this.panelY.setBackground(Color.WHITE);
		this.panelZ.setBackground(Color.WHITE);

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
				panelMedidaA.setText(" " + unidadesMedicion.getSelectedItem().toString()+"^3");
				pd.valorMedida = " " + unidadesMedicion.getSelectedItem().toString();
				pd.repaint();
			}
		});

	}
}
