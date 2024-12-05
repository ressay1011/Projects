public class TarjetaCredito implements MetodoPago {

    private long numTarjeta;
    private String tipo;
    private int mesVencimiento;
    private int anioVencimiento;
    private int cvv;
    private String nombreTarjeta;

    public TarjetaCredito() {
        this.numTarjeta = 5348723492128476l;
        this.tipo = "MasterCard";
        this.mesVencimiento = 10;
        this.anioVencimiento = 29;
        this.cvv = 555;
        this.nombreTarjeta = "Darwin";
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getAnioVencimiento() {
        return anioVencimiento;
    }

    public void setAnioVencimiento(int anioVencimiento) {
        this.anioVencimiento = anioVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.printf("Se realizara un cargo a su tarjeta de credito: %1$s por valor de %2$,.2f%n",
                String.valueOf(numTarjeta).substring(12), monto);
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Num. Tarjeta: %1$d %nTipo: %2$s %nFecha de Vencimiento: %3$d/%4$d"
                + "%nCVV: %5$d %nNombre en la Tarjeta: %6$s",
                numTarjeta, tipo, mesVencimiento, anioVencimiento, cvv, nombreTarjeta);
    }

    @Override
    public boolean validarMonto(double monto) {

        if (monto > 0) {
            return true;
        } else {
            return false;
        }
    }

}
