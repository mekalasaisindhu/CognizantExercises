public class TypeCastingExample {
    public static void main(String[] args) {
        double originalDouble = 7.89;
        int castToInt = (int) originalDouble;
        System.out.println("Original double: " + originalDouble);
        System.out.println("After casting to int: " + castToInt);

        int originalInt = 10;
        double castToDouble = (double) originalInt;
        System.out.println("Original int: " + originalInt);
        System.out.println("After casting to double: " + castToDouble);
    }
}
