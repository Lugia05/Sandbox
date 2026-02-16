package org.csu.cpsc.basic_data_structures;

public interface MyListInterface<E>{
    // void add(int index, E element);
    boolean add(E element);
    boolean contains(Object o);
    E get(int index);
    int indexOf(Object o);
    // int lastIndexOf(Object o);
    // E set(int index, E element);
     int size();
    // E remove(int index);
    // boolean remove(Object o);


    /*
    public E set(int index, E element)
    public void add(int index, E element)
    public E remove(int index)


    void add(int index, E element);
    boolean add(E element);

    E get(int index);

    int size();
    */

}