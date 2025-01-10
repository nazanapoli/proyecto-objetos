package sistemaGaraje;
import vehiculos.Coche;

public class GarajeTest {
    public String testRetirarCoche() {
        Garaje garaje = new Garaje("Prueba", "Dirección de prueba", 100, 10, null, null);
        Coche coche = new Coche("ABC123", "Hyundai", 10000, 4, 4);

        garaje.ingresarCoche(coche);
        garaje.retirarCoche("ABC123"); //Comentar esta línea para probar comportamiento incorrecto

        // Comprobación ¿Se quitó el coche?
        String result = "";
        if (!garaje.getCoches().contains(coche)) {
            result = "OK";
        } else {
            result = "NOOK - Error al retirar el coche (En la clase Garaje, método retirarCoche), se esperaba que el coche no estuviera en la lista.";
        }
        return result;
    }
}