package com.tms.multithreading.extra_credit_tasks.task_2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Task:
 *
 * There is a service station. A service station can have a maximum of a certain number of cars in service.
 * Create a class that will run in a separate thread and will add cars for service at the service station.
 * Create a class that will run in a separate thread and will pick up fixed cars from the service station.
 * Let the maximum number of machines available for service be specified through the properties file.
 * Use synchronized, wait, notify.
 */
public class Runner {

    private static final String PROPERTIES_PATH = "src/com/tms/multithreading/extra_credit_tasks/task_2/resource/config.properties";

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(PROPERTIES_PATH)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file.", e);
        }

        int maxNumberOfCars = Integer.parseInt(properties.getProperty("maxNumberOfCars"));
        ServiceStation serviceStation = new ServiceStation(maxNumberOfCars);

        Thread carAdder = new CarAdderThread(serviceStation);
        Thread carRemover = new CarRemoverThread(serviceStation);

        carAdder.start();
        carRemover.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        carAdder.interrupt();
        try {
            carAdder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cars are no longer accepted at service stations.");

        synchronized (serviceStation) {
            while (serviceStation.getCurrentNumberOfCars() != 0) {
                try {
                    serviceStation.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        carRemover.interrupt();
        try {
            carRemover.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All cars are repaired.");
    }

}
