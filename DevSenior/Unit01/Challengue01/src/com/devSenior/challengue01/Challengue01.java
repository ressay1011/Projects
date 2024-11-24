package com.devSenior.challengue01;

import java.util.Scanner;

public class Challengue01 {

    // static final String BLACK = "\u001B[30m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    // static final String YELLOW = "\u001B[33m";
    // static final String BLUE = "\u001B[34m";
    // static final String PURPLE = "\u001B[35m";
    // static final String CYAN = "\u001B[36m";
    static final String WHITE = "\u001B[37m";

    static Scanner input = new Scanner(System.in);
    static int option;

    public static void main(String[] args) throws Exception {

        var error = true;
        String errorMsg;
        String[] planets = { "Marte", "Jupiter", "Saturno" };
        int[] planetDistance = { 225, 780, 1430 };

        menu();
    }

    private static void menu() {

        while (true) {
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

            if (input.hasNextInt()) {
                option = input.nextInt();
                switch (option) {
                    case 1:

                        break;

                    default:
                        System.out.printf("%1$sError: The option %3$d is not valid.%2$s", RED, WHITE, option);
                        break;
                }
            } else {
                System.out.printf("%1$sError: Please enter a number from 0 to 3.%2$s", RED, WHITE);
            }
            System.exit(0);
        }
    }
}
