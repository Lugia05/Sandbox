package org.csu.cpsc

public interface MyListInterface<E>{
    public E set(int index, E element)
    public void add(int index, E element)
    public E remove(int index)


    void add(int index, E element);
    boolean add(E element);

    E get(int index);

    int size();

}