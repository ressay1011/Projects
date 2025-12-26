/**
 * Represents a motorcycle, which is a specific type of vehicle.
 * Inherits from {@link Vehiculo} and adds specific attributes like sidecar
 * availability.
 */
public class Moto extends Vehiculo {
    /** Indicates whether the motorcycle comes with a sidecar. */
    private boolean tieneSideCar;

    /**
     * Default constructor for Moto.
     */
    public Moto() {
        super();
        this.tieneSideCar = false;
    }

    /**
     * Parameterized constructor for Moto.
     * 
     * @param tieneSideCar True if the motorcycle has a sidecar.
     */
    public Moto(boolean tieneSideCar) {
        super();
        this.tieneSideCar = tieneSideCar;
    }

    public boolean isTieneSideCar() {
        return tieneSideCar;
    }

    public void setTieneSideCar(boolean tieneSideCar) {
        this.tieneSideCar = tieneSideCar;
    }

}
