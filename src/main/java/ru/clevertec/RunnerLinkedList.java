package ru.clevertec;

import org.gradle.internal.impldep.it.unimi.dsi.fastutil.ints.IntSets;

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


        ReadWriteLock lock = new ReentrantReadWriteLock();
        List<String> list = new ThreadSafeCustomLinkedList<>(lock);
        Set<String> set = new HashSet<>();
        Set<String> synset = Collections.synchronizedSet(set);



        for (int i = 0; i < 100000; i++) {
            list.add("Number: " + i);
        }

        Iterator<String> iterator = list.iterator();

        ThreadTest<String> thread1 = new ThreadTest<>("Thread 1", iterator, synset);
        ThreadTest<String> thread2 = new ThreadTest<>("Thread 2", iterator, synset);
        ThreadTest<String> thread3 = new ThreadTest<>("Thread 3", iterator, synset);
        ThreadTest<String> thread4 = new ThreadTest<>("Thread 4", iterator, synset);
        ThreadTest<String> thread5 = new ThreadTest<>("Thread 5", iterator, synset);


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

        System.out.println("Set size: " + set.size());

        System.out.println(set.contains(null));
    }
}
