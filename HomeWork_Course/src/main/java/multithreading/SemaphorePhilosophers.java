package multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphorePhilosophers {
    public static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        Semaphore[] semaphores = new Semaphore[NUMBER_OF_PHILOSOPHERS];

        for (int i = 0; i < semaphores.length; i++) {
            semaphores[i] = new Semaphore(1);
        }

        while (true) {
            int i = new Random().nextInt(5);
            int firstFork = 0;
            int lastFork = semaphores.length - 1;
            if (i < lastFork) {
                semaphores[i].acquire(1);
                System.out.println("Phylosoph number:" + i + " put fork:" + i + " up");
                int nextFork = i + 1;
                semaphores[nextFork].acquire(1);
                System.out.println("Phylosoph number:" + i + " put fork:" + nextFork + " up");

                service.submit(() -> {
                    System.out.println("Phylosoph number:" + i + " eat");
                    sleepMillis(new Random().nextInt(10000));

                    semaphores[i + 1].release();
                    System.out.println("Phylosoph number:" + i + " put fork:" + (i + 1) + " down");
                    semaphores[i].release();
                    System.out.println("Phylosoph number:" + i + " put fork:" + i + " down");

                    System.out.println("Phylosoph number:" + i + " stop eating");
                });
            } else {
                semaphores[firstFork].acquire(1);
                System.out.println("Phylosoph number:" + i + " put fork:" + firstFork + " up");
                semaphores[lastFork].acquire(1);
                System.out.println("Phylosoph number:" + i + " put fork:" + lastFork + " up");

                service.submit(() -> {
                    System.out.println("Phylosoph number:" + i + " eat");
                    sleepMillis(new Random().nextInt(10000));

                    semaphores[lastFork].release();
                    System.out.println("Phylosoph number:" + i + " put fork:" + lastFork + " down");
                    semaphores[firstFork].release();
                    System.out.println("Phylosoph number:" + i + " put fork:" + firstFork + " down");

                    System.out.println("Phylosoph number:" + i + " stop eating");
                });
            }
        }
    }

    static private void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
