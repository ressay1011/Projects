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

    public static void main(String[] args) throws Exception {
        int option;
        String[] options = {
                "Select destination planet.",
                "Select spacecraft.",
                "Start the travel simulation.",
                "Exit the program." };
        option = showMenu(options);
        menu(option);
    }

    private static int showMenu(String[] options) {
        String optionsTemp;
        int nOptions = options.length;
        int i;
        int selectionTemp;
        int selection = 0;
        boolean error = true;
        String errorMsg = "";

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
                    optionsTemp = optionsTemp.concat("%1$s" + (i + 1) + ".%2$s " + option + "\n");
                } else {
                    optionsTemp = optionsTemp.concat("%1$s" + (i - (nOptions - 1)) + ".%2$s "
                            + option + "\n");
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

    private static void menu(int option) {
        String[] planets = { "Mercury.", "Venus.", "Mars.", "Jupiter.", "Saturn.",
                "Uranus.", "Neptune." };
        int[] planetDistance = { 91, 41, 225, 778, 1429, 2900, 4300 };

        switch (option) {
            case 0:
                System.out.printf("%1$sExiting the program...%2$s", BLUE, WHITE);
                System.exit(0);
                break;
            case 1:
                String[] options = new String[(planets.length + 1)];
                for (int i = 0; i < planets.length; i++) {
                    options[i] = planets[i];
                }
                options[planets.length] = "Back.";
                option = showMenu(options);
                menuDestinationPlanet(option);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Como rayos llegaste aqui?");
                break;
        }
    }

    private static void menuDestinationPlanet(int option) {

    }
}

/*
 * private static void menu() {
 * 
 * private static int menuDestinationPlanet(String[] planets, int[]
 * planetDistance) {
 * int destinationPlanet;
 * String[] planetDescription = {
 * "Mars is the fourth planet from the Sun, known as the \"Red Planet\" due to its reddish appearance caused by iron oxide on its surface."
 * ,
 * "Jupiter is the largest planet in the solar system, known for its massive size, strong magnetic field, and distinctive Great Red Spot, a giant storm. It is a gas giant with no solid surface."
 * ,
 * "Saturn is the second-largest planet in the solar system, famous for its stunning ring system made of ice and rock. It is a gas giant with a predominantly hydrogen and helium atmosphere."
 * };
 * 
 * while (error == true) {
 * logo();
 * System.out.printf("%1$s1.%2$s Marte\n"
 * + "%1$s2.%2$s Júpiter\n"
 * + "%1$s3.%2$s Saturno\n"
 * + "%1$s0.%2$s Back\n", GREEN, WHITE);
 * System.out.printf("%1$sPlease select the destination planet (0 - 3):%2$s ",
 * BLUE, WHITE);
 * 
 * if (input.hasNextInt()) {
 * option = input.nextInt();
 * input.nextLine();
 * switch (option) {
 * case 0:
 * menu();
 * break;
 * case 1:
 * 
 * break;
 * default:
 * System.out.printf("%1$sError: The option %3$d is not valid.%2$s\n", RED,
 * WHITE, option);
 * break;
 * }
 * } else {
 * System.out.printf("%1$sError: Please enter a number from 0 to 3.%2$s\n", RED,
 * WHITE);
 * input.nextLine();
 * }
 * }
 * 
 * return destinationPlanet = option;
 * }
 */
