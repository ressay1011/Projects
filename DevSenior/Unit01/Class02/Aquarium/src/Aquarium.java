/**
 * Aquarium.
 * This class calculates the total number of fish in an aquarium given the
 * counts of red and blue fish. It demonstrates simple integer arithmetic
 * and formatted console output.
 */
public class Aquarium {
    /**
     * Main entry point of the program.
     * Performs a simple addition of fish counts and prints the result.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int redFish = 284; // Number of red fish in the aquarium
        int blueFish = 163; // Number of blue fish in the aquarium
        int sum; // Hold the total number of fish

        // Calculate the total number of fish by adding red and blue fish
        sum = redFish + blueFish;

        // Output the total number of fish in the aquarium to the console
        System.out.printf("In total, there are %d fishes inside the aquarium.", sum);
    }
}
