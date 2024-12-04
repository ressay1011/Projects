import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Carro carro = new Carro();
        Moto moto = new Moto();
        Vehiculo[] vehiculos = new Vehiculo[1];
        Vehiculo[] temp;
        var tipo = "";
        var fixTipo = "";
        var respuesta = "";
        var continuar = false;
        var verificacion = false;
        var i = 0;
        String[] opciones = new String[2];
        String fix = "=".repeat(60);

        do {
            opciones[0] = "Carro";
            opciones[1] = "Moto";

            do {
                System.out.printf("%1$s %nDigite el tipo de vehiculo (Carro o Moto): ", fix);
                respuesta = entrada.nextLine();
                verificacion = verificar(respuesta, opciones);

                if (verificacion) {
                    tipo = respuesta;
                } else {
                    System.out.printf("Error: %1$s no es un tipo de vehiculo valido.%n", respuesta);
                }
            } while (verificacion == false);

            if (tipo.equalsIgnoreCase("Carro")) {
                vehiculos[i] = carro;
                fixTipo = "el " + tipo;
            } else {
                vehiculos[i] = moto;
                fixTipo = "la " + tipo;
            }

            do {
                System.out.printf("%1$s %nDigite la marca de %2$s: ", fix, fixTipo);
                respuesta = entrada.nextLine();
                verificacion = verificar(respuesta);

                if (verificacion) {
                    vehiculos[i].setMarca(respuesta);
                } else {
                    System.out.printf("Error: %1$s no es una marca de vehiculo valida.%n", respuesta);
                }
            } while (verificacion == false);

            do {
                System.out.printf("%1$s %nDigite el modelo de %2$s: ", fix, fixTipo);
                respuesta = entrada.nextLine();
                verificacion = verificar(respuesta);

                if (verificacion) {
                    vehiculos[i].setModelo(respuesta);
                } else {
                    System.out.printf("Error: %1$s no es un modelo de vehiculo valido.%n", respuesta);
                }
            } while (verificacion == false);

            do {
                System.out.printf("%1$s %nDigite la velocidad maxima de %2$s: ", fix, fixTipo);
                respuesta = entrada.nextLine();
                verificacion = verificarNum(respuesta);

                if (verificacion) {
                    vehiculos[i].setVelocidadMaxima(Integer.parseInt(respuesta));
                } else {
                    System.out.printf("Error: %1$s no es una velocidad maxima de vehiculo valida.%n", respuesta);
                }
            } while (verificacion == false);

            if (tipo.equalsIgnoreCase("Carro")) {
                do {
                    System.out.printf("%1$s %nDigite el numero de puertas de %2$s: ", fix, fixTipo);
                    respuesta = entrada.nextLine();
                    verificacion = verificarNum(respuesta);

                    if (verificacion) {
                        carro.setNumPuertas(Integer.parseInt(respuesta));
                    } else {
                        System.out.printf("Error: %1$s no es un numero de puertas de vehiculo valido.%n", respuesta);
                    }
                } while (verificacion == false);

                System.out.printf("%1$s %nInformación de %2$s: %n", fix, fixTipo);
                carro.mostrarDetalles();
                System.out.printf("Num.Puertas: %1$s. %n", carro.getNumPuertas());
            } else {
                opciones[0] = "Si";
                opciones[1] = "No";

                do {
                    System.out.printf("%1$s %n%2$s tiene sidecar?(Si, No): ", fix, fixTipo);
                    respuesta = entrada.nextLine();
                    verificacion = verificar(respuesta, opciones);

                    if (verificacion) {
                        if (respuesta.equalsIgnoreCase("Si")) {
                            moto.setTieneSideCar(true);
                        } else {
                            moto.setTieneSideCar(false);
                        }
                    } else {
                        System.out.printf("Error: %1$s no es una opcion valida.%n", respuesta);
                    }
                } while (verificacion == false);

                System.out.printf("%1$s %nInformación de %2$s: %n", fix, fixTipo);
                moto.mostrarDetalles();
                System.out.printf("Tiene sidecar?: %1$s. %n", moto.isTieneSideCar());
            }
            opciones[0] = "Si";
            opciones[1] = "No";

            do {
                System.out.printf("%1$s %nDesea agregar otro vehiculo?(Si, NO) ", fix);
                respuesta = entrada.nextLine();
                verificacion = verificar(respuesta, opciones);

                if (verificacion) {
                    if (respuesta.equalsIgnoreCase("Si")) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                } else {
                    System.out.printf("Error: %1$s no es una opcion valida.%n", respuesta);
                }
            } while (verificacion == false);

            if (continuar) {
                temp = vehiculos;
                vehiculos = new Vehiculo[temp.length + 1];

                for (int j = 0; j < temp.length; j++) {
                    vehiculos[j] = temp[j];
                }

                i = i + 1;
            } else {
                System.out.println("Saliendo del programa...");
                entrada.close();
                System.exit(0);
            }
        } while (i < vehiculos.length);
    }

    public static boolean verificar(String respuesta) {
        String[] opciones = { " " };
        return verificar(respuesta, opciones);
    }

    public static boolean verificar(String respuesta, String[] opciones) {
        var verificacion = true;

        if (respuesta.isBlank() || !respuesta.matches("[A-Za-zÑñ]+")) {
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

    public static boolean verificarNum(String respuesta) {
        String[] opciones = { " " };
        return verificarNum(respuesta, opciones);
    }

    public static boolean verificarNum(String respuesta, String[] opciones) {
        var verificacion = true;

        if (respuesta.isBlank() || !respuesta.matches("[0-9]+")) {
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
