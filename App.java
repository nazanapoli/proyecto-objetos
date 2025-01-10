import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sistemaGaraje.AppTest;
import sistemaGaraje.Garaje;

public class App {
    public static void main(String[] args) {
        AppTest at = new AppTest();
        if (at.TestApp()) {
            System.out.println("APP LISTA PARA USARSE");
        } else {
            System.exit(0);
        }

        Garaje garaje = null; // Lo inicializo en null para darle un valor después de crearlo
        boolean flagGaraje = true;
        while (flagGaraje) {
            try {
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del garaje:", "Creación de garaje",
                        JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/garaje.jpg"), null, "").toString();
                String direccion = JOptionPane
                        .showInputDialog(null, "Ingrese la dirección del garaje:", "Creación de garaje",
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/garaje.jpg"), null, "")
                        .toString();
                double precioCambioRuedas = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Ingrese el precio por el cambio de ruedas:", "Creación de garaje",
                        JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/garaje.jpg"), null, "").toString());
                int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la capacidad del garaje:",
                        "Creación de garaje", JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/garaje.jpg"), null, "").toString());
                garaje = new Garaje(nombre, direccion, precioCambioRuedas, capacidad, null, null);
                flagGaraje = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el garaje: " + e.getMessage());
            }
        }

        Menu menu = new Menu(garaje);
        menu.mostrarMenu();
    }
}
