import java.util.Scanner;

public class PersonalGreeting {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String typedName = "";
        String errorMessage = "";
        boolean error = true;

        while (error == true) {
            System.out.print("Enter your name:");
            typedName = input.nextLine();

            typedName = typedName.strip();

            if (typedName.isBlank()) {
                errorMessage = "Please enter a name.";
            } else if (!typedName.matches("[a-zA-Z]+")) {
                errorMessage = "Please enter only letters in the name field.";
            } else {
                error = false;
            }

            if (error == true) {
                System.err.printf("Error: %s%n", errorMessage);
            }
        }
        typedName = typedName.replace(typedName.charAt(0), Character.toUpperCase(typedName.charAt(0)));
        System.out.printf("Hello %s, welcome to the Java programming course!!", typedName);
        input.close();
    }
}
