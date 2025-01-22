package com.devSenior.challengue01;

import java.util.Random;
import java.util.Scanner;

/// Integrantes Pedro Daniel Ospina Arias y Yasser Daniel Ariza Barrios

public class Challengue01 {

    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String RESET = "\u001B[0m";

    // Static variables used throughout the project
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Selected planet information
        String[] destinationPlanet = { "" };

        // Selected spaceship information
        String[] selectedSpaceShip = { "" };

        // Travel duration calculated based on the selected spaceship's speed and the
        // distance to the selected planet
        var travelDuration = 0d;

        // Error menssage to display in the menu
        var errorMsg = "";

        var fix = "=";
        fix = fix.repeat(60);

        while (true) {
            int option;

            // Validación de si hay una nave seleccionada y un planeta seleccionado para
            // calcular la duración del viaje
            if (!destinationPlanet[0].isBlank() && !selectedSpaceShip[0].isBlank()) {
                travelDuration = calTravelDuration(destinationPlanet[1], selectedSpaceShip[1]);
            }

            option = mainMenu(destinationPlanet[0], selectedSpaceShip, travelDuration, errorMsg);

            switch (option) {

                // Opcion 0 - Salir del programa
                case 0:
                    System.out.printf("%2$s%4$s%3$s%n%1$sExiting the program...%3$s", BLUE, GREEN, RESET, fix);
                    System.exit(0);
                    break;

                // Opcion 1 - Seleccionar planeta de destino
                case 1:
                    destinationPlanet = menuDestinationPlanet(destinationPlanet);
                    errorMsg = "";
                    break;

                // Opcion 2 - Seleccionar nave
                case 2:
                    selectedSpaceShip = menuSpaceShip(selectedSpaceShip);
                    errorMsg = "";
                    break;

                // Opcion 3 - Iniciar viaje
                case 3:

                    // Validación de si hay una nave seleccionada y un planeta seleccionado para
                    // poder iniciar el viaje
                    if (!destinationPlanet[0].isBlank() && !selectedSpaceShip[0].isBlank()) {
                        calTravelProgress(destinationPlanet, selectedSpaceShip, travelDuration);
                        errorMsg = "";
                    } else if (!destinationPlanet[0].isBlank()) {
                        errorMsg = "Error: Please select a spaceship before starting the simulation.%n";
                    } else if (!selectedSpaceShip[0].isBlank()) {
                        errorMsg = "Error: Please select a destination planet before starting the simulation.%n";
                    } else {
                        errorMsg = "Error: Please select a destination planet and a spaceship before starting the simulation.%n";
                    }
                    break;

                // El programa en su curso normal nunca deberia llegar aca
                default:
                    System.out.println("Como rayos llegaste aqui?");
                    // Con fé XD
                    break;
            }
        }
    }

    // Metodo que crea el menu al pasarle un array de opciones y devuelve el valor
    // seleccionado una vez verificado
    private static int showMenu(String[] options) {
        return showMenu(options, "");
    }

    private static int showMenu(String[] options, String errorMsg) {
        var optionsTemp = "";
        var nOptions = options.length;
        var i = 0;
        var selectionTemp = 0;
        var selection = 0;
        var error = true;
        var fix = "=";
        fix = fix.repeat(60);

        while (error == true) {
            optionsTemp = "";
            i = 0;
            selectionTemp = 0;

            // Crea el logo
            System.out.printf("%1$s               _____ ____  ___   ____________%n"
                    + "              / ___// __ \\/   | / ____/ ____/%n"
                    + "              \\__ \\/ /_/ / /| |/ /   / __/%n"
                    + "             ___/ / ____/ ___ / /___/ /___%n"
                    + "%2$s   _____ ___%1$s/____/_/%2$s__ %1$s/_/%2$s__%1$s|_\\____/_____/%2$s_____  ____%n"
                    + "  / ___//  _/  |/  / / / / /   /   |/_  __/ __ \\/ __ \\%n"
                    + "  \\__ \\ / // /|_/ / / / / /   / /| | / / / / / / /_/ /%n"
                    + " ___/ // // /  / / /_/ / /___/ ___ |/ / / /_/ / _, _/%n"
                    + "/____/___/_/  /_/\\____/_____/_/  |_/_/  \\____/_/ |_|%n%4$s%3$s%n", RED, GREEN, RESET,
                    fix);

            // Crea las opciones asignandole a la ultima el numero 0.
            for (String option : options) {
                if (i != (nOptions - 1)) {
                    optionsTemp = optionsTemp
                            .concat(String.format("%1$s%3$s. %2$s%4$s.%n", GREEN, RESET, (i + 1), option));
                } else {
                    optionsTemp = optionsTemp
                            .concat(String.format("%1$s%3$s. %2$s%4$s.%n", GREEN, RESET, 0, option));
                }
                i = i + 1;
            }

            // Agrega el mensaje de error al menu en caso de haberlo.
            if (error = true) {
                optionsTemp = optionsTemp.concat("%3$s" + errorMsg + "%2$s");
                error = false;
            }

            optionsTemp = optionsTemp
                    .concat("%1$s%5$s%4$s%2$s%nPlease select an option (0 - " + (nOptions - 1) + "):%4$s ");

            System.out.printf(optionsTemp, GREEN, BLUE, RED, RESET, fix);

            // Valida si la opcion seleccionada es valida, si es un numero y si esta en el
            // rango permitido.
            if (input.hasNextInt()) {
                selectionTemp = input.nextInt();
                if (selectionTemp >= 0 & selectionTemp <= (nOptions - 1)) {
                    selection = selectionTemp;
                } else {
                    error = true;
                    errorMsg = "%3$sError: The option " + selectionTemp + " is not valid.%4$s%n";
                }
            } else {
                error = true;
                errorMsg = "%3$s%5$s%nError: Please enter a number from 0 to " + (nOptions - 1) + ".%4$s%n";
            }
            input.nextLine(); // Limpiar buffer
        }
        return selection;
    }

    // Metodo que crea el menu principal y retorna la opcion seleccionada
    private static int mainMenu(String destinationPlanet, String[] selectedSpaceShip, double travelDuration,
            String errorMsg) {

        // Guarda la selección del usuario para posteriormente retornarla.
        int selection;

        // Define las opciones que se muestran en el menu principal.
        String[] options = {
                "Select destination planet",
                "Select spaceship",
                "Start the travel simulation",
                "Exit the program" };

        // Valida si hay un planeta seleccionado para mostrar el nombre del planeta.
        if (!destinationPlanet.isBlank()) {
            options[0] = options[0].concat(String.format("%1$s (%2$s)%3$s", BLUE, destinationPlanet, RESET));
        }

        // Valida si hay una nave seleccionada para mostrar el nombre de la nave y el
        // numero de pasajeros.
        if (!selectedSpaceShip[0].isBlank()) {
            options[1] = options[1]
                    .concat(String.format("%1$s (%2$s: %3$,d Passengers)%4$s", BLUE, selectedSpaceShip[0],
                            Integer.parseInt(selectedSpaceShip[3]), RESET));
        }

        // Valida si hay un planeta y una nave seleccionados para mostrar la duracion
        // del viaje en dias.
        if (!selectedSpaceShip[0].isBlank() && !destinationPlanet.isBlank()) {
            options[2] = options[2].concat(String.format("%1$s (%2$,.0f Dias)%3$s", BLUE, travelDuration, RESET));
        }

        // Se crea y imprime el menu
        selection = showMenu(options, errorMsg);

        return selection;
    }

    // Metodo que crea el menu de seleccion de planeta destino y retorna la
    // información del planeta seleccionado
    private static String[] menuDestinationPlanet(String[] destinationPlanet) {

        // Define los planetas que se muestran en el menu de seleccion de planetas.
        String[] planets = { "Mercury", "Venus", "Mars", "Jupiter", "Saturn",
                "Uranus", "Neptune" };
        int selection;

        // Se agrega a las opciones del menu la opcion de volver al menu anterior.
        String[] options = new String[(planets.length + 1)];

        for (var i = 0; i < planets.length; i++) {
            options[i] = planets[i];
        }

        options[planets.length] = "Back";

        // Se crea y imprime el menu de seleccion de planetas
        selection = showMenu(options);

        // Valida si la opcion seleccionada es diferente de 0
        if (selection != 0) {

            // Guarda la información del planeta seleccionado para su posterior retorno
            destinationPlanet = destinationPlanet(selection, planets);
        }

        return destinationPlanet;
    }

    // Metodo que recibe el planeta seleccionado y la lista de planetas disponibles,
    // muestra por consola la informacion del planeta y la retorna
    private static String[] destinationPlanet(int option, String[] planets) {

        // Guarda la distancia de la tierra a los planetas en millones de kilometros.
        String[] planetDistance = { "91", "41", "225", "778", "1429", "2900", "4300" };

        // Guarda la descripción de los planetas.
        String[] planetDescription = {
                "is the smallest and closest planet to the Sun.%nIt has a rocky surface with extreme temperature changes, ranging from -180°C at night to 430°C during the day.%nIt orbits the Sun in just 88 days.",
                "is the second planet from the Sun and similar in size to Earth.%nIt has a thick, toxic atmosphere primarily made of carbon dioxide, which creates a runaway greenhouse effect, making it the hottest planet in the solar system.%nSurface temperatures can reach up to 470°C.%nVenus has no moons and rotates in the opposite direction to most planets, with a day longer than its year.",
                "is the fourth planet from the Sun, known as the \"Red Planet\" due to its reddish appearance caused by iron oxide on its surface.",
                "is the largest planet in the solar system, known for its massive size, strong magnetic field, and distinctive Great Red Spot, a giant storm.%nIt is a gas giant with no solid surface.",
                "is the second-largest planet in the solar system, famous for its stunning ring system made of ice and rock.%nIt is a gas giant with a predominantly hydrogen and helium atmosphere.",
                "is the seventh planet from the Sun and is known for its distinctive blue-green color, caused by methane in its atmosphere.%nIt is an ice giant with a mostly hydrogen and helium atmosphere, but it also contains water, ammonia, and methane.%nUranus has a unique rotation, spinning on its side with an axial tilt of 98 degrees.%nThis results in extreme seasonal variations.%nIt has 13 rings and 27 known moons.",
                "is the eighth and farthest planet from the Sun.%nIt is an ice giant with a deep blue color due to methane in its atmosphere.%nNeptune has strong winds, the fastest in the solar system, and large storm systems, including the Great Dark Spot.%nIt has 14 known moons, with Triton being the largest, and five rings.%nIts atmosphere is mostly hydrogen, helium, and methane."
        };

        // Se crea un nuevo String con la información a retornar. (Nombre del planeta y
        // distancia desde la tierra)
        String[] destinationPlanetInfo = new String[2];
        destinationPlanetInfo[0] = planets[option - 1];
        destinationPlanetInfo[1] = planetDistance[option - 1];

        // Imprime la información del planeta seleccionado
        System.out.printf(
                "%4$sThe selected planet is:%6$s %1$s located approximately %2$,d million kilometers from Earth %3$s%n%5$sPress enter to continue.%6$s",
                destinationPlanetInfo[0], Integer.parseInt(destinationPlanetInfo[1]),
                planetDescription[option - 1], GREEN, BLUE, RESET);
        input.nextLine(); // Gasta el enter

        return destinationPlanetInfo;
    }

    // Metodo que crea el menu de seleccion de naves y retorna información de la
    // nave seleccionada
    private static String[] menuSpaceShip(String[] selectedSpaceShip) {

        // Define las naves que se muestran en el menu de seleccion de naves.
        String[] spaceShips = { "Red dwarf", "Discovery", "Millennium falcon" };
        int selection = -1;

        // Se agrega a las opciones del menu la opcion de volver al menu anterior.
        String[] options = new String[(spaceShips.length + 1)];

        for (var i = 0; i < spaceShips.length; i++) {
            options[i] = spaceShips[i];
        }

        options[spaceShips.length] = "Back";

        do {

            // imprime el menu de selección de la nave.
            selection = showMenu(options);

            // Valida si la opcion seleccionada es diferente de 0.
            if (selection != 0) {

                // Guarda la información de la nave seleccionada para posteriormente retornarla.
                selectedSpaceShip = selectedSpaceShip(selection, spaceShips, selectedSpaceShip);
            }
        } while (selection != 0 && selectedSpaceShip[0].isBlank());

        return selectedSpaceShip;
    }

    /*
     * Metodo que recibe la nave seleccionada y la lista de naves disponible,
     * imprime la informacion de la nave para posteriormente retornarla y le pide al
     * usuario la cantidad de pasajeros a viajar.
     */
    private static String[] selectedSpaceShip(int option, String[] spaceShips, String[] selectedSpaceShip) {

        // Variable temporal para confirmar la seleccion de la nave
        var confirmation = "";

        // Datos de la nave
        // Velocidad maxima de cada una de las 3 naves en Km/h
        String[] spaceShipsMaxVel = { "36400", "28000", "42000" };

        // Capacidad maxima de cada una de las 3 naves (numero recomendado de pasajeros)
        String[] spaceShipsMaxCapacity = { "10", "25", "5" };

        // Guarda el numero de pasajeros que viajan como un String para su posterior
        // procesamiento
        var spaceShipsCapacity = "";

        // Variable que guarda temporalmente el numero de pasajeros para realizar las
        // validaciones
        var passengersTemp = 0;

        // Se guarda toda la información de la nave seleccionada en el array a retornar
        String[] tempSelectedSpaceShip = new String[4];
        tempSelectedSpaceShip[0] = spaceShips[option - 1];
        tempSelectedSpaceShip[1] = spaceShipsMaxVel[option - 1];
        tempSelectedSpaceShip[2] = spaceShipsMaxCapacity[option - 1];

        do {

            // Imprime por consola la información de la nave seleccionada
            System.out.printf(
                    "%4$sThe selected spaceship is:%6$s %1$s %n- Velocity: %2$,d KM/H%n- Max.Capacity: %3$s Passengers"
                            + "%n%5$sDo you want to select this spaceship(Y/n): %6$s",
                    tempSelectedSpaceShip[0], Integer.parseInt(tempSelectedSpaceShip[1]), tempSelectedSpaceShip[2],
                    GREEN, BLUE, RESET);

            // Se confirma la seleccion de la nave si es n (no) se devuelve a la seleccion
            // de nave
            confirmation = input.nextLine();

            if (confirmation.matches("[Nn]")) {
                return selectedSpaceShip;
            } else if (confirmation.matches("[^Yy%s]")) {
                System.out.printf("%1$sError: Invalid character %2$s%n", RED, RESET);
            }
        } while (confirmation.matches("[^Yy%s]"));

        System.out.printf(
                "%2$sSpaceship %1$s successfully selected.%3$s %n",
                tempSelectedSpaceShip[0], GREEN, RESET);

        // Se pregunta por el numero de pasajeros a viajar, se valida que sea un numero
        // positivo y en caso de que el numero ingresado supere el maximo permitido por
        // la nave seleccionada se muestra una advertencia.
        while (spaceShipsCapacity.isBlank()) {
            System.out.printf("%1$sPlease enter the number of passengers traveling: %2$s", BLUE, RESET);

            if (input.hasNextInt()) {
                passengersTemp = input.nextInt();

                if (passengersTemp >= 0) {
                    if (passengersTemp > Integer.parseInt(tempSelectedSpaceShip[2])) {
                        System.out.printf(
                                "%1$sWarning: Spaceship capacity exceeded."
                                        + "The number of passengers is higher that the recommended limit."
                                        + "%nPlease proceed with caution.%2$s%n%3$sPress enter to continue.%2$s",
                                YELLOW, RESET, BLUE);
                        input.nextLine();
                    }
                    spaceShipsCapacity = String.valueOf(passengersTemp);
                } else {
                    System.out.printf("%1$sError: Please enter a positive number.%2$s%n", RED, RESET);
                }
            } else {
                System.out.printf("%1$sError: Please enter a positive number.%2$s%n", RED, RESET);
            }
            input.nextLine();
        }

        // Se guarda el numero de pasajeros en el array a retornar
        tempSelectedSpaceShip[3] = spaceShipsCapacity;

        selectedSpaceShip = tempSelectedSpaceShip;

        return selectedSpaceShip;

    }

    // Calcula la duracion del viaje en dias al recibir la distancia del planeta
    // destino seleccionado y la velocidad de la nave seleccionada y retorna el
    // resultado.
    private static double calTravelDuration(String planetDistance, String spaceShipMaxVel) {

        var tempPlanetDistance = Double.parseDouble(planetDistance);
        var tempSpaceShipMaxVel = Double.parseDouble(spaceShipMaxVel);
        var travelDuration = 0d;

        tempPlanetDistance = tempPlanetDistance * 1000000;
        tempSpaceShipMaxVel = tempSpaceShipMaxVel * 24;

        travelDuration = tempPlanetDistance / tempSpaceShipMaxVel;

        return travelDuration;
    }

    private static void calTravelProgress(String[] destinationPlanet, String[] selectedSpaceShip,
            double travelDuration) {

        var spaceShipVel = Double.parseDouble(selectedSpaceShip[1]);
        var destinationPlanetDistance = Double.parseDouble(destinationPlanet[1]) * 1000000;
        var currentDistance = spaceShipVel * 24;

        var percentage = (currentDistance / destinationPlanetDistance) * 100;
        var temp = 0d;
        var days = 0;
        var fix = "=";
        fix = fix.repeat(60);

        System.out.printf(
                "%1$s%4$s%n"
                        + "Starting the travel from Earth to %2$s.%3$s%n",
                GREEN, destinationPlanet[0], RESET, fix);

        while (days <= travelDuration) {
            System.out.printf("%1$sEstimated travel duration: %2$,.0f Dias.%5$s(%3$.2f%%)%4$s\r",
                    BLUE, travelDuration - days, temp, generateEvent(), RESET);

            if (days == (int) (travelDuration / 2)) {
                System.out.printf("Halfway through the route: %2$,.0f Dias.%4$s(%3$d%%)       %n",
                        BLUE, travelDuration - travelDuration / 2, 50, RESET);
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            temp = temp + percentage;
            days = days + 1;

            System.out.printf("                                                            \r");
        }
        System.out.printf("%1$sEstimated travel duration: %2$.0f Dias.%4$s(%3$d%%): Travel Completed.%n",
                BLUE, travelDuration - travelDuration, 100, RESET);
        System.out.printf(
                "%1$s====================== Final Report ======================%2$s%n- Destination Planet: %3$s%n"
                        + "- Spaceship: %4$s%n- N° Passengers: %5$s%n- Total distance traveled: %6$,.0f%n"
                        + "- Average travel velocity: %7$,.0f%n- Travel duration: %8$,.0f%n"
                        + "%1$s%9$s%2$s%n%10$sPlease press enter to continue.%2$s",
                GREEN, RESET, destinationPlanet[0], selectedSpaceShip[0], selectedSpaceShip[3],
                destinationPlanetDistance, spaceShipVel, travelDuration, fix, BLUE);
        input.nextLine();

    }

    private static String generateEvent() {
        Random random = new Random();
        double probability = random.nextDouble();
        String[] randomEvent = {
                "Successful navigation",
                "System failure",
                "Encounter with an asteroid",
                "Sighting of a new star",
                "Fuel leak",
                "Scheduled maintenance",
                "Communication with another spacecraft",
                "Space-time anomaly"
        };
        double[] probabilitys = {
                0.05, // 5%
        };
        int index = 0;
        String event = "";

        if (probability < probabilitys[0]) {
            index = random.nextInt(randomEvent.length);
            event = String.format(": %1$s%n", randomEvent[index]);

            return event;
        } else {
            return event;
        }
    }

}
