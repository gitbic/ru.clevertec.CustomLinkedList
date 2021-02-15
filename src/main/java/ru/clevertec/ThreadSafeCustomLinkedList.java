package ru.clevertec;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static ru.clevertec.CustomLinkedList.UNSUPPORTED_OPERATION;

public class ThreadSafeCustomLinkedList<E> implements List<E> {

    private final List<E> customLinkedList;
    private final ReadWriteLock lock;

    public ThreadSafeCustomLinkedList() {
        customLinkedList = new CustomLinkedList<>();
        lock = new ReentrantReadWriteLock();
    }

    public ThreadSafeCustomLinkedList(List<E> customLinkedList, ReadWriteLock lock) {
        this.customLinkedList = customLinkedList;
        this.lock = lock;
    }

    public ThreadSafeCustomLinkedList(ReadWriteLock lock) {
        this.lock = lock;
        customLinkedList = new CustomLinkedList<>();
    }

    @Override
    public boolean add(E thisElement) {
        try {
            lock.writeLock().lock();
            return customLinkedList.add(thisElement);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void add(int index, E thisElement) {
        try {
            lock.writeLock().lock();
            customLinkedList.add(index, thisElement);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public E get(int index) {
        try {
            lock.readLock().lock();
            return customLinkedList.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E remove(int index) {
        try {
            lock.writeLock().lock();
            return customLinkedList.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public E set(int index, E element) {
        try {
            lock.writeLock().lock();
            return customLinkedList.set(index, element);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.readLock().lock();
            return customLinkedList.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void clear() {
        try {
            lock.writeLock().lock();
            customLinkedList.clear();
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public String toString() {
        try {
            lock.readLock().lock();
            return customLinkedList.toString();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public ListIterator<E> listIterator() {
        try {
            lock.writeLock().lock();
            return customLinkedList.listIterator();
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }
}
