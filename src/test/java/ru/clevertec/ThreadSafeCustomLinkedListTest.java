package ru.clevertec;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadSafeCustomLinkedListTest {
    List<String> list;
    private static final int LIST_SIZE = 100000;

    @BeforeEach
    public void createNewList() {
        list = new ThreadSafeCustomLinkedList<>();
    }

    @AfterEach
    public void clearList() {
        list = null;
    }

    @Test
    public void testListIteratorGetElements() {
        fillList();

        Iterator<String> iterator = list.iterator();

        IteratorThread<String> thread1 = new IteratorThread<>("Thread 1", iterator);
        IteratorThread<String> thread2 = new IteratorThread<>("Thread 2", iterator);
        IteratorThread<String> thread3 = new IteratorThread<>("Thread 3", iterator);
        IteratorThread<String> thread4 = new IteratorThread<>("Thread 4", iterator);
        IteratorThread<String> thread5 = new IteratorThread<>("Thread 5", iterator);

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

        int count = thread1.count.get()
                + thread2.count.get()
                + thread3.count.get()
                + thread4.count.get()
                + thread5.count.get();

        assertEquals(count, LIST_SIZE);
    }

    private void fillList() {
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add("Number: " + i);
        }
    }
}
