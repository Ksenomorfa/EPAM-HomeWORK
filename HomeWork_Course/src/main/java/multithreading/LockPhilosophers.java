package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPhilosophers {
    public static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        Lock[] lock = new Lock[NUMBER_OF_PHILOSOPHERS];
        int lastFork = lock.length - 1;

        for (int i = 0; i < lock.length; i++) {
            lock[i] = new ReentrantLock();
        }

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            if (i < lastFork) {
                service.submit(new MyThreadLockAll(i, lock));
            } else {
                service.submit(new MyThreadLockLast(lastFork, lock));
            }
        }
    }
}

class MyThreadLockLast implements Runnable {
    private int lastFork;
    private final Lock[] lock;

    MyThreadLockLast(int lastFork, Lock[] lock) {
        this.lastFork = lastFork;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock[0].lock();
            lock[lastFork].lock();
            System.out.println("Phylosoph number:" + lastFork + " eat");
            Sleep.sleepMillis(1000);

            lock[lastFork].unlock();
            lock[0].unlock();
            System.out.println("Phylosoph number:" + lastFork + " stop eating");
        }
    }
}

class MyThreadLockAll implements Runnable {
    private int number;
    private final Lock[] lock;

    MyThreadLockAll(int number, Lock[] lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock[number].lock();
            lock[number + 1].lock();
            System.out.println("Phylosoph number:" + number + " eat");
            Sleep.sleepMillis(1000);

            lock[number + 1].unlock();
            lock[number].unlock();
            System.out.println("Phylosoph number:" + number + " stop eating");
        }
    }
}

