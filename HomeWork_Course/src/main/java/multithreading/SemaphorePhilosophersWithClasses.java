package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphorePhilosophersWithClasses {
    public static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        Semaphore[] semaphores = new Semaphore[NUMBER_OF_PHILOSOPHERS];

        int firstFork = 0;
        int lastFork = NUMBER_OF_PHILOSOPHERS - 1;
        for (int i = 0; i < semaphores.length; i++) {
            semaphores[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            if (i < lastFork) {
                service.submit(new PhilosopherSem(i, i, i + 1, semaphores));
            } else {
                service.submit(new PhilosopherSem(lastFork, lastFork, firstFork, semaphores));
            }
        }
    }
}

class PhilosopherSem implements Runnable {
    private final int pos;
    private final int leftFork;
    private final int rightFork;
    private final Semaphore[] sems;

    PhilosopherSem(int pos, int leftFork, int rightFork, Semaphore[] sems) {
        this.pos = pos;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.sems = sems;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        sems[leftFork].acquireUninterruptibly(1);
        sems[rightFork].acquireUninterruptibly(1);
        System.out.println("Phylosoph number: " + pos + " put up left fork " + leftFork);
        System.out.println("Phylosoph number: " + pos + " put up right fork " + rightFork);
        System.out.println("Phylosoph number: " + pos + " eating ");
        Sleep.sleepMillis(2000);

        sems[rightFork].release();
        sems[leftFork].release();
        System.out.println("Phylosoph number: " + pos + " put off right fork " + rightFork);
        System.out.println("Phylosoph number: " + pos + " put off left fork " + leftFork);
        System.out.println("Phylosoph number: " + pos + " thinking");
        Sleep.sleepMillis(1000);
    }
}

class ForkSem {
    private int pos;

    ForkSem(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return String.valueOf(pos);
    }
}
