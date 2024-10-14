package concurrency_chapter13.threadsafecode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBaerrierExample {

    public static void main(String[] args) {
        CyclicBaerrierExample cbe = new CyclicBaerrierExample();
//        cbe.randomTasksExecution();
        cbe.safeTasksExecution();
    }

    private void randomTasksExecution() {
        ExecutorService service = Executors.newFixedThreadPool(4);
        try {
            var managers = new CyclicBaerrierExample();

            for (int i = 0; i < 4; i++) {
                service.submit(managers::performTasks);
            }
        } finally {
            service.shutdown();
        }
    }

    private void safeTasksExecution() {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier c1 = new CyclicBarrier(4);
        CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Cage fixed!"));

        try {
            var managers = new CyclicBaerrierExample();

            for (int i = 0; i < 4; i++) {
                service.submit(() -> managers.performTasksSafely(c1, c2));
            }
        } finally {
            service.shutdown();
        }
    }

    private void performTasksSafely(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeLions();
            c1.await();
            fixingCage();
            c2.await();
            returnLions();
        } catch (BrokenBarrierException | InterruptedException ignored) {}
    }

    private void performTasks() {
        removeLions();
        fixingCage();
        returnLions();
    }

    private void removeLions() {
        System.out.println("Thread with id: " + Thread.currentThread().getId() + " is removing lions");
    }

    private void fixingCage() {
        System.out.println("Thread with id: " + Thread.currentThread().getId() + " is fixing cage");
    }

    private void returnLions() {
        System.out.println("Thread with id: " + Thread.currentThread().getId() + " is returning lions");
    }
}
