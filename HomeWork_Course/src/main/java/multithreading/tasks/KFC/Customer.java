package multithreading.tasks.KFC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Runnable {

    private AtomicInteger id;
    private Store store;
    private CashDesk cashDesk;
    private boolean isBeingServed;
    private boolean isServed;
    private Lock lock;

    public Customer(AtomicInteger id, Store store) {
        this.id = id;
        this.store = store;
        this.lock = new ReentrantLock();
    }

    public AtomicInteger getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    @Override
    public void run() {
        System.out.println("Customer " + id + " comes to store.");
        try {
            if (!tryEnterQueue(chooseCashDesk())) {
                System.out.println("Customer " + id +
                        " couldn't enqueue to the cashDesk#" + cashDesk.getId());
                return;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer " + id +
                " chosen the cashDesk#" + cashDesk.getId());

        while (true) {
            lock.lock();
            boolean finishLoop = isBeingServed;
            lock.unlock();
            if (finishLoop)
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                switchToBetterCashDeskIfPossible();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cashDesk == null)
                break;
        }

        while (true) {
            lock.lock();
            boolean finishLoop = isServed;
            lock.unlock();
            if (finishLoop)
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Customer " + id + " is eating");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer " + id + " leaves restaurant");
    }

    public boolean startServe(CashDesk cashDesk) throws InterruptedException {
        lock.lock();
        try {
            if (cashDesk != this.cashDesk) {
                return false;
            }
            if (isServed) {
                throw new InterruptedException();
            }
            isBeingServed = true;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void finishServe() throws InterruptedException {
        lock.lock();
        try {
            if (!isBeingServed) {
                throw new InterruptedException();
            }
            isBeingServed = false;
            isServed = true;
        } finally {
            lock.unlock();
        }
    }

    private CashDesk chooseCashDesk() {
        CashDesk result = store.getCashDesks()[0];
        for (CashDesk cashDesk : store.getCashDesks()) {
            if (cashDesk.getQueueOfCustomers().size() < result.getQueueOfCustomers().size()) {
                result = cashDesk;
            }
        }
        return result;
    }

    private void switchToBetterCashDeskIfPossible() throws InterruptedException {
        lock.lock();
        boolean skipSwitch = isBeingServed;
        lock.unlock();
        if (skipSwitch)
            return;
        CashDesk result = chooseCashDesk();
        if (result == cashDesk)
            return;
        cashDesk.removeFromQueue(this);

        if (tryEnterQueue(cashDesk)) {
            System.out.println("Client " + id + " moved to cashDesk#" + cashDesk.getId());
        }
    }

    private boolean tryEnterQueue(CashDesk cashDesk) throws InterruptedException {
        try {
            cashDesk.addToQueue(this);
            this.cashDesk = cashDesk;
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
