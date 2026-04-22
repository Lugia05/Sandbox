package org.csu.cpsc.heap;

public class MyHeap<E extends Comparable<E>> {
    private E[] data;
    private int endOfHeap;

    public MyHeap(int initialCapacity){
        data = (E[]) new Comparable[initialCapacity];
        endOfHeap = -1;
    }

    public MyHeap(){
        this(50);
    }

    public void insert(E item){
        endOfHeap++;
        data[endOfHeap] = item;
        verifyInsert(endOfHeap);
    }

    private void verifyInsert(int childIndex){
        int parentIndex = findParent(childIndex);
        if(data[childIndex].compareTo(data[parentIndex]) < 0){
            swap(childIndex, parentIndex);
            verifyInsert(parentIndex);
        }
    }
    // 0 -- Same
    // -1 -- less than
    // -2 -- greater than

    public E remove(){
        if(endOfHeap < 0){
            return null;
        } else {
            E removedItem = data[0];
            swap(0, endOfHeap);
            data[endOfHeap] = null;
            endOfHeap--;
            return removedItem;
        }

    }

    private void verifyRemove(int parentIndex){
        int leftChildIndex = findLeftChild(parentIndex);
        int rightChildIndex = findRightChild(parentIndex);

        //Verify leftChild and rightChild are valid
        if(leftChildIndex <= endOfHeap && rightChildIndex <= endOfHeap){
            int smallestChildIndex = -1;
            if(data[leftChildIndex].compareTo(data[rightChildIndex]) <= 0){
                smallestChildIndex = leftChildIndex;
            } else {
                smallestChildIndex = rightChildIndex;
            }

            if(data[parentIndex].compareTo(data[smallestChildIndex]) > 0){
                swap(parentIndex, smallestChildIndex);
                verifyRemove(smallestChildIndex);
            }

        } else if(leftChildIndex <= endOfHeap){ //left child is valid
            if(data[parentIndex].compareTo(data[leftChildIndex]) > 0){
                swap(parentIndex, leftChildIndex);
            }
        }
    }

    private int findParent(int child){
        return (child-1)/2;
    }

    private int findLeftChild(int parent){
        return (parent * 2) + 1;
    }

    private int findRightChild(int parent){
        return (parent * 2) + 2;
    }

    private void swap(int index1, int index2){
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
