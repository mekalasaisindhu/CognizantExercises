public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 10 + 5 * 2 - 4 / 2;

        System.out.println("10 + 5 * 2 = " + result1 + " (multiplication before addition)");
        System.out.println("(10 + 5) * 2 = " + result2 + " (parentheses change evaluation order)");
        System.out.println("10 + 5 * 2 - 4 / 2 = " + result3 + " (multiplication and division first)");
    }
}
