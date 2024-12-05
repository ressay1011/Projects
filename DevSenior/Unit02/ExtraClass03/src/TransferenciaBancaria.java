public class TransferenciaBancaria implements MetodoPago {

    private String banco;
    private String nombre;
    private String tipoIdentificacion;
    private long identificacion;

    public TransferenciaBancaria() {
        this.banco = "Bancolombia";
        this.nombre = "Darwin";
        this.tipoIdentificacion = "C.C.";
        this.identificacion = 1384286458;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.printf("Sera transferido a la pagina de : %1$s para continuar con su pago por valor de $%2$,.2f%n",
                banco, monto);
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Banco: %1$s %nNombre: %2$s %nTipo de Identifiación: %3$s"
                + "%nNumero: %4$d",
                banco, nombre, tipoIdentificacion, identificacion);
    }

    @Override
    public boolean validarMonto(double monto) {

        if (monto >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
