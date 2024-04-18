package chapter13.threadsafecode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        new Thread(() -> acquireLock(lock)).start();

//        Thread.sleep(5000);

        if(lock.tryLock()) {
            System.out.println("Lock acquired my main thread");
            //thread safe code
            lock.unlock();
        } else {
            System.out.println("Lock cannot be acquired my main thread");
        }
    }

    private static void acquireLock(Lock lock) {
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }
}
