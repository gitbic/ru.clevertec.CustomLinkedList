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


//        List<String> syncList = new ThreadSafeCustomLinkedList<>();
//        StringBuffer sb = new StringBuffer();
//
//        for (int i = 0; i < 100; i++) {
//            syncList.add("Number: " + i);
//        }
//
//        Runnable listOperations = () -> {
//            synchronized (syncList) {
//                syncList.forEach((e) ->
//                        sb.append(e).append("\n"));
//            }
//        };
//
//        listOperations.run();
//        System.out.println(sb);

        ReadWriteLock lock = new ReentrantReadWriteLock();
        List<String> list = new ThreadSafeCustomLinkedList<>(lock);


        for (int i = 0; i < 100000; i++) {
            list.add("Number: " + i);
        }

        Iterator<String> iterator = list.iterator();

//        Thread thread1 = new NewLinkedListThread<String>("Thread 1", list);
//        Thread thread2 = new NewLinkedListThread<String>("Thread 2", list);

        ThreadTest<String> thread1 = new ThreadTest<>("Thread 1", iterator);
        ThreadTest<String> thread2 = new ThreadTest<>("Thread 2", iterator);
        ThreadTest<String> thread3 = new ThreadTest<>("Thread 3", iterator);
        ThreadTest<String> thread4 = new ThreadTest<>("Thread 4", iterator);
        ThreadTest<String> thread5 = new ThreadTest<>("Thread 5", iterator);


        try {
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(thread1.count.get()
                + thread2.count.get()
                + thread3.count.get()
                + thread4.count.get()
                + thread5.count.get());
    }
}
