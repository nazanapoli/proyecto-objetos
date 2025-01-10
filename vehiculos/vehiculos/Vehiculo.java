package vehiculos;

public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int kilometraje;

    public Vehiculo(String patente, String marca, int kilometraje) {
        this.patente = patente;
        this.marca = marca;
        this.kilometraje = kilometraje;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String matricula) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("La matrícula no puede ser nula o vacía");
        } else {
            this.patente = matricula;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía");
        } else {
            this.marca = marca;
        }
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        if (kilometraje < 0) {
            throw new IllegalArgumentException("El kilometraje no puede ser negativo");
        } else {
            this.kilometraje = kilometraje;
        }

    }

    // Metodo abstracto para desarrollar en clases hijas
    @Override
    public abstract String toString();
}
