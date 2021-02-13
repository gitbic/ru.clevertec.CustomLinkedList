package ru.clevertec;

public class NewLinkedListThread <T> extends Thread{
    ThreadSafeCustomLinkedList<T> threadSafeCustomLinkedList;

    public NewLinkedListThread(String name, ThreadSafeCustomLinkedList<T> threadSafeCustomLinkedList) {
        super(name);
        this.threadSafeCustomLinkedList = threadSafeCustomLinkedList;
    }

    public boolean add(T t) {
        System.out.println(this.getName() + " write " + t);
        return threadSafeCustomLinkedList.add(t);
    }


}
