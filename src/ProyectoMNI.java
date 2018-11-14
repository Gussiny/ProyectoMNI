import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class ProyectoMNI extends JFrame{
	private JTabbedPane tabs;

	public ProyectoMNI() {
		this.setTitle("Proyecto MN Final Final El Bueno 13 de Noviembre 2018 Full Crack Última Versión Español 100% Real No Fake");
		this.setSize(1080, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

	    //COMPONENTES ESCENARIO 1
	    ModeloEscenario1 modE1 = new ModeloEscenario1();
	    PanelDibujoEscenario1 pd1 = new PanelDibujoEscenario1(0.);
	    VistaEscenario1 visE1 = new VistaEscenario1(pd1);
	    new ControladorEscenario1(visE1,modE1,pd1);

	    //COMPONENTES ESCENARIO 2
	    Modelo modE2 = new Modelo();
		PanelDibujo pd2 = new PanelDibujo(0., 0.);
	    Vista visE2 = new Vista(pd2);
	    new Controlador(visE2, modE2, pd2);

	    //COMPONENTES ESCENARIO 3
	    ModeloEscenario3 modE3 = new ModeloEscenario3();
	    PanelDibujoEscenario3 pd3 = new PanelDibujoEscenario3(0.,0.);
	    VistaEscenario3 visE3 = new VistaEscenario3(pd3);
	    new ControladorEscenario3(visE3,modE3,pd3);

	    tabs = new JTabbedPane();
	    tabs.add("Escenario 1", visE1);
	    tabs.add("Escenario 2", visE2);
	    tabs.add("Escenario 3", visE3);
	    this.add(tabs);
	    this.pack();
	}

	public static void main(String[] args) {
		ProyectoMNI pm = new ProyectoMNI();
		pm.setVisible(true);
	}

}
