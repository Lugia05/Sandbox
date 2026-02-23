package org.csu.cpsc.basic_data_structures;

public interface MyQueueInterface <E> {
    //Add data Throws Exception
    boolean add(E element);

    //View Data - Throws Exception
    E element();

    //Add Data - No exception
    boolean offer(E e);

    //View Data - No Exception
    E peek();

    //Remove Data - No exception
    E poll();

    //Remove Data - Throws Exception
    E remove(); 
}
