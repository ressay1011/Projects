/**
 * Mathematical Operation Challenge.
 * This class solves the mathematical expression {@code 6/2(1+2)} and explains
 * the results from both correct and incorrect approaches based on the order
 * of operations (PEMDAS/BODMAS).
 */
public class MathematicalOperation {
    /**
     * Main entry point of the program.
     * Executes the mathematical steps for both order-of-operation scenarios
     * and prints an educational summary.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        // Declare and initialize variables for the numbers used in the operation
        int num1 = 6; // The numerator in the division
        int num2 = 2; // The divisor in the division
        int num3 = 1; // Part of the number inside parentheses
        int num4 = 2; // Part of the number inside parentheses
        int sum, mult1, mult2, div1, div2, result1, result2; // Declare variables for intermediate results

        // Perform the addition inside the parentheses (1 + 2)
        sum = num3 + num4;

        // Perform the division of 6 / 2
        div1 = num1 / num2;

        // Multiply the result of the division by the sum (div1 * sum)
        mult1 = div1 * sum;

        // Store the result of the previous multiplication in result1
        result1 = mult1;

        // Perform the multiplication of 2 * (1 + 2)
        mult2 = num2 * sum;

        // Perform the division of 6 by the result of the previous multiplication
        div2 = num1 / mult2;

        // Store the result of this division in result2
        result2 = div2;

        // Print the solution to the challenge, explaining both correct and incorrect
        // approaches
        System.out.printf(
                "In this challenge, you need to program the mathematical operation 6/2(1+2) using the necessary instructions.%n"
                        + "- What is the correct result of the operation? 1 or 9?%n"
                        + "- Explain why the other calculator generates a different result.%n"
                        + "Solution: The operation is: 6/2(1+2)%n"
                        + "firts, we perform the addition that is inside the parentheses.%n"
                        + "6/2(1+2) = 6/2(%1$d)%n"
                        + "now we solve the division.%n"
                        + "6/2(%1$d) = %2$d(%1$d)%n"
                        + "finally, we perform the multiplication.%n"
                        + "%2$d(%1$d) = %3$d%n"
                        + "the result of the operation 6/2(1+2) is %4$d.%n"
                        + "Incorrect solution: The operation is: 6/2(1+2)%n"
                        + "firts, we perform the addition that is inside the parentheses.%n"
                        + "6/2(1+2) = 6/2(%1$d)%n"
                        + "now we solve the multiplication.%n"
                        + "6/2(%1$d) = 6/%5$d%n"
                        + "finally, we perform the division.%n"
                        + "6/%5$d = %6$d%n"
                        + "the incorrect result of the operation 6/2(1+2) is %7$d.%n",
                sum, div1, mult1, result1,
                mult2, div2, result2);
    }
}
