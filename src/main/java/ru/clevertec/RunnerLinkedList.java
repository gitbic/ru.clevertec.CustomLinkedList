package ru.clevertec;

public class RunnerLinkedList {
    public static void main(String[] args) {
        NewLinkedList<String> list = new NewLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add("element " + i);
        }

        System.out.println(list.toString());
    }
}
