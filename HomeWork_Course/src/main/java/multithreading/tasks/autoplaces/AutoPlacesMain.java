package multithreading.tasks.autoplaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoPlacesMain {

    public static void main(String[] args) {
        int carsQuantity = 50;
        int stationLimit = 3;
        AutoStation autoStation = new AutoStation(stationLimit);
        List<Car> carList = createCars(carsQuantity, autoStation);
        waitCars(carList);

    }

    private static void waitCars(List<Car> cars) {
        for (Car car : cars) {
            Thread thread = new Thread(car);
            thread.start();
        }
    }

    private static List<Car> createCars(int carsQuantity, AutoStation autoStation) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carsQuantity; i++) {
            int startTime = (new Random().nextInt(15));
            int waitTime = (new Random().nextInt(4));
            int parkTime = (new Random().nextInt(40));
            carList.add(new Car(autoStation, waitTime, startTime, parkTime));
        }
        return carList;
    }
}
