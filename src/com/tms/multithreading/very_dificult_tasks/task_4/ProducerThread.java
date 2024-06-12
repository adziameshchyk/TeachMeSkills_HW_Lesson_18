package com.tms.multithreading.very_dificult_tasks.task_4;

import com.tms.multithreading.very_dificult_tasks.task_3.BoundedBuffer;

public class ProducerThread extends Thread {
    private BoundedBuffer<Integer> buffer;
    private int item = 0;

    public ProducerThread(BoundedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.add(item++);
            System.out.println("Producer: " + item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
