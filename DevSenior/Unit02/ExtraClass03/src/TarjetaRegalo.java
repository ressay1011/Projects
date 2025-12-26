/**
 * Payment method implementation for Gift Cards.
 * Implements the {@link MetodoPago} interface for prepaid gift card
 * transactions.
 */
public class TarjetaRegalo implements MetodoPago {

    /** The unique gift card code. */
    private long codigoTarjeta;
    /** The original balance on the card. */
    private double saldo;
    /** The remaining balance after a transaction. */
    private double nuevoSaldo;

    /**
     * Default constructor for TarjetaRegalo with sample data.
     */
    public TarjetaRegalo() {
        this.codigoTarjeta = 1234567890123456l;
        this.saldo = 500;
        this.nuevoSaldo = 0;
    }

    /**
     * Gets the gift card code.
     * 
     * @return The card code.
     */
    public long getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(long codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getNuevoSaldo() {
        return nuevoSaldo;
    }

    public void setNuevoSaldo(double nuevoSaldo) {
        this.nuevoSaldo = nuevoSaldo;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.printf(
                "Se realizara un cargo a su tarjeta de regalo: %1$s por valor de $%2$,.2f %n",
                codigoTarjeta, monto);
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Tarjeta de Regalo: %1$s %nSaldo Anterior: $%2$,.2f %nNuevo Saldo: $%3$,.2f",
                codigoTarjeta, saldo, nuevoSaldo);
    }

    @Override
    public boolean validarMonto(double monto) {
        nuevoSaldo = saldo - monto;
        if (monto > 0 && monto <= 500) {
            return true;
        } else {
            return false;
        }
    }
}
