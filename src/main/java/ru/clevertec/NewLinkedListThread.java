package ru.clevertec;

import java.util.List;
import java.util.concurrent.Callable;

public class NewLinkedListThread <T> extends Thread{
    List<T> threadSafeCustomLinkedList;

    public NewLinkedListThread(String name, List<T> threadSafeCustomLinkedList) {
        super(name);
        this.threadSafeCustomLinkedList = threadSafeCustomLinkedList;
    }

    public List<T> getThreadSafeCustomLinkedList() {
        return threadSafeCustomLinkedList;
    }



    @Override
    public void run() {
        super.run();
    }
}
