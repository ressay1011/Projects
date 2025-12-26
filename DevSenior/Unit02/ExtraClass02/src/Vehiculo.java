/**
 * Base class representing a general vehicle.
 * Contains common attributes such as brand, model, and maximum velocity.
 */
public class Vehiculo {
    /** The brand of the vehicle. */
    private String marca;
    /** The specific model name of the vehicle. */
    private String modelo;
    /** The maximum speed the vehicle can reach in KM/H. */
    private int velocidadMaxima;

    /**
     * Default constructor initializing basic vehicle attributes with placeholder
     * values.
     */
    public Vehiculo() {
        this.marca = "Sin marca";
        this.modelo = "Sin modelo";
        this.velocidadMaxima = 0;
    }

    /**
     * Parameterized constructor for custom vehicle initialization.
     * 
     * @param marca           The vehicle's brand.
     * @param modelo          The vehicle's model.
     * @param velocidadMaxima The vehicle's maximum speed.
     */
    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Prints a formatted summary of the vehicle's details to the console.
     */
    public void mostrarDetalles() {
        System.out.printf("Marca: %1$s. %nModelo: %2$s. %nVelocidad Max.: %3$s. %n", marca, modelo, velocidadMaxima);
    }

}
