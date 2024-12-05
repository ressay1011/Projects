public interface MetodoPago {

    void procesarPago(double monto);

    String obtenerDetalles();

    boolean validarMonto(double monto);

}
