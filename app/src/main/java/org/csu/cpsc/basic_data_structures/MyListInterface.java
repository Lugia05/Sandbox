package org.csu.cpsc

public interface MyListInterface<E>{
    void add(int index, E element);
    boolean add(E element);

    E get(int index);

    int size();

}