package multithreading.tasks.autoplaces;

public class Car implements Runnable {
    private final int waitTime;
    private final int parkedTime;
    private final int startTime;
    private final AutoStation autoStation;
    private static int threadQuantity = 0;
    private int id = ++threadQuantity;


    public Car(final AutoStation autoStation, final int waitTime, final int startTime, final int parkedTime) {
        this.autoStation = autoStation;
        this.startTime = startTime;
        this.waitTime = waitTime;
        this.parkedTime = parkedTime;
    }

    @Override
    public void run() {
        try {
            wait(startTime);
            boolean isAccepted = autoStation.accept(this);
            if (isAccepted) {
                wait(parkedTime);
                autoStation.release(this);
            } else {
                System.out.println(this + " can't wait more and leave.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 10);
    }

    public int getWaitTime() {
        return waitTime;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + "}";
    }
}
