package chapter13.threadsafecode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafetyExample {

    private static Integer counter = 0;
    private static volatile int volatileCounter = 0;
    private static final AtomicInteger atomicCounter = new AtomicInteger();
                        // AtomicLong
                        // AtomicBoolean

    public static void main(String[] args) {
//        problemWithThreads();
//        usingVolatile();
//        usingAtomicClasses();
//        usingSynchronizedBlock();
//        usingSynchronizedMethod();
        usingLockFramework();
    }

    protected static void testingmyshit() {}
    private static void problemWithThreads() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    System.out.print(++counter + " ");
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void usingVolatile() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    System.out.print((++volatileCounter) + " ");
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void usingAtomicClasses() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    System.out.print(atomicCounter.incrementAndGet() + " ");
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void usingSynchronizedBlock() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Object key = new Object();

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    synchronized (key) {
                        System.out.print(++counter + " ");
                    }
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static synchronized void usingSynchronizedMethod() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    System.out.print(++counter + " ");
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void usingLockFramework() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Lock lock = new ReentrantLock();

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    try {
                        lock.lock();
                        System.out.print(++counter + " ");
                    } finally {
                        lock.unlock();
                    }
                });
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
