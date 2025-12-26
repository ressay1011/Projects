/**
 * Represents a bank transfer payment method.
 * Implements the MetodoPago interface.
 */
public class TransferenciaBancaria implements MetodoPago {

    private String banco; // Bank name
    private String nombre; // Account holder's name
    private String tipoIdentificacion; // Type of identification (e.g., C.C. - Cedula de Ciudadania)
    private long identificacion; // Identification number

    /**
     * Default constructor for TransferenciaBancaria.
     * Initializes with default bank, name, identification type, and identification
     * number.
     */
    public TransferenciaBancaria() {
        this.banco = "Bancolombia";
        this.nombre = "Darwin";
        this.tipoIdentificacion = "C.C.";
        this.identificacion = 1384286458;
    }

    /**
     * Retrieves the bank name.
     * 
     * @return The bank name.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Sets the bank name.
     * 
     * @param banco The bank name to set.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Retrieves the account holder's name.
     * 
     * @return The account holder's name.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the account holder's name.
     * 
     * @param nombre The account holder's name to set.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retrieves the type of identification.
     * 
     * @return The identification type.
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Sets the type of identification.
     * 
     * @param tipoIdentificacion The identification type to set.
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * Retrieves the identification number.
     * 
     * @return The identification number.
     */
    public long getIdentificacion() {
        return identificacion;
    }

    /**
     * Sets the identification number.
     * 
     * @param identificacion The identification number to set.
     */
    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Processes the payment via bank transfer.
     * 
     * @param monto The amount to be paid.
     */
    @Override
    public void procesarPago(double monto) {
        System.out.printf("Sera transferido a la pagina de : %1$s para continuar con su pago por valor de $%2$,.2f%n",
                banco, monto);
    }

    /**
     * Retrieves the details of the bank transfer.
     * 
     * @return A formatted string containing bank transfer details.
     */
    @Override
    public String obtenerDetalles() {
        return String.format("Banco: %1$s %nNombre: %2$s %nTipo de Identifiación: %3$s"
                + "%nNumero: %4$d",
                banco, nombre, tipoIdentificacion, identificacion);
    }

    /**
     * Validates if the payment amount is sufficient for a bank transfer.
     * 
     * @param monto The amount to validate.
     * @return true if the amount is greater than or equal to 10, false otherwise.
     */
    @Override
    public boolean validarMonto(double monto) {

        if (monto >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
