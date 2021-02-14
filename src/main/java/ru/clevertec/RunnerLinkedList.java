package ru.clevertec;

import java.util.*;
import java.util.concurrent.Callable;

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

        List<String> list = new ThreadSafeCustomLinkedList<>();

        for (int i = 0; i < 1000; i++) {
            list.add("Number: " + i);
        }

        Thread thread1 = new NewLinkedListThread<String>("Thread 1", list);
        Thread thread2 = new NewLinkedListThread<String>("Thread 2", list);

        try {
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
