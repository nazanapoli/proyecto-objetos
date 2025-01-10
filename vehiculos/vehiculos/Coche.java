package vehiculos;

public class Coche extends Vehiculo {
    private int puertas;
    private int ruedas;

    public Coche(String patente, String marca, int kilometraje, int puertas, int ruedas) {
        super(patente, marca, kilometraje);
        this.puertas = puertas;
        this.ruedas = ruedas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        if (puertas < 2 || puertas > 5) {
            throw new IllegalArgumentException("Los coches tienen entre 2 y 5 puertas");
        } else {
            this.puertas = puertas;
        }
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        if (ruedas != 4) {
            throw new IllegalArgumentException("Los coches tienen 4 ruedas");
        } else {
            this.ruedas = ruedas;
        }
    }

    public String toString() {
        return "Coche " + getMarca() + " con patente " + getPatente() + ". Tiene " + getPuertas() + " puertas y "
                + getRuedas() + " ruedas";
    }
}