/**
 * Interface defining the base structure for all payment methods.
 * Provides a common contract for processing payments, retrieving details,
 * and validating transaction amounts.
 */
public interface MetodoPago {

    /**
     * Processes a payment for a specific amount.
     * 
     * @param monto The amount to be processed.
     */
    void procesarPago(double monto);

    /**
     * Retrieves a detailed text summary of the payment method configuration.
     * 
     * @return A formatted string with payment details.
     */
    String obtenerDetalles();

    /**
     * Validates if a specific amount is acceptable for this payment method.
     * 
     * @param monto The amount to validate.
     * @return true if the amount meets the method's specific criteria.
     */
    boolean validarMonto(double monto);
}
