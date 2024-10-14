package concurrency_chapter13.scheduling;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Schedule {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        usingScheduleCallable();

    }

    public static void usingScheduleCallable() throws ExecutionException, InterruptedException {
        Callable<String> task = () -> "Returned from thread";
        Runnable asd = () -> System.out.println("asd");

        ScheduledExecutorService service = null;

        try {
            service = Executors.newSingleThreadScheduledExecutor();

            ScheduledFuture<String> schedule = service.schedule(task, 5, TimeUnit.SECONDS);

            System.out.println(schedule.get());
        } finally {
            if(service != null) {
                service.shutdown();
            }
        }
    }
}
