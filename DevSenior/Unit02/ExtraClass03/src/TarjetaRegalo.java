public class TarjetaRegalo implements MetodoPago {

    private long codigoTarjeta;
    private double saldo;
    private double nuevoSaldo;

    public TarjetaRegalo() {
        this.codigoTarjeta = 1234567890123456l;
        this.saldo = 500;
        this.nuevoSaldo = 0;
    }

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
