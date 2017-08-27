package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphorePhilosophers {
    public static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        Semaphore[] semaphores = new Semaphore[NUMBER_OF_PHILOSOPHERS];

        int lastFork = semaphores.length - 1;

        for (int i = 0; i < semaphores.length; i++) {
            semaphores[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            if (i < lastFork) {
                service.submit(new MyThreadAll(i, semaphores));
            } else {
                service.submit(new MyThreadLast(lastFork, semaphores));
            }
        }
    }
}

class MyThreadLast implements Runnable {
    private int lastFork;
    private Semaphore[] semaphores;

    public MyThreadLast(int lastFork, Semaphore[] semaphores) {
        this.lastFork = lastFork;
        this.semaphores = semaphores;
    }

    @Override
    public void run() {
        while(true) {
            try {
                semaphores[0].acquire(1);
                semaphores[lastFork].acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Phylosoph number:" + lastFork + " eat");

            Sleep.sleepMillis(2000);
            semaphores[lastFork].release();
            semaphores[0].release();
            System.out.println("Phylosoph number:" + lastFork + " stop eating");

        }
    }
}
class MyThreadAll implements Runnable {
    private int number;
    private Semaphore[] semaphores;

    public MyThreadAll(int number, Semaphore[] semaphores) {
        this.number = number;
        this.semaphores = semaphores;
    }

    @Override
    public void run() {
        while (true) {
            int nextFork = number + 1;
            try {
                semaphores[number].acquire(1);
                semaphores[nextFork].acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Phylosoph number:" + number + " eat");

            Sleep.sleepMillis(2000);

            semaphores[number + 1].release();
            semaphores[number].release();
            System.out.println("Phylosoph number:" + number + " stop eating");

        }
    }
}