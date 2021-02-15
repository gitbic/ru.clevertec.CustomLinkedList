package ru.clevertec;

import java.util.List;

public class RunnerLinkedList {
    public static void main(String[] args) {
        List<String> list = new CustomLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add("element " + i);
        }

        System.out.println(list.toString());


    }

}
