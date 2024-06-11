package com.tms.multithreading.mandatory_tasks.task_1.threads;

public class BreakfastThread extends Thread {

    @Override
    public void run() {
        System.out.println("Breakfast preparation has begun.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Breakfast is ready.");

        System.out.println("Eating breakfast.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished eating.");
    }
}
