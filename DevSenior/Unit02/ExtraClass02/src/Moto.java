public class Moto extends Vehiculo {
    private boolean tieneSideCar;

    public Moto() {
        super();
        this.tieneSideCar = false;
    }

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
