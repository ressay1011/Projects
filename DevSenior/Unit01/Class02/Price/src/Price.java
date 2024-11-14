public class Price {
    public static void main(String[] args) throws Exception {
        float price; // Store the price

        price = (5.95f * 1000) / 100; // Calculate the price by multiplying 1000 by 5.95 and then dividing by 100

        // Print the result, formatting the price to 2 decimal places
        System.out.printf(
                "In the market, we can find that the price of the product Pernil Iberic D'Engreix Llen."
                        + "Azuaga in a 100-gram portion costs $5.95, and the seller tells us that the price per kilo is $29.75. "
                        + "Do you think the price is correct?%n"
                        + "In this challenge, you need to create a program that correctly calculates the price per kilo of the product.%n"
                        + "The price of the product is: %.2f",
                price);
    }
}
