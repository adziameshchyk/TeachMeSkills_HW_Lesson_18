package com.tms.multithreading.very_dificult_tasks.task_3;

public class ConsumerThread extends Thread {

    private BoundedBuffer buffer;

    public ConsumerThread(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int item = (int) buffer.remove();
            System.out.println("Consumer: " + item);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
