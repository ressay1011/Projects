import java.util.Scanner;

public class Words {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String word = "";
        String words = "";
        String errorMessage = "";
        boolean error = true;
        int i = 0;

        while (error == true) {
            while (i < 3) {
                error = true;
                System.out.printf("Enter your word #%d:", i + 1);
                word = input.nextLine();

                word = word.strip();

                if (word.isBlank()) {
                    errorMessage = "Please enter a word.";
                } else if (!word.matches("[a-zA-Z]+")) {
                    errorMessage = "Please enter only letters in the word field.";
                } else {
                    error = false;
                    words = words + word + " ";
                    i = i + 1;
                }

                if (error == true) {
                    System.err.printf("Error: %s%n", errorMessage);
                }
            }
        }

        System.out.println(words);
        input.close();
    }
}
