public class Paypal implements MetodoPago {

    private String email;

    public Paypal() {
        this.email = "Darwin@gmail.com";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.printf("Se realizara un cargo a su cuenta de Paypal: %1$s por valor de %2$,.2f%n",
                email, monto);
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Email: %1$s", email);
    }

    @Override
    public boolean validarMonto(double monto) {

        if (monto > 0 && monto <= 10000) {
            return true;
        } else {
            return false;
        }
    }

}
