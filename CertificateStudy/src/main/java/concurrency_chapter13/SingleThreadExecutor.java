package concurrency_chapter13;

import reactor.core.scheduler.Scheduler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public static void main(String[] args) {

        Runnable task1 = () -> {
            System.out.println("Task 1");
        };

        Runnable task2 = () -> {
            for (int i=0; i<5; i++) {
                System.out.println("Task 2: i = " + i);
            }
        };

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            service.execute(task1);
            service.execute(task2);
            service.execute(task1);
        } finally {
            if (service != null) {
//                e.shutdown(); // doesnt stop any tasks that have been submitted to the thread executor
                List<Runnable> runnables = service.shutdownNow(); // it attemps to stop the already running tasks and returns list of tasks that never got started
                System.out.println(runnables.size() + " tasks that never got run");
            }
        }

        System.out.println("End of the main thread");
    }
}
