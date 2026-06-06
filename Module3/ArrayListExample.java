import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student names (blank line to finish):");
        while (true) {
            String name = scanner.nextLine();
            if (name.isBlank()) {
                break;
            }
            names.add(name);
        }

        System.out.println("Names entered:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
