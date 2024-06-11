package com.tms.multithreading.mandatory_tasks.task_1.threads;

public class NewsThread extends Thread {

    @Override
    public void run() {
        System.out.println("Reading the news has begun.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("News reading completed.");
    }

}
