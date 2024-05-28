package chapter13.threadpools;

import java.lang.invoke.MethodHandles;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ThreadPoolExample {

    private static final Logger log = Logger.getLogger(ThreadPoolExample.class.getName());

    public static Random random = new Random();

    public static void main(String[] args) {
//        usingFixedThreadPool();
//        usingCachedThreadPool();
//        usingNewScheduledThreadPool();
        LinkedList<String> list = new LinkedList<>();
        System.out.println(isCustomer("sta"));
        System.out.println(isCustomer("master"));
        System.out.println(isCustomer("customer"));
    }

    public static Boolean isCustomer(String realm) {
        return !realm.equalsIgnoreCase("sta") && !realm.equalsIgnoreCase("master");
    }

    public static void usingFixedThreadPool() {
        log.info("calling usingFixedThreadPool() method");

        Runnable task = () -> {
            int sleepTime = random.nextInt(20);
            System.out.println("Start of the task with id = " + Thread.currentThread().getId() + "(This task will take " + sleepTime + " to finish)");

            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                log.warning("error while running task " + e);
            }

            System.out.println("End of the task with id = " + Thread.currentThread().getId());
        };

        ExecutorService service = Executors.newFixedThreadPool(4);

        try {
            service.submit(task);
            service.submit(task);
            service.submit(task);
            service.submit(task);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void usingCachedThreadPool() {
        log.info("calling usingCachedThreadPool() method");

        Runnable task = () -> {
            int sleepTime = random.nextInt(20);
            System.out.println("Start of the task with id = " + Thread.currentThread().getId() + "(This task will take " + sleepTime + " to finish)");

            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                log.warning("error while running task " + e);
            }

            System.out.println("End of the task with id = " + Thread.currentThread().getId());
        };

        ExecutorService service = Executors.newCachedThreadPool();

        try {
            service.submit(task);
            service.submit(task);
            service.submit(task);
            service.submit(task);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void usingNewScheduledThreadPool() {
        log.info("calling usingNewScheduledThreadPool() method");

        Runnable task = () -> {
            int sleepTime = random.nextInt(20);
            System.out.println("Start of the task with id = " + Thread.currentThread().getId() + "(This task will take " + sleepTime + " to finish)");

            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                log.warning("error while running task " + e);
            }

            System.out.println("End of the task with id = " + Thread.currentThread().getId());
        };

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        try {
            service.schedule(task, 5, TimeUnit.SECONDS);
            service.schedule(task, 4, TimeUnit.SECONDS);
            service.schedule(task, 6, TimeUnit.SECONDS);
            service.schedule(task, 7, TimeUnit.SECONDS);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
