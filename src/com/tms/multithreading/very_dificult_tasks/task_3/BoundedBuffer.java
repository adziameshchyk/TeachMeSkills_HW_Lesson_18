package com.tms.multithreading.very_dificult_tasks.task_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BoundedBuffer<T> {

    private final Lock locker;
    private final Condition notEmpty;
    private final Condition notFull;
    private final Queue<T> buffer = new LinkedList<>();
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        this.locker = new ReentrantLock();
        this.notEmpty = locker.newCondition();
        this.notFull = locker.newCondition();
    }

    public void add(T item) {
        locker.lock();
        try {
            while (buffer.size() == capacity) {
                notFull.await();
            }
            buffer.add(item);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public T remove() {
        locker.lock();
        try {
            while (buffer.isEmpty()) {
                notEmpty.await();
            }
            T item = buffer.poll();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

}
