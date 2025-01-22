import java.util.Scanner;

public class PersonalGreeting {
    public static void main(String[] args) {

        // Create a Scanner object to receive user input
        Scanner input = new Scanner(System.in);

        // Variables to store the entered name and error messages
        String typedName = ""; // Temporarily stores the name entered by the user
        String errorMessage = ""; // Stores the error message to display if the input is invalid
        boolean error = true; // Controls whether there is an error in the input

        // Loop until a valid name is entered
        while (error == true) {

            // Prompt the user to enter their name
            System.out.print("Enter your name:");
            typedName = input.nextLine();

            // Remove leading and trailing whitespace from the input
            typedName = typedName.strip();

            // Validate the entered name
            if (typedName.isBlank()) {
                errorMessage = "Please enter a name."; // Error message if blank
            } else if (!typedName.matches("[a-zA-Z\\u00F1\\u00D1]+")) {
                errorMessage = "Please enter only letters in the name field."; // Error if name contains non-letter
                                                                               // characters
            } else {
                error = false; // No error, name is valid
            }

            // If there was an error, display the corresponding message
            if (error == true) {
                System.err.printf("Error: %s%n", errorMessage);
            }
        }

        // Capitalize the first letter of the name
        typedName = typedName.replace(typedName.charAt(0), Character.toUpperCase(typedName.charAt(0)));

        // Print a greeting message to the user
        System.out.printf("Hello %s, welcome to the Java programming course!!", typedName);

        // Close the scanner to free up the resource
        input.close();
    }
}
