package com.devSenior.challengue01;

import java.util.Scanner;

public class Challengue01 {

    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    // static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    // static final String PURPLE = "\u001B[35m";
    // static final String CYAN = "\u001B[36m";
    static final String WHITE = "\u001B[37m";

    static Scanner input = new Scanner(System.in);
    static int option;
    static boolean error = true;

    public static void main(String[] args) throws Exception {
        menu();
    }

    private static void menu() {
        String[] planets = { "Marte", "Jupiter", "Saturno" };
        int[] planetDistance = { 225, 780, 1430 };
        int destinationPlanet;

        while (error == true) {
            System.out.printf("%1$s               _____ ____  ___   ____________\n"
                    + "              / ___// __ \\/   | / ____/ ____/\n"
                    + "              \\__ \\/ /_/ / /| |/ /   / __/\n"
                    + "             ___/ / ____/ ___ / /___/ /___\n"
                    + "%2$s   _____ ___%1$s/____/_/%2$s__ %1$s/_/%2$s__%1$s|_\\____/_____/%2$s_____  ____\n"
                    + "  / ___//  _/  |/  / / / / /   /   |/_  __/ __ \\/ __ \\\n"
                    + "  \\__ \\ / // /|_/ / / / / /   / /| | / / / / / / /_/ /\n"
                    + " ___/ // // /  / / /_/ / /___/ ___ |/ / / /_/ / _, _/\n"
                    + "/____/___/_/  /_/\\____/_____/_/  |_/_/  \\____/_/ |_|%3$s\n\n", RED, GREEN, WHITE);

            System.out.printf("%1$s1.%2$s Select destination planet\n"
                    + "%1$s2.%2$s Select spacecraft\n"
                    + "%1$s3.%2$s Start journey\n"
                    + "%1$s0.%2$s Exit program\n", GREEN, WHITE);
            System.out.printf("%1$sPlease select an option (0 - 3):%2$s ", BLUE, WHITE);

            if (input.hasNextInt()) {
                option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        destinationPlanet = menuDestinationPlanet(planets, planetDistance);
                        break;
                    default:
                        System.out.printf("%1$sError: The option %3$d is not valid.%2$s\n", RED, WHITE, option);
                        break;
                }
            } else {
                System.out.printf("%1$sError: Please enter a number from 0 to 3.%2$s\n", RED, WHITE);
                input.nextLine();
            }
        }
    }

    private static int menuDestinationPlanet(String[] planets, int[] planetDistance) {
        int destinationPlanet;
        String[] planetDescription = {
                "Mars is the fourth planet from the Sun, known as the \"Red Planet\" due to its reddish appearance caused by iron oxide on its surface.",
                "Jupiter is the largest planet in the solar system, known for its massive size, strong magnetic field, and distinctive Great Red Spot, a giant storm. It is a gas giant with no solid surface.",
                "Saturn is the second-largest planet in the solar system, famous for its stunning ring system made of ice and rock. It is a gas giant with a predominantly hydrogen and helium atmosphere." };

        while (error == true) {
            System.out.printf("%1$s               _____ ____  ___   ____________\n"
                    + "              / ___// __ \\/   | / ____/ ____/\n"
                    + "              \\__ \\/ /_/ / /| |/ /   / __/\n"
                    + "             ___/ / ____/ ___ / /___/ /___\n"
                    + "%2$s   _____ ___%1$s/____/_/%2$s__ %1$s/_/%2$s__%1$s|_\\____/_____/%2$s_____  ____\n"
                    + "  / ___//  _/  |/  / / / / /   /   |/_  __/ __ \\/ __ \\\n"
                    + "  \\__ \\ / // /|_/ / / / / /   / /| | / / / / / / /_/ /\n"
                    + " ___/ // // /  / / /_/ / /___/ ___ |/ / / /_/ / _, _/\n"
                    + "/____/___/_/  /_/\\____/_____/_/  |_/_/  \\____/_/ |_|%3$s\n\n", RED, GREEN, WHITE);

            System.out.printf("%1$s1.%2$s Marte\n"
                    + "%1$s2.%2$s Júpiter\n"
                    + "%1$s3.%2$s Saturno\n"
                    + "%1$s0.%2$s Back\n", GREEN, WHITE);
            System.out.printf("%1$sPlease select the destination planet (0 - 3):%2$s ", BLUE, WHITE);

            if (input.hasNextInt()) {
                option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 0:
                        menu();
                        break;
                    case 1:
                        
                        break;
                    default:
                        System.out.printf("%1$sError: The option %3$d is not valid.%2$s\n", RED, WHITE, option);
                        break;
                }
            } else {
                System.out.printf("%1$sError: Please enter a number from 0 to 3.%2$s\n", RED, WHITE);
                input.nextLine();
            }
        }

        return destinationPlanet = option;
    }
}
