/**
 * The `Price` class calculates and displays the price per kilogram of a
 * product.
 */
public class Price {
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
