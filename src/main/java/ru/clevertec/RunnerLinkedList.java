package ru.clevertec;

import java.util.LinkedList;
import java.util.List;

public class RunnerLinkedList {
    public static void main(String[] args) {
        List<String> list = new CustomLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add("element " + i);
        }

        System.out.println(list.toString());

////        ThreadSafeCustomLinkedList<Integer> list = new ThreadSafeCustomLinkedList<>();
//        NewLinkedListThread<Integer> thread1 = new NewLinkedListThread<>("Thread 1", list);
//        NewLinkedListThread<Integer> thread2 = new NewLinkedListThread<>("Thread 2", list);
//        NewLinkedListThread<Integer> thread3 = new NewLinkedListThread<>("Thread 3", list);
//
//        for (int i = 0; i < 1000; i++) {
//
//        }
        

    }
}
