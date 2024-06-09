package com.tms.multithreading.mandatory_tasks.task_0;

/**
 * Task:
 *
 * Create three streams T1, T2 and T3
 * Implement the execution of the flow in the sequence T3 -> T2 -> T1
 * (using join method)
 */

public class Runner {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread.currentThread().setName("T1");
            System.out.println(Thread.currentThread().getName() + " is running.");
        });

        Thread t2 = new Thread(() -> {
            Thread.currentThread().setName("T2");
            System.out.println(Thread.currentThread().getName() + " is running.");
        });

        Thread t3 = new Thread(() -> {
            Thread.currentThread().setName("T3");
            System.out.println(Thread.currentThread().getName() + " is running.");
        });


        try {
            t3.start();
            t3.join();

            t2.start();
            t2.join();

            t1.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
