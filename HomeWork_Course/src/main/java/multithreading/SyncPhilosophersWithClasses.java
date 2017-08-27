package multithreading;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncPhilosophersWithClasses {
    public static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        int firstFork = 0;
        int lastFork = NUMBER_OF_PHILOSOPHERS - 1;
        Fork[] mutex = new Fork[NUMBER_OF_PHILOSOPHERS];

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            mutex[i] = new Fork(i);
        }
        System.out.println(Arrays.asList(mutex));

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            if (i < lastFork) {
                service.submit(new Philosopher(i, i, i + 1, mutex));
            } else {
                service.submit(new Philosopher(lastFork, lastFork, firstFork, mutex));
            }
        }
    }
}

class Philosopher implements Runnable {
    private final int pos;
    private final int leftFork;
    private final int rightFork;
    private final Fork[] mutex;

    Philosopher(int pos, int leftFork, int rightFork, Fork[] mutex) {
        this.pos = pos;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (mutex[leftFork]) {
            synchronized (mutex[rightFork]) {
                System.out.println("Phylosoph number: " + pos + " eating " + Thread.currentThread());
                Sleep.sleepMillis(2000);
                System.out.println("Phylosoph number: " + pos + " thinking");
            }
        }
        Sleep.sleepMillis(1000);
    }
}

class Fork {
    private int pos;

    Fork(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return String.valueOf(pos);
    }
}
