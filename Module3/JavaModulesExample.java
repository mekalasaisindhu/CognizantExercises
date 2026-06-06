public class JavaModulesExample {
    public static void main(String[] args) {
        System.out.println("This example describes a Java module setup.");
        System.out.println("Use separate module directories and module-info.java files for com.greetings and com.utils.");
        System.out.println("Example command: javac -d out --module-path mods com.greetings/com/greetings/Main.java");
    }
}
