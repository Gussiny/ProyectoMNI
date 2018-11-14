public class TestEscenario1 {
  public static void main(String[] args){
    ModeloEscenario1 modE1 = new ModeloEscenario1();
    PanelDibujoEscenario1 pd = new PanelDibujoEscenario1(0.);
    VistaEscenario1 visE1 = new VistaEscenario1(pd);
    new ControladorEscenario1(visE1,modE1,pd);
  }
}
