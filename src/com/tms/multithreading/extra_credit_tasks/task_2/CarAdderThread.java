package com.tms.multithreading.extra_credit_tasks.task_2;

public class CarAdderThread extends Thread {

    private ServiceStation serviceStation;

    public CarAdderThread(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            serviceStation.addCar();
        }
    }
}