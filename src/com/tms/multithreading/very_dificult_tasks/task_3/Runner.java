package com.tms.multithreading.very_dificult_tasks.task_3;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(10);

        Thread producer = new ProducerThread(buffer);
        Thread consumer = new ConsumerThread(buffer);

        producer.start();
        consumer.start();
    }

}
