public class Carro extends Vehiculo {
    private int numPuertas;

    public Carro() {
        super();
        this.numPuertas = 0;
    }

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
