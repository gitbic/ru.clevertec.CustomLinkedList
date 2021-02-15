package ru.clevertec;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadTest<T> extends Thread {
    AtomicInteger count = new AtomicInteger(0);
    Iterator<T> iterator;

    public ThreadTest(String name, Iterator<T> iterator) {
        super(name);
        this.iterator = iterator;
    }

    @Override
    public synchronized void run() {
        T element = null;
        while (iterator.hasNext()) {
            element = iterator.next();
//            System.out.println(getName() + " " + element);
            count.getAndAdd(1);
        }
        System.out.println(this.getName() + " "+ count);
    }
}

