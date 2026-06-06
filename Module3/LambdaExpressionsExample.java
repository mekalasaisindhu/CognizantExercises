import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Banana");
        items.add("Apple");
        items.add("Orange");

        Collections.sort(items, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted list: " + items);
    }
}
