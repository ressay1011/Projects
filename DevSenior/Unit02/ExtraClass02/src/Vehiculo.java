public class Vehiculo {
    private String marca;
    private String modelo;
    private int velocidadMaxima;

    public Vehiculo() {
        this.marca = "Sin marca";
        this.modelo = "Sin modelo";
        this.velocidadMaxima = 0;
    }

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

    public void mostrarDetalles() {
        System.out.printf("Marca: %1$s. %nModelo: %2$s. %nVelocidad Max.: %3$s. %n", marca, modelo, velocidadMaxima);
    }

}
