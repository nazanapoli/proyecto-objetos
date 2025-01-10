import sistemaGaraje.Garaje;
import vehiculos.Coche;
import vehiculos.Moto;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu {
    private Garaje garaje;

    public Menu(Garaje garaje) {
        this.garaje = garaje;
    }

    public void mostrarMenu() {
        boolean flagVehiculo = true;

        while (flagVehiculo) {
            String opcion = JOptionPane.showInputDialog(null, "¿Qué deseas hacer?\n" +
                    "1. Ingresar un coche\n" +
                    "2. Ingresar una moto\n" +
                    "3. Retirar coche\n" +
                    "4. Retirar moto\n" +
                    "5. Mostrar vehículos en el garaje\n" +
                    "6. Conocer el total de vehículos dentro del garaje actualmente\n" +
                    "7. Saber precio por el cambio de todos los neumáticos de los vehículos\n" +
                    "8. Promedio de kilometraje de todos los vehículos\n" +
                    "9. Información del garaje\n" +
                    "0. Salir", "Menú de opciones", JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/garaje.jpg"),
                    null,
                    "").toString();

            switch (opcion) {
                case "1":
                    ingresarCoche();
                    break;

                case "2":
                    ingresarMoto();
                    break;

                case "3":
                    String patenteCoche = JOptionPane
                            .showInputDialog(null, "Ingrese la patente del coche a retirar:", "Retirar coche",
                                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/patente.jpg"), null, "")
                            .toString();
                    if (garaje.retirarCoche(patenteCoche)) {
                        JOptionPane.showMessageDialog(null, "Coche retirado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un coche con esa patente.");
                    }
                    break;

                case "4":
                    String patenteMoto = JOptionPane
                            .showInputDialog(null, "Ingrese la patente de la moto a retirar:", "Retirar moto",
                                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/patente.jpg"), null, "")
                            .toString();
                    if (garaje.retirarMoto(patenteMoto)) {
                        JOptionPane.showMessageDialog(null, "Moto retirada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró una moto con esa patente.");
                    }
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null, garaje.mostrarVehiculos());
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, garaje.cantidadVehiculosActual());
                    System.out.println(garaje.cantidadVehiculosActual());
                    break;

                case "7":
                    JOptionPane.showMessageDialog(null, garaje.precioCambioRuedasTotal());
                    break;

                case "8":
                    JOptionPane.showMessageDialog(null, garaje.kilometrosPromedio());
                    break;

                case "9":
                    JOptionPane.showMessageDialog(null, garaje.toString(), "Información del garaje",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/garaje.jpg"));
                    break;

                case "0":
                    flagVehiculo = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opción que seleccionaste no es válida.");
            }
        }
    }

    private void ingresarCoche() {
        if (garaje.getCoches().size() + garaje.getMotos().size() == garaje.getCapacidadMaxima()) {
            JOptionPane.showMessageDialog(null, "El garaje está lleno, no se pueden ingresar más coches.");
            return;
        }

        try {
            String patente = solicitarInput("Ingrese la patente del coche:", "Ingreso de coche", "img/patente.jpg");
            String marca = solicitarInput("Ingrese la marca del coche:", "Ingreso de coche", "img/marca.jpg");
            int kilometraje = solicitarEntero("Ingrese el kilometraje del coche:", "Ingreso de coche",
                    "img/kilometraje.jpeg");
            int puertas = solicitarEntero("Ingrese el número de puertas del coche (2-5):", "Ingreso de coche",
                    "img/auto.jpg", 2, 5);
            int ruedas = solicitarEntero("Ingrese el número de ruedas del coche (normalmente 4):", "Ingreso de coche",
                    "img/rueda.png", 4, 4);

            Coche coche = new Coche(patente, marca, kilometraje, puertas, ruedas);
            garaje.ingresarCoche(coche);

            JOptionPane.showMessageDialog(null, "Coche ingresado:\n" + coche);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el coche: " + e.getMessage());
        }
    }

    private void ingresarMoto() {
        if (garaje.getCoches().size() + garaje.getMotos().size() == garaje.getCapacidadMaxima()) {
            JOptionPane.showMessageDialog(null, "El garaje está lleno, no se pueden ingresar más motos.");
            return;
        }

        try {
            String patente = solicitarInput("Ingrese la patente de la moto:", "Ingreso de moto", "img/patente.jpg");
            String marca = solicitarInput("Ingrese la marca de la moto:", "Ingreso de moto", "img/marca.jpg");
            int kilometraje = solicitarEntero("Ingrese el kilometraje de la moto:", "Ingreso de moto",
                    "img/kilometraje.jpeg");
            int cilindrada = solicitarEntero("Ingrese la cilindrada de la moto:", "Ingreso de moto",
                    "img/cilindrada.jpg", 50, 250);
            int ruedas = solicitarEntero("Ingrese el número de ruedas de la moto (normalmente 2):", "Ingreso de moto",
                    "img/rueda.png", 2, 3);

            Moto moto = new Moto(patente, marca, kilometraje, cilindrada, ruedas);
            garaje.ingresarMoto(moto);

            JOptionPane.showMessageDialog(null, "Moto ingresada:\n" + moto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la moto: " + e.getMessage());
        }
    }

    private String solicitarInput(String mensaje, String titulo, String imagen) {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(imagen), null, "").toString();
        } while (input == null || input.trim().isEmpty());
        return input;
    }

    private int solicitarEntero(String mensaje, String titulo, String imagen) {
        return solicitarEntero(mensaje, titulo, imagen, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int solicitarEntero(String mensaje, String titulo, String imagen, int min, int max) {
        int valor;
        do {
            try {
                valor = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, titulo,
                        JOptionPane.QUESTION_MESSAGE, new ImageIcon(imagen), null, "").toString());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        } while (true);
    }
}
