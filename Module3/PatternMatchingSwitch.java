public class PatternMatchingSwitch {

    public static void main(String[] args) {
        describeObject(42);
        describeObject("Hello");
        describeObject(3.14);
        describeObject(true);
    }

    public static void describeObject(Object value) {

        if (value instanceof Integer i) {
            System.out.println("Integer value: " + i);
        }
        else if (value instanceof String s) {
            System.out.println("String value: " + s);
        }
        else if (value instanceof Double d) {
            System.out.println("Double value: " + d);
        }
        else if (value instanceof Boolean b) {
            System.out.println("Boolean value: " + b);
        }
        else {
            System.out.println(
                "Unknown type: " +
                value.getClass().getSimpleName()
            );
        }
    }
}