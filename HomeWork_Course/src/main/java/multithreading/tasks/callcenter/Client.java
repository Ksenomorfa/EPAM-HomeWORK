package multithreading.tasks.callcenter;

import multithreading.Sleep;

import java.util.Random;

public class Client implements Runnable {
    private final int id;
    private final Organization org;
    private volatile boolean isServed;
    private int waitTime;

    public Client(int id, Organization org) {
        this.id = id;
        this.isServed = false;
        this.org = org;
        this.waitTime = new Random().nextInt(10000);
    }

    @Override
    public void run() {
        call();
        Sleep.sleepMillis(waitTime);
        boolean isPutOffCall = false;
        while (!isServed) {
            isPutOffCall = new Random().nextBoolean();
            if (isPutOffCall) {
                putOffCall();
                System.out.println("Client " + id + " is tired and put off call.");
                break;
            }
        }
        if (!isServed && isPutOffCall) {
            boolean isCalledAgain = new Random().nextBoolean();
            if (isCalledAgain) {
                System.out.println("Client " + id + " is called again.");
                call();
            }
        }

    }

    private void call() {
        System.out.println("Client " + id + " call.");
        org.addClient(this);
        System.out.println("Client " + id + " added to queue.");
    }

    private void putOffCall() {
        org.removeClient(this);
    }

    public int getId() {
        return id;
    }

    public boolean isServed() {
        return isServed;
    }
    public void setServed(boolean served) {
        isServed = served;
    }

    public Organization getOrg() {
        return org;
    }


}
