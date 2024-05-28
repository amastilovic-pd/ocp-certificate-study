package chapter13;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleTasks {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        usingInvokeAll();
//        usingInvokeAny();
    }

    public static void usingInvokeAll() throws InterruptedException, ExecutionException {
        System.out.println("Start of the main thread");

        Callable<String> task = () -> "Result from the thread";

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();

            List<Future<String>> results = service.invokeAll(List.of(task, task, task)); // runs all of the tasks

            for (Future result : results) {
                System.out.println(result.get());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        System.out.println("End of the main thread");
    }
    
    public static void usingInvokeAny() throws InterruptedException, ExecutionException {
        System.out.println("Start of the main thread");

        Callable<String> task = () -> "Result from the thread";

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();

            String result = service.invokeAny(List.of(task, task, task)); // runs just one of the tasks and returns response

            System.out.println(result);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        System.out.println("End of the main thread");
    }
}
