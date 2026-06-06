import java.util.stream.IntStream;

public class ThreadsExample {

    public static void main(String[] args)
            throws InterruptedException {

        Thread[] threads =
                IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {

                    Thread t = new Thread(() ->
                            System.out.println(
                                    "Thread " + i));

                    t.start();

                    return t;
                })
                .toArray(Thread[]::new);

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(
                "All threads completed.");
    }
}