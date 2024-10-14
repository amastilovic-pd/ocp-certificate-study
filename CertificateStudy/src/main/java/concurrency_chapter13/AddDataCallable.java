package concurrency_chapter13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddDataCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Start of the main thread");

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();

            Future<Integer> result = service.submit(() -> 1 + 2);
            System.out.println("Result = " + result.get());
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        System.out.println("End of the main thread");
    }
}
