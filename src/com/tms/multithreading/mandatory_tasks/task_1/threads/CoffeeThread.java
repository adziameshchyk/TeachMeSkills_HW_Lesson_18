package com.tms.multithreading.mandatory_tasks.task_1.threads;

public class CoffeeThread extends Thread {

    @Override
    public void run() {
        System.out.println("Coffee preparation has started.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Coffee is ready.");

        System.out.println("Drink coffee.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Coffee is drunk.");
    }
}
