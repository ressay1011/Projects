/**
 * Price Calculator.
 * This class calculates the price per kilogram of a product based on a
 * smaller portion's price. It is designed to verify the accuracy of a
 * provided market price label.
 */
public class Price {
    /**
     * Main entry point of the program.
     * Performs price calculation using floating-point math and displays
     * the result formatted for currency.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        float price; // Declare a float variable to store the calculated price.

        // Calculate the price per kilogram.
        // The product costs $5.95 per 100 grams. To get the price per kilogram (1000
        // grams),
        // we multiply the 100-gram price by 10 (since 1000 grams / 100 grams = 10).
        price = (5.95f * 1000) / 100;

        // Print the result, explaining the scenario and displaying the calculated price
        // formatted to two decimal places.
        System.out.printf(
                "In the market, we can find that the price of the product Pernil Iberic D'Engreix Llen."
                        + "Azuaga in a 100-gram portion costs $5.95, and the seller tells us that the price per kilo is $29.75. "
                        + "Do you think the price is correct?%n"
                        + "In this challenge, you need to create a program that correctly calculates the price per kilo of the product.%n"
                        + "The price of the product is: %.2f",
                price);
    }
}
