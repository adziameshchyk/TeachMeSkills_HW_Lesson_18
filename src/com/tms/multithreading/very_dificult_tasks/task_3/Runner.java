package com.tms.multithreading.very_dificult_tasks.task_3;

/**
 * Task:
 *
 * Write a multiple-threads bounded buffer using ReentrantLock.
 */

public class Runner {

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(10);

        Thread producer = new ProducerThread(buffer);
        Thread consumer = new ConsumerThread(buffer);

        producer.start();
        consumer.start();
    }

}
