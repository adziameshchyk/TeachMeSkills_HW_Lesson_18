package com.tms.multithreading.very_dificult_tasks.task_3;

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
                throw new RuntimeException(e);
            }
        }
    }
}
