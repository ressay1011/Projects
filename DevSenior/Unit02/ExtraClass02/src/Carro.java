/**
 * Represents a car, which is a specific type of vehicle.
 * Inherits from {@link Vehiculo} and adds specific attributes like the number
 * of doors.
 */
public class Carro extends Vehiculo {
    /** The number of doors the car possesses. */
    private int numPuertas;

    /**
     * Default constructor for Carro.
     */
    public Carro() {
        super();
        this.numPuertas = 0;
    }

    /**
     * Parameterized constructor for Carro.
     * 
     * @param numPuertas The number of doors.
     */
    public Carro(int numPuertas) {
        super();
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

}
