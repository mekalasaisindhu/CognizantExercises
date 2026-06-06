import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            tasks.add(() -> "Result from task " + taskNumber);
        }

        List<Future<String>> futures = executor.invokeAll(tasks);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}
