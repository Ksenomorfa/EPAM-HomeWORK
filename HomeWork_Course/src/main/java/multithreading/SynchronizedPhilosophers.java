package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedPhilosophers {
    public static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        Boolean[] mutex = new Boolean[NUMBER_OF_PHILOSOPHERS];
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            mutex[i] = Boolean.TRUE;
        }

        int lastFork = NUMBER_OF_PHILOSOPHERS - 1;

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            if (i < lastFork) {
                service.submit(new MyThreadSyncAll(i, mutex));
            } else {
                service.submit(new MyThreadSyncLast(lastFork, mutex));
            }
        }
    }
}

class MyThreadSyncLast implements Runnable {
    private int lastFork;
    private final Boolean[] forkFree;

    MyThreadSyncLast(int lastFork, Boolean[] forkFree) {
        this.lastFork = lastFork;
        this.forkFree = forkFree;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (forkFree[0]) {
                synchronized (forkFree[lastFork]) {
                    System.out.println("Phylosoph number:" + lastFork + " eat");
                    Sleep.sleepMillis(1000);
                    System.out.println("Phylosoph number:" + lastFork + " stop eating");
                }
            }
            Sleep.sleepMillis(1500);
        }
    }
}

class MyThreadSyncAll implements Runnable {
    private int number;
    private final Boolean[] forkFree;

    MyThreadSyncAll(int number, Boolean[] forkFree) {
        this.number = number;
        this.forkFree = forkFree;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (forkFree[number]) {
                synchronized (forkFree[number + 1]) {
                    System.out.println("Phylosoph number:" + number + " eat");
                    Sleep.sleepMillis(1000);
                    System.out.println("Phylosoph number:" + number + " stop eating");
                }
            }
            Sleep.sleepMillis(1500);
        }
    }
}


