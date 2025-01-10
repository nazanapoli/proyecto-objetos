package sistemaGaraje;

public class AppTest {
    GarajeTest gt = new GarajeTest();

    public boolean TestApp(){
        String resultado = gt.testRetirarCoche();
        boolean result = true;
        System.out.println(resultado);
        if (resultado.equals("OK")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
