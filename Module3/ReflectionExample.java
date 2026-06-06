import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionExample$DemoClass");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getDeclaredMethod("sayHello");
        System.out.println("Class: " + clazz.getName());
        System.out.println("Methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("- " + m.getName());
        }
        method.invoke(instance);
    }

    public static class DemoClass {
        public void sayHello() {
            System.out.println("Hello from DemoClass via reflection.");
        }
    }
}
