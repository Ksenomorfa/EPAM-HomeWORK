package multithreading.tasks.callcenter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Organization implements Runnable {
    private Operator[] operators;
    private BlockingQueue<Client> clients;

    public Organization(int operatorsQuantity) {
        this.operators = new Operator[operatorsQuantity];
        this.clients = new ArrayBlockingQueue<>(Integer.MAX_VALUE / 100);
        for (int i = 0; i < operatorsQuantity; i++) {
            operators[i] = new Operator(i, this);
        }
    }

    public Operator[] getOperators() {
        return operators;
    }

    public BlockingQueue<Client> getClients() {
        return clients;
    }


    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(operators.length);
        for (Operator operator : operators) {
            service.execute(operator);
        }
    }
}
