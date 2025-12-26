/**
 * Payment method implementation for Bitcoin.
 * Implements the {@link MetodoPago} interface for cryptocurrency transactions.
 */
public class Bitcoin implements MetodoPago {

    /** The public wallet address. */
    private String billetera;
    /** The current BTC price in USD. */
    private double btc;
    /** The calculated value of the transaction in BTC. */
    private double valor;

    /**
     * Default constructor initializing Bitcoin with a sample wallet and base price.
     */
    public Bitcoin() {
        this.billetera = "0x345632D3S43f5CVVD5Nv3XC3asda21sfdasdv";
        this.btc = 100000;
        this.valor = 0;
    }

    /**
     * Gets the wallet address.
     * 
     * @return The wallet string.
     */
    public String getBilletera() {
        return billetera;
    }

    public void setBilletera(String billetera) {
        this.billetera = billetera;
    }

    public double getBtc() {
        return btc;
    }

    public void setBtc(double btc) {
        this.btc = btc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Executes the Bitcoin payment processing log.
     * 
     * @param monto The USD amount to process.
     */
    @Override
    public void procesarPago(double monto) {
        System.out.printf(
                "Se realizara un cargo a su billetera: (%1$s...%2$s) por valor de $%3$,.2f(%4$,.3f BTC)%n",
                billetera.substring(0, 6), billetera.substring(billetera.length() - 6), monto, monto / btc);
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Billetera: %1$s %nPrecio BTC: $%2$,.0f %nValor BTC: %3$,.3f BTC", billetera, btc, valor);
    }

    @Override
    public boolean validarMonto(double monto) {
        valor = monto / btc;
        if (monto / btc >= 0.001) {
            return true;
        } else {
            return false;
        }
    }
}
