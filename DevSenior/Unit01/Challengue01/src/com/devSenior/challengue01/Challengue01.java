package com.devSenior.challengue01;

import java.util.Scanner;

public class Challengue01 {

    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String WHITE = "\u001B[37m";

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            int option;
            String[] destinationPlanet;
            String[] selectedSpaceShip;

            option = mainMenu();

            switch (option) {
                case 0:
                    System.out.printf("%1$sExiting the program...%2$s", BLUE, WHITE);
                    System.exit(0);
                    break;
                case 1:
                    destinationPlanet = menuDestinationPlanet();
                    break;
                case 2:
                    selectedSpaceShip = menuSpaceShip();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Como rayos llegaste aqui?");
                    break;
            }
        }
    }

    private static int showMenu(String[] options) {
        var optionsTemp = "";
        var nOptions = options.length;
        var i = 0;
        var selectionTemp = 0;
        var selection = 0;
        var error = true;
        var errorMsg = "";

        while (error == true) {
            optionsTemp = "";
            i = 0;
            selectionTemp = 0;

            System.out.printf("%1$s               _____ ____  ___   ____________\n"
                    + "              / ___// __ \\/   | / ____/ ____/\n"
                    + "              \\__ \\/ /_/ / /| |/ /   / __/\n"
                    + "             ___/ / ____/ ___ / /___/ /___\n"
                    + "%2$s   _____ ___%1$s/____/_/%2$s__ %1$s/_/%2$s__%1$s|_\\____/_____/%2$s_____  ____\n"
                    + "  / ___//  _/  |/  / / / / /   /   |/_  __/ __ \\/ __ \\\n"
                    + "  \\__ \\ / // /|_/ / / / / /   / /| | / / / / / / /_/ /\n"
                    + " ___/ // // /  / / /_/ / /___/ ___ |/ / / /_/ / _, _/\n"
                    + "/____/___/_/  /_/\\____/_____/_/  |_/_/  \\____/_/ |_|%3$s\n\n", RED, GREEN, WHITE);

            for (String option : options) {
                if (i != (nOptions - 1)) {
                    optionsTemp = optionsTemp.concat("%1$s" + (i + 1) + ".%2$s " + option + ".\n");
                } else {
                    optionsTemp = optionsTemp.concat("%1$s" + (i - (nOptions - 1)) + ".%2$s "
                            + option + ".\n");
                }
                i = i + 1;
            }

            if (error = true) {
                optionsTemp = optionsTemp.concat(errorMsg);
                error = false;
            }

            optionsTemp = optionsTemp.concat("%3$sPlease select an option (0 - " + (nOptions - 1) + "):%2$s ");
            System.out.printf(optionsTemp, GREEN, WHITE, BLUE, RED);

            if (input.hasNextInt()) {
                selectionTemp = input.nextInt();
                if (selectionTemp >= 0 & selectionTemp <= (nOptions - 1)) {
                    selection = selectionTemp;
                } else {
                    error = true;
                    errorMsg = "%4$sError: The option " + selectionTemp + " is not valid.%2$s\n";
                }
            } else {
                error = true;
                errorMsg = "%4$sError: Please enter a number from 0 to " + (nOptions - 1) + ".%2$s\n";
            }
            input.nextLine();
        }
        return selection;
    }

    private static int mainMenu() {
        int selection;
        String[] options = {
                "Select destination planet",
                "Select spaceship",
                "Start the travel simulation",
                "Exit the program" };

        selection = showMenu(options);

        return selection;
    }

    private static String[] menuDestinationPlanet() {
        String[] planets = { "Mercury", "Venus", "Mars", "Jupiter", "Saturn",
                "Uranus", "Neptune" };
        int selection;
        String[] destinationPlanet = { "" };
        String[] options = new String[(planets.length + 1)];

        for (var i = 0; i < planets.length; i++) {
            options[i] = planets[i];
        }
        options[planets.length] = "Back";

        selection = showMenu(options);

        if (selection != 0) {
            destinationPlanet = destinationPlanet(selection, planets);
        }

        return destinationPlanet;
    }

    private static String[] destinationPlanet(int option, String[] planets) {
        String[] planetDistance = { "91", "41", "225", "778", "1429", "2900", "4300" };
        String[] planetDescription = {
                "is the smallest and closest planet to the Sun.\nIt has a rocky surface with extreme temperature changes, ranging from -180°C at night to 430°C during the day.\nIt orbits the Sun in just 88 days.",
                "is the second planet from the Sun and similar in size to Earth.\nIt has a thick, toxic atmosphere primarily made of carbon dioxide, which creates a runaway greenhouse effect, making it the hottest planet in the solar system.\nSurface temperatures can reach up to 470°C.\nVenus has no moons and rotates in the opposite direction to most planets, with a day longer than its year.",
                "is the fourth planet from the Sun, known as the \"Red Planet\" due to its reddish appearance caused by iron oxide on its surface.",
                "is the largest planet in the solar system, known for its massive size, strong magnetic field, and distinctive Great Red Spot, a giant storm.\nIt is a gas giant with no solid surface.",
                "is the second-largest planet in the solar system, famous for its stunning ring system made of ice and rock.\nIt is a gas giant with a predominantly hydrogen and helium atmosphere.",
                "is the seventh planet from the Sun and is known for its distinctive blue-green color, caused by methane in its atmosphere.\nIt is an ice giant with a mostly hydrogen and helium atmosphere, but it also contains water, ammonia, and methane.\nUranus has a unique rotation, spinning on its side with an axial tilt of 98 degrees.\nThis results in extreme seasonal variations.\nIt has 13 rings and 27 known moons.",
                "is the eighth and farthest planet from the Sun.\nIt is an ice giant with a deep blue color due to methane in its atmosphere.\nNeptune has strong winds, the fastest in the solar system, and large storm systems, including the Great Dark Spot.\nIt has 14 known moons, with Triton being the largest, and five rings.\nIts atmosphere is mostly hydrogen, helium, and methane."
        };
        String[] destinationPlanetInfo = new String[2];
        destinationPlanetInfo[0] = planets[option - 1];
        destinationPlanetInfo[1] = planetDistance[option - 1];

        System.out.printf(
                "%4$sThe selected planet is:%6$s %1$s located approximately %2$s million kilometers from Earth %3$s\n%5$sPress enter to continue.%6$s",
                destinationPlanetInfo[0], destinationPlanetInfo[1],
                planetDescription[option - 1], GREEN, BLUE, WHITE);
        input.nextLine();

        return destinationPlanetInfo;
    }

    private static String[] menuSpaceShip() {
        String[] spaceShips = { "Red dwarf", "Discovery", "Millennium falcon" };
        int selection = -1;
        String[] selectedSpaceShip = null;
        String[] options = new String[(spaceShips.length + 1)];

        while (selectedSpaceShip == null && selection != 0) {

            for (var i = 0; i < spaceShips.length; i++) {
                options[i] = spaceShips[i];
            }

            options[spaceShips.length] = "Back";
            selection = showMenu(options);

            if (selection != 0) {
                selectedSpaceShip = selectedSpaceShip(selection, spaceShips);
            }
        }
        return selectedSpaceShip;
    }

    private static String[] selectedSpaceShip(int option, String[] spaceShips) {
        var confirmation = "";
        String[] spaceShipsMaxVel = { "36.400", "28.000", "42.000" };
        String[] spaceShipsMaxCapacity = { "10", "25", "5" };
        String[] spaceShipsMaxFuel = { "600", "900", "450" };
        String[] spaceShipsMaxOxygen = { "600", "900", "450" };
        String[] spaceShipsMaxWeight = { "3000", "5050", "2000" };
        var spaceShipsCapacity = "";
        var passengersTemp = 0;

        String[] selectedSpaceShipInfo = new String[7];
        selectedSpaceShipInfo[0] = spaceShips[option - 1];
        selectedSpaceShipInfo[1] = spaceShipsMaxVel[option - 1];
        selectedSpaceShipInfo[2] = spaceShipsMaxCapacity[option - 1];
        selectedSpaceShipInfo[3] = spaceShipsMaxFuel[option - 1];
        selectedSpaceShipInfo[4] = spaceShipsMaxOxygen[option - 1];
        selectedSpaceShipInfo[5] = spaceShipsMaxWeight[option - 1];

        System.out.printf(
                "%7$sThe selected spaceship is:%9$s %1$s \n- Velocity: %2$s KM/H\n- Max.Capacity: %3$s Passengers"
                        + "\n- Max.Fuel: %4$s Tons\n- Max.Oxygen: %5$s KG\n- Max.Weight: %6$s Tons\n"
                        + "%8$sDo you want to select this spaceship(Y/n): %9$s",
                selectedSpaceShipInfo[0], selectedSpaceShipInfo[1], selectedSpaceShipInfo[2],
                selectedSpaceShipInfo[3], selectedSpaceShipInfo[4], selectedSpaceShipInfo[5],
                GREEN, BLUE, WHITE);

        confirmation = input.nextLine();

        if (confirmation.equalsIgnoreCase("n")) {
            return null;
        }

        System.out.printf(
                "%2$sSpaceship %1$s successfully selected.%3$s \n",
                selectedSpaceShipInfo[0], GREEN, WHITE);

        while (spaceShipsCapacity.isBlank()) {
            System.out.printf("%1$sPlease enter the number of passengers traveling: %2$s", BLUE, WHITE);

            if (input.hasNextInt()) {
                passengersTemp = input.nextInt();

                if (passengersTemp >= 0) {
                    if (passengersTemp > Integer.parseInt(selectedSpaceShipInfo[2])) {
                        System.out.printf(
                                "%1$sWarning: Spaceship capacity exceeded."
                                        + "The number of passengers is higher that the recommended limit."
                                        + "\nPlease proceed with caution.%2$s\n",
                                YELLOW, WHITE);
                    }
                    spaceShipsCapacity = String.valueOf(passengersTemp);
                } else {
                    System.out.printf("%1$sError: Please enter a positive number.%2$s\n", RED, WHITE);
                }
            } else {
                System.out.printf("%1$sError: Please enter a positive number.%2$s\n", RED, WHITE);
            }
            input.nextLine();
        }

        selectedSpaceShipInfo[6] = spaceShipsCapacity;

        return selectedSpaceShipInfo;
    }

}
