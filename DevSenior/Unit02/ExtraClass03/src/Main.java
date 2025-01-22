import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        var monto = 0d;
        var metodoPagoSel = 0;
        var respuesta = "";
        var verificacion = false;
        MetodoPago metodoPago = new TarjetaCredito();
        String fix = "=";
        fix = fix.repeat(60);
        String[] opciones = { "" };

        do {
            opciones = new String[5];
            opciones[0] = "Tarjeta de Credito";
            opciones[1] = "Paypal";
            opciones[2] = "Transferencia Bancaria";
            opciones[3] = "Bitcoin";
            opciones[4] = "Tarjeta de Regalo";

            System.out.printf("%1$s %nSistema de gestión de pagos %n%1$s %n1. %2$s"
                    + "%n2. %3$s. %n3. %4$s. %n4. %5$s. %n5. %6$s. %n0. Salir"
                    + "%nSeleccione su metodo de pago: ", fix, opciones[0], opciones[1], opciones[2], opciones[3],
                    opciones[4]);

            respuesta = entrada.nextLine();

            if (respuesta.equals("0")) {
                entrada.close();
                System.out.println("Saliendo del programa...");
                System.exit(0);
            }

            if (verificarNum(respuesta, opciones)) {
                verificacion = true;
                metodoPagoSel = Integer.parseInt(respuesta);
            } else {
                verificacion = false;
                System.out.printf("Metodo de pago no valido %n", fix);
            }

        } while (!verificacion);

        do {

            do {
                System.out.printf("%1$s %nSistema de gestión de pagos %n%1$s %nDigite el monto a pagar: ", fix);

                respuesta = entrada.nextLine();

                if (verificarF(respuesta)) {
                    verificacion = true;
                    monto = Double.parseDouble(respuesta);
                } else {
                    verificacion = false;
                    System.out.printf("Monto no valido %n", fix);
                }

            } while (!verificacion);

            switch (metodoPagoSel) {
                case 1:
                    metodoPago = new TarjetaCredito();
                    break;
                case 2:
                    metodoPago = new Paypal();
                    break;
                case 3:
                    metodoPago = new TransferenciaBancaria();
                    break;
                case 4:
                    metodoPago = new Bitcoin();
                    break;
                case 5:
                    metodoPago = new TarjetaRegalo();
                    break;
                default:
                    break;
            }

            if (metodoPago.validarMonto(monto)) {
                metodoPago.procesarPago(monto);
                System.out.println("Pulse enter para continuar");
                entrada.nextLine();
                System.out.printf("Datos del pago: %n%1$s %nValor: $%2$,.2f%nPago completado.%n",
                        metodoPago.obtenerDetalles(), monto);
                System.out.println("Pulse enter para continuar");
                entrada.nextLine();
            } else {
                System.out.println("Error el monto ingresado no es valido.");
            }
        } while (!metodoPago.validarMonto(monto));
    }

    public static boolean verificarNum(String respuesta) {
        String[] opciones = { " " };
        return verificarNum(respuesta, opciones);
    }

    public static boolean verificarNum(String respuesta, String[] opciones) {
        var verificacion = true;

        if (respuesta.isBlank() || !respuesta.matches("[0-9]+")) {
            verificacion = false;
        } else if (!opciones[0].isBlank()) {

            for (int i = 0; i < opciones.length; i++) {

                if (i == Integer.parseInt(respuesta) - 1) {
                    return true;
                } else {
                    verificacion = false;
                }
            }
        } else {
            verificacion = true;
        }

        return verificacion;
    }

    public static boolean verificarF(String respuesta) {
        String[] opciones = { " " };
        return verificarF(respuesta, opciones);
    }

    public static boolean verificarF(String respuesta, String[] opciones) {
        var verificacion = true;

        if (respuesta.isBlank() || !respuesta.matches("[0-9]+[.]?[0-9]{0,2}")) {
            verificacion = false;
        } else if (!opciones[0].isBlank()) {
            for (String opcion : opciones) {
                if (respuesta.equalsIgnoreCase(opcion)) {
                    return true;
                } else {
                    verificacion = false;
                }
            }
        } else {
            verificacion = true;
        }

        return verificacion;
    }
}
