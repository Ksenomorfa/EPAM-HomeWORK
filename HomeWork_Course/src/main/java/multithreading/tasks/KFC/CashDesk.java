package multithreading.tasks.KFC;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CashDesk implements Runnable {
    private int id;
    public static final int CAPACITY_OF_QUEUE = 5;
    private BlockingQueue<Customer> queueOfCustomers;
    private AtomicInteger currentCustomers;
    private Lock lock;
    private boolean isShutdownRequested;

    public CashDesk(int id) {
        this.currentCustomers = new AtomicInteger(0);
        this.queueOfCustomers = new ArrayBlockingQueue<>(CAPACITY_OF_QUEUE);
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public void addToQueue(Customer customer) throws InterruptedException {
        if (isShutdownRequested)
            throw new InterruptedException("очередь больше не принимает");
        queueOfCustomers.add(customer);
    }

    public void serveClient(Customer customer) throws InterruptedException {
        System.out.println("Customer " + customer.getId() +
                " is serving on cashDesk#" + id);
        if (!customer.startServe(this))
            // пока мы начинали, клиент уже мог сбежать из очереди
            // если так, ничего больше не делаем
            return;
        Thread.sleep(new Random().nextInt(2000));
        customer.finishServe();
        System.out.println("Customer " + customer.getId() + " is served");
    }

    public BlockingQueue<Customer> getQueueOfCustomers() {
        return queueOfCustomers;
    }

    public int getId() {
        return id;
    }

    public void removeFromQueue(Customer customer) {
        queueOfCustomers.remove(customer);

    }

    @Override
    public void run() {
        while (true) {
            Customer client = null;
            try {
                lock.lock();
                if (isShutdownRequested)
                    break;
                if (queueOfCustomers.size() > 0)
                    client = queueOfCustomers.peek();
            } finally {
                lock.unlock();
            }
            if (client == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            try {
                serveClient(client);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
