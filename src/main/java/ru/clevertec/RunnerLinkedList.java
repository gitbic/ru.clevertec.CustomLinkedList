package ru.clevertec;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RunnerLinkedList {
    public static void main(String[] args) {
//        List<String> list = new CustomLinkedList<>();
//
//        for (int i = 0; i < 10; i++) {
//            list.add("element " + i);
//        }
//
//        System.out.println(list.toString());


        List<String> list = new ThreadSafeCustomLinkedList<>();

        for (int i = 0; i < 100000; i++) {
            list.add("Number: " + i);
        }

        Iterator<String> iterator = list.iterator();

        IteratorThread<String> thread1 = new IteratorThread<>("Thread 1", iterator);
        IteratorThread<String> thread2 = new IteratorThread<>("Thread 2", iterator);
        IteratorThread<String> thread3 = new IteratorThread<>("Thread 3", iterator);
        IteratorThread<String> thread4 = new IteratorThread<>("Thread 4", iterator);
        IteratorThread<String> thread5 = new IteratorThread<>("Thread 5", iterator);


        try {
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Element count: "
                + (thread1.count.get()
                + thread2.count.get()
                + thread3.count.get()
                + thread4.count.get()
                + thread5.count.get()));

    }
}
