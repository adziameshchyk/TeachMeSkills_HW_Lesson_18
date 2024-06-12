package com.tms.multithreading.extra_credit_tasks.task_2;

public class ServiceStation {

    private final int maxNumberOfCars;
    private int currentNumberOfCars;

    public ServiceStation(int maxNumberOfCars) {
        this.maxNumberOfCars = maxNumberOfCars;
    }

    public int getCurrentNumberOfCars() {
        return currentNumberOfCars;
    }

    public synchronized void addCar() {
        while (currentNumberOfCars >= maxNumberOfCars) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        currentNumberOfCars++;
        System.out.println("New car added. Cars in service: " + currentNumberOfCars);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        notifyAll();
    }

    public synchronized void removeCar() {
        while (currentNumberOfCars == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        currentNumberOfCars--;
        System.out.println("The car is fixed. Cars in service: " + currentNumberOfCars);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        notifyAll();
    }

}