package multithreading.tasks.port;

import multithreading.Sleep;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PortMain {
    private volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        int NUMBER_OF_DOCKS = 5;
        Port port = new Port(NUMBER_OF_DOCKS, 100);

        while (true) {
            count++;
            int capacity = new Random().nextInt(20) + 1;
            int maxCapacity = capacity + new Random().nextInt(20);
            int toLoad = new Random().nextInt(20) + 1;
            Ship ship = new Ship(count, capacity, toLoad, maxCapacity, port);
            new Thread(ship).start();
            Sleep.sleepMillis(new Random().nextInt(100));
        }
    }

    private static class Port {
        private AtomicInteger currentCapacity;
        static final int MAX_GOODS = 200;
        Semaphore semaphore;

        public Port(int numberOfDocks, int capacity) {
            this.currentCapacity = new AtomicInteger(capacity);
            this.semaphore = new Semaphore(numberOfDocks);
        }

        public boolean loadGoods(int goods) {
            if (goods + currentCapacity.intValue() <= MAX_GOODS) {
                currentCapacity.addAndGet(goods);
                System.out.println("В порту " + currentCapacity);
                return true;
            } else {
                System.out.println("Cannot load more than max in port");
            }
            return false;
        }

        public boolean unloadGoods(int goods) {
            if (currentCapacity.intValue() - goods > 0) {
                currentCapacity.addAndGet(-goods);
                System.out.println("В порту " + currentCapacity);
                return true;
            } else {
                System.out.println("Not enough goods in port");
            }
            return false;
        }

        public synchronized boolean hasGoods(int goods) {
            if (currentCapacity.intValue() >= goods) {
                return true;
            }
            return false;
        }

        public void dock(Ship ship) {

            semaphore.acquireUninterruptibly(1);
            System.out.println("Корабль №" + ship.id + " подошел к причалу, осталось: " + semaphore.availablePermits());
        }

        public void unDock(Ship ship) {
            semaphore.release(1);
            System.out.println("Корабль №" + ship.id + " отошел от причала, осталось: " + semaphore.availablePermits());
        }

    }

    private static class Ship implements Runnable {
        private int capacity;
        private int MAX_CAPACITY;
        private Port port;
        private int id;
        private int toLoad;
        final Lock lock = new ReentrantLock();

        public Ship(int id, int capacity, int toLoad, int maxCapacity, Port port) {
            this.id = id;
            this.capacity = capacity;
            this.port = port;
            this.MAX_CAPACITY = maxCapacity;
            if (toLoad > MAX_CAPACITY) {
                this.toLoad = MAX_CAPACITY;
            } else {
                this.toLoad = toLoad;
            }
        }

        @Override
        public void run() {
            port.dock(this);

            goodsUnload(capacity);
            Sleep.sleepMillis(1000);

            goodsLoad(toLoad);
            Sleep.sleepMillis(1000);

            port.unDock(this);
        }

        public void goodsUnload(int goods) {
            if (goods <= capacity) {
                boolean enoughPlace = port.loadGoods(goods);
                if (enoughPlace) {
                    this.capacity = capacity - goods;
                    System.out.println("Загружено в порт с корабля №" + id + " : " + goods + ". На борту: " + capacity);
                }
            } else {
                System.out.println("cannot unload more then have on board on №" + id);
            }

        }

        public void goodsLoad(int goods) {
            if (!port.hasGoods(goods)) {
                System.out.println("Goods in port null.");
                return;
            }
            if (capacity + goods <= MAX_CAPACITY) {
                boolean enoughPlace = port.unloadGoods(goods);
                if (enoughPlace) {
                    this.capacity = capacity + goods;
                    System.out.println("Загружено в корабль №" + id + " товаров: " + goods + ". На борту: " + capacity);
                }
            } else {
                System.out.println("cannot load more then max currentCapacity on board №" + id);
            }
        }
    }
}