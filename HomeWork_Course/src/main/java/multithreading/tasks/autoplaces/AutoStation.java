package multithreading.tasks.autoplaces;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoStation {
    private AtomicInteger currentCapacity;
    private List<Car> parkedCars = new CopyOnWriteArrayList<>();
    Semaphore semaphore;
    volatile boolean enoughPlaces;

    public AutoStation(int MAX_CAPACITY) {
        this.currentCapacity = new AtomicInteger(MAX_CAPACITY);
        this.semaphore = new Semaphore(MAX_CAPACITY);
    }

    public boolean accept(Car car) throws InterruptedException {
        enoughPlaces = semaphore.tryAcquire(1, car.getWaitTime(), TimeUnit.SECONDS);
        if (enoughPlaces) {
            currentCapacity.decrementAndGet();
            System.out.println(car + " parked. Current capacity of station:" + getCurrentCapacity());
            parkedCars.add(car);
            return true;
        } else return false;
    }

    public void release(Car car) {
        if (parkedCars.contains(car)) {
            currentCapacity.incrementAndGet();
            System.out.println(car + " leave. Current capacity of station:" + getCurrentCapacity());
            parkedCars.remove(car);
            semaphore.release();
        }
    }

    public synchronized AtomicInteger getCurrentCapacity() {
        return currentCapacity;
    }

}
