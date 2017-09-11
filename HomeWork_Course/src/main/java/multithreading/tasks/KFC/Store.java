package multithreading.tasks.KFC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Свободная касса. В  ресторане быстрого обслуживания есть несколько
 касс. Посетители стоят в очереди в конкретную кассу, но могут перейти
 в другую очередь при уменьшении или исчезновении там очереди.
 */

public class Store {
    private CashDesk[] cashDesks;
    private int count = 1;
    private CashDesk minQueueCashDesk;

    public Store(int number) {
        cashDesks = new CashDesk[number];
        for(int i = 0; i<number; i++) {
            cashDesks[i] = new CashDesk(count++);
        }
    }

    public CashDesk[] getCashDesks() {
        return cashDesks;
    }

    public static void main(String[] args) throws InterruptedException {
        final int NUMBER_OF_CASHDESKS = 3;
        Store store = new Store(NUMBER_OF_CASHDESKS);
        AtomicInteger count = new AtomicInteger(0);

        ExecutorService serviceCustomers = Executors.newCachedThreadPool();
        for (CashDesk cashDesk : store.getCashDesks()) {
            new Thread(cashDesk).start();
        }

        while (true) {
            count.incrementAndGet();
            serviceCustomers.execute(new Customer(count,store));

            Thread.sleep(1000);
        }
    }

    public CashDesk getMinQueueCashDesk() {
        return minQueueCashDesk;
    }

}
