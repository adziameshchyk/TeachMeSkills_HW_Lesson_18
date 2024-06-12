package com.tms.multithreading.very_dificult_tasks.task_4;

import com.tms.multithreading.very_dificult_tasks.task_3.BoundedBuffer;
import com.tms.multithreading.very_dificult_tasks.task_3.ConsumerThread;
import com.tms.multithreading.very_dificult_tasks.task_3.ProducerThread;

/**
 * Task:
 *
 * Write a multiple-threads bounded buffer using synchronized.
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
