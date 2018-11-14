public class TestEscenario3 {
  public static void main(String[] args){
    ModeloEscenario3 modelo = new ModeloEscenario3();
    PanelDibujoEscenario3 pd = new PanelDibujoEscenario3(0.,0.);
    VistaEscenario3 vista = new VistaEscenario3(pd);
    new ControladorEscenario3(vista,modelo,pd);
  }
}
