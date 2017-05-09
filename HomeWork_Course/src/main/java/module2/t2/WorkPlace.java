package module2.t2;

import java.util.ArrayList;
import java.util.List;

public class WorkPlace {
    private List<Chancery> chanceryList = new ArrayList<>();
    private Employee employee;
    private double summChancery;

    WorkPlace(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Chancery> getChanceryList() {
        return chanceryList;
    }

    public void setChanceryList(List<Chancery> chanceryList) {
        this.chanceryList = chanceryList;
    }

    public void addChancery(Chancery chancery) {
        chanceryList.add(chancery);
    }

    public void removeChancery(Chancery chancery) {
        chanceryList.remove(chancery);
    }

    public void printChancery() {
        for (Chancery chancery : chanceryList) {
            System.out.println(chancery);
        }
    }

    public double calculateChancery() {
        for (Chancery chancery : chanceryList) {
            summChancery += chancery.getPrice();
        }
        return summChancery;
    }
}
