package org.csu.cpsc.heap;

public class MyPriorityQueue<E extends Comparable<E>> implements MyQueueInterface<E> {
    MyHeap<E> priorityQueue;

    @Overide
    public boolean offer(E e){
        try{
            priorityQueue.insert(e);
            return true;
        } catch (exception ex){
            return false;
        }
    }

    @Override
    public E peek() {
        E element priorityQueue.removed()
    }

    @Override
    public E element(){
        E element = priorityQueue.remove();
        if(element == null){
            throw new NoSuchElementException();
        } else {
            priorityQueue.insert(element);
            return element;
        }
        return null;
    }
}
