package sistemaGaraje;
import vehiculos.Coche;
import vehiculos.Moto;
import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String nombre;
    private String direccion;
    private double precioCambioRueda;
    private int capacidadMaxima;
    private List<Coche> coches;
    private List<Moto> motos;

    public Garaje(String nombre, String direccion, double precioCambioRueda, int capacidadMaxima, List<Coche> coches,
        List<Moto> motos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioCambioRueda = precioCambioRueda;
        this.capacidadMaxima = capacidadMaxima;
        this.coches = new ArrayList<>();
        this.motos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        } else {
            this.nombre = nombre;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o vacía");
        } else {
            this.direccion = direccion;
        }
    }

    public double getPrecioCambioRueda() {
        return precioCambioRueda;
    }

    public void setPrecioCambioRueda(double precioCambioRueda) {
        if (precioCambioRueda <= 0) {
            throw new IllegalArgumentException("El precio del cambio de rueda debe ser mayor que 0");
        } else {
            this.precioCambioRueda = precioCambioRueda;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0");
        } else {
            this.capacidadMaxima = capacidadMaxima;
        }
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void ingresarCoche(Coche coche) {
        if (coches.size() < capacidadMaxima) {
            coches.add(coche);
        } else if (coches.contains(coche)) {
            throw new IllegalArgumentException("El coche ya fue ingresado");
        } else {
            throw new IllegalArgumentException("En este momento no podemos ingresar el vehículo, el garaje está lleno");
        }
    }

    public void ingresarMoto(Moto moto) {
        if (motos.size() < capacidadMaxima) {
            motos.add(moto);
        } else if (motos.contains(moto)) {
            throw new IllegalArgumentException("La moto ya fue ingresada");
        } else {
            throw new IllegalArgumentException("En este momento no podemos ingresar el vehículo, el garaje está lleno");
        }
    }

    public boolean retirarCoche(String patente) {
        Coche cocheARetirar = null;
        for (Coche coche : coches) {
            if (coche.getPatente().equalsIgnoreCase(patente)) {
                cocheARetirar = coche;
                break;
            }
        }
        if (cocheARetirar != null) {
            coches.remove(cocheARetirar);
            return true;
        } else {
            return false;
        }
    }

    public boolean retirarMoto(String patente) {
        Moto motoARetirar = null;
        for (Moto moto : motos) {
            if (moto.getPatente().equalsIgnoreCase(patente)) {
                motoARetirar = moto;
                break;
            }
        }
        if (motoARetirar != null) {
            motos.remove(motoARetirar);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> mostrarCoches() {
        ArrayList<String> cochesString = new ArrayList<>();
        for (Coche coche : coches) {
            int numero = coches.indexOf(coche) + 1;
            cochesString.add("Coche " + numero + ": " + coche.toString() + "\n");
        }
        return cochesString;
    }

    public ArrayList<String> mostrarMotos() {
        ArrayList<String> motosString = new ArrayList<>();
        for (Moto moto : motos) {
            int numero = motos.indexOf(moto) + 1;
            motosString.add("Moto " + numero + ": " + moto.toString() + "\n");
        }
        return motosString;
    }

    public ArrayList<String> mostrarVehiculos() {
        //Creo una variable local para almacenar todo lo que tengo en motos y coches
        ArrayList<String> vehiculos = new ArrayList<>();
        vehiculos.addAll(mostrarCoches());
        vehiculos.addAll(mostrarMotos());
        return vehiculos; //retorno ese valor para que no genere conflictos con OptionPane
    }

    public String cantidadVehiculosActual() {
        if((coches.isEmpty() && motos.isEmpty()) || (coches == null && motos == null)){
            return "En este momento el garaje está vacío";
        }
        return "Actualmente hay " + (coches.size() + motos.size()) + " vehículos en el garaje";
    }

    public String kilometrosPromedio() {
        int kmTotal = 0;
        if(coches.isEmpty() && motos.isEmpty()){
            return "Para poder calcular el promedio de KM es necesario que ingreses vehículos al garaje";
        }
        for (Coche coche : coches) {
            kmTotal += coche.getKilometraje();
        }
        for (Moto moto : motos) {
            kmTotal += moto.getKilometraje();
        }
        return "El kilometraje promedio de los vehículos es de " + kmTotal / (coches.size() + motos.size()) + " km";
    }

    public String precioCambioRuedasTotal() {
        double precioTotal = 0;
        if(coches.isEmpty() && motos.isEmpty()){
            return "No hay vehículos en el garaje por lo que no hay ruedas para cambiar";
        }
        for (Coche coche : coches) {
            precioTotal += coche.getRuedas() * precioCambioRueda;
        }
        for (Moto moto : motos) {
            precioTotal += moto.getRuedas() * precioCambioRueda;
        }
        return "En caso de cambiar todas las ruedas de todos los vehículos, el valor es de: " + precioTotal + " pesos";
    }

    @Override
    public String toString() {
        return "El garaje " + getNombre() + " ubicado en " + getDireccion() + " tiene una capacidad máxima de "
                + getCapacidadMaxima() + " vehículos." + cantidadVehiculosActual()  + ". El precio actual por el cambio de rueda es de "
                + getPrecioCambioRueda() + " pesos";
    }
}