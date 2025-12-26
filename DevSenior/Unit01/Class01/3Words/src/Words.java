import java.util.Scanner;

/**
 * 3-Word Reader.
 * This class prompts the user to enter three separate words,
 * validates the input to ensure only letters are entered,
 * and then displays the concatenated words.
 */
public class Words {
    /**
     * Main entry point of the program.
     * Manages user input, validation, and concatenation of words.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        // Import the Scanner class to receive user input
        Scanner input = new Scanner(System.in);

        // Variables to store the input words, the final concatenated words string, and
        // error messages
        String word = ""; // Temporarily stores each word
        String words = ""; // Stores all entered words, concatenated
        String errorMessage = ""; // Stores the error message to display to the user
        boolean error = true; // Controls whether there is an error in user input
        int i = 0; // Counter for the number of entered words

        // Main loop to request 3 valid words
        while (error == true) {

            // Loop for each word until the counter i reaches 3
            while (i < 3) {
                error = true; // Assume there's an error in the initial input

                // Prompt the user to enter a word, with word index
                System.out.printf("Enter your word #%d:", i + 1);
                word = input.nextLine();

                // Remove leading and trailing whitespace from the input
                word = word.strip();

                // Validate the entered word
                if (word.isBlank()) {
                    errorMessage = "Please enter a word."; // Error message if blank
                } else if (!word.matches("[a-zA-Z\\u00F1\\u00D1]+")) {
                    errorMessage = "Please enter only letters in the word field."; // Error message if it contains
                                                                                   // invalid characters
                } else {
                    error = false; // No error, word is valid
                    words = words + word + " "; // Concatenate the word to the final string
                    i = i + 1; // Increment the counter
                }

                // If there was an error, display the corresponding message
                if (error == true) {
                    System.err.printf("Error: %s%n", errorMessage);
                }
            }
        }

        // Print the final string with all entered words
        System.out.println(words);

        // Close the scanner to free up the resource
        input.close();
    }
}
