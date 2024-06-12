package com.tms.multithreading.extra_credit_tasks.task_2;

public class CarRemoverThread extends Thread {

    private ServiceStation serviceStation;

    public CarRemoverThread(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            serviceStation.removeCar();
        }
    }

}