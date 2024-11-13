public class MathematicalOperation {
    public static void main(String[] args) throws Exception {
        int num1 = 6;
        int num2 = 2;
        int num3 = 1;
        int num4 = 2;
        int sum, mult1, mult2, div1, div2, result1, result2;

        sum = num3 + num4;
        div1 = num1 / num2;
        mult1 = div1 * sum;
        result1 = mult1;
        mult2 = num2 * sum;
        div2 = num1 / mult2;
        result2 = div2;

        System.out.printf("In this challenge, you need to program the mathematical operation 6/2(1+2) using the necessary instructions.%n"
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
                + "the incorrect result of the operation 6/2(1+2) is %7$d.%n", sum, div1, mult1, result1,
                mult2, div2, result2);
    }
}
