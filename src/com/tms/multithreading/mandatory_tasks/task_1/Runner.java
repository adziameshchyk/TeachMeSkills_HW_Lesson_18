package com.tms.multithreading.mandatory_tasks.task_1;

import com.tms.multithreading.mandatory_tasks.task_1.threads.BreakfastThread;
import com.tms.multithreading.mandatory_tasks.task_1.threads.CoffeeThread;
import com.tms.multithreading.mandatory_tasks.task_1.threads.NewsThread;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Task:
 *
 * Create a program that simulates morning: reading the news, tomorrow, coffee.
 * Give each thread a name and priority from the config file.
 * Let the name and priority of the thread be specified through the properties file.
 * Let there be 3 threads.
 * Create and run 3 threads
 */
public class Runner {

    private static final String PROPERTIES_PATH = "src/com/tms/multithreading/mandatory_tasks/task_1/resource/config.properties";

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(PROPERTIES_PATH)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread coffeeThread = new CoffeeThread();
        coffeeThread.setName(properties.getProperty("coffeeThread.name"));
        coffeeThread.setPriority(Integer.parseInt(properties.getProperty("coffeeThread.priority")));

        Thread breakfastThread = new BreakfastThread();
        breakfastThread.setName(properties.getProperty("breakfastThread.name"));
        breakfastThread.setPriority(Integer.parseInt(properties.getProperty("breakfastThread.priority")));

        Thread newsThread = new NewsThread();
        newsThread.setName(properties.getProperty("newsThread.name"));
        newsThread.setPriority(Integer.parseInt(properties.getProperty("newsThread.priority")));

        coffeeThread.start();
        breakfastThread.start();

        try {
            coffeeThread.join();
            breakfastThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        newsThread.start();

    }

}
