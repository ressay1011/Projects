public class Bitcoin implements MetodoPago {

    private String billetera;
    private double btc;
    private double valor;

    public Bitcoin() {
        this.billetera = "0x345632D3S43f5CVVD5Nv3XC3asda21sfdasdv";
        this.btc = 100000;
        this.valor = 0;
    }

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
