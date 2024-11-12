public class MathematicalOperation {
    public static void main(String[] args) throws Exception {
        int sum, mult, div, result;

        sum = 1 + 2;
        div = 6 / 2;
        mult = div * sum;
        result = mult;

        System.out.printf("The operation is: 6/2(1+2)\n"
                + "firts, we perform the addition that is inside the parentheses.\n"
                + "6/2(1+2) = 6/2(%1$d)\n"
                + "now we solve the division.\n"
                + "6/2(%1$d) = %2$d(%1$d)\n"
                + "finally, we perform the multiplication.\n"
                + "%2$d(%1$d) = %3$d\n"
                + "the result of the operation 6/2(1+2) is %4$d", sum, div, mult, result);
    }
}
