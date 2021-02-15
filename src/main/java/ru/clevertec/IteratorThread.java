package ru.clevertec;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class IteratorThread<T> extends Thread {
    AtomicInteger count = new AtomicInteger(0);
    Iterator<T> iterator;

    public IteratorThread(String name, Iterator<T> iterator) {
        super(name);
        this.iterator = iterator;
    }

    @Override
    public void run() {
        T element = null;
        while (iterator.hasNext()) {
            element = iterator.next();
//            System.out.println(getName() + " " + element);
            count.getAndAdd(1);
        }
        System.out.println(this.getName() + " "+ count);
    }
}

