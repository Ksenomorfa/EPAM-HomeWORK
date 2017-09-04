package multithreading.tasks.callcenter;

import multithreading.Sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CallCenterMain {

    public static void main(String[] args) {
        final int numberOfOperators = 5;

        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService serviceClients = Executors.newCachedThreadPool();
        ExecutorService serviceOrg = Executors.newSingleThreadExecutor();

        Organization org = new Organization(numberOfOperators);

        while (true) {
            serviceOrg.execute(org);
            Client client = new Client(counter.incrementAndGet(), org);
            serviceClients.execute(client);
            Sleep.sleepMillis(100);
        }
    }
}
