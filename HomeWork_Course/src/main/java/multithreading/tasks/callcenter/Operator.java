package multithreading.tasks.callcenter;

import multithreading.Sleep;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Operator implements Runnable {
    private int id;
    private Semaphore semaphore;
    private Organization org;
    private int minTimeToServe;

    public Operator(int id, Organization org) {
        this.id = id;
        this.org = org;
        semaphore = new Semaphore(1);
        minTimeToServe = 500;
    }

    @Override
    public void run() {
        Client client = null;
        semaphore.acquireUninterruptibly();
        try {
            client = org.getClients().take();
            System.out.println("Operator " + id + " serves client " + client.getId());
            client.setServed(true);
            Sleep.sleepMillis(new Random().nextInt(2000) + minTimeToServe);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Operator " + id + " ends serving client " + client.getId());
        }
    }

    public int getId() {
        return id;
    }
}
