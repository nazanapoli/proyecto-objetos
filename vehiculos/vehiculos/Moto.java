package vehiculos;

public class Moto extends Vehiculo {
    private int cilindrada;
    private int ruedas;

    public Moto(String patente, String marca, int kilometraje, int cilindrada, int ruedas) {
        super(patente, marca, kilometraje);
        this.cilindrada = cilindrada;
        this.ruedas = ruedas;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        if (cilindrada < 0) {
            throw new IllegalArgumentException("La cilindrada no puede ser negativa");
        } else {
            this.cilindrada = cilindrada;
        }
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        if (ruedas < 2 && ruedas > 3) {
            throw new IllegalArgumentException("Las motos tienen 2 o 3 ruedas");
        } else {
            this.ruedas = ruedas;
        }
    }

    public String toString() {
        return "Moto " + getMarca() + " con patente " + getPatente() + " tiene una cilindrada de " + getCilindrada()
                + " cc y " + getRuedas() + " ruedas";
    }
}