
public class ProyectoMNI {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		PanelDibujo pd = new PanelDibujo(0., 0.);
	    Vista vista = new Vista(pd);
	    new Controlador(vista, modelo, pd);
	   
	}

}
