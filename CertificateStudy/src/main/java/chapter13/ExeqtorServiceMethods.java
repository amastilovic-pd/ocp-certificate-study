package chapter13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExeqtorServiceMethods {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(()-> {
                for (int i=0;i<500;i++) {
                    ExeqtorServiceMethods.counter++;
                }
            });

//            result.get(10, TimeUnit.SECONDS);
//            System.out.println("Task complete");
        } finally {
            if (service != null) {
                service.shutdown(); // doesnt stop any tasks that have been submitted to the thread executor
//                List<Runnable> runnables = e.shutdownNow(); // it attemps to stop the already running tasks and returns list of tasks that never got started
//                System.out.println(runnables.size() + " tasks that never got run");
            }
        }
        if(service != null) {
            service.awaitTermination(10, TimeUnit.SECONDS);

            if(service.isTerminated()) {
                System.out.println("Task completed");
            } else {
                System.out.println("Task hasnt completed");
            }
        }
    }
}
