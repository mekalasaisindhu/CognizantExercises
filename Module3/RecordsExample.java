import java.util.List;
import java.util.stream.Collectors;

public class RecordsExample {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Carol", 25)
        );

        List<Person> adults = people.stream()
                .filter(person -> person.age() >= 25)
                .collect(Collectors.toList());

        System.out.println("People: " + people);
        System.out.println("Adults: " + adults);
    }
}

record Person(String name, int age) {}
