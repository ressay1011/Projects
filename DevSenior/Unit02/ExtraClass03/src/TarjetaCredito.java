/**
 * Payment method implementation for Credit Cards.
 * Implements the {@link MetodoPago} interface for credit/debit card
 * transactions.
 */
public class TarjetaCredito implements MetodoPago {

    /** The full credit card number. */
    private long numTarjeta;
    /** The type of card (e.g., Visa, MasterCard). */
    private String tipo;
    /** The expiration month. */
    private int mesVencimiento;
    /** The expiration year. */
    private int anioVencimiento;
    /** The Card Verification Value (security code). */
    private int cvv;
    /** The name of the cardholder. */
    private String nombreTarjeta;

    /**
     * Default constructor for TarjetaCredito with sample data.
     */
    public TarjetaCredito() {
        this.numTarjeta = 5348723492128476l;
        this.tipo = "MasterCard";
        this.mesVencimiento = 10;
        this.anioVencimiento = 29;
        this.cvv = 555;
        this.nombreTarjeta = "Darwin";
    }

    /**
     * Gets the credit card number.
     * 
     * @return The card number.
     */
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
