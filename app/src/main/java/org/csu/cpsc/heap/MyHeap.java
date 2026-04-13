package org.csu.cpsc.heap;

public class MyHeap<E extends Comparable<E>> {
    
    private void insert(E item){
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
        }
    }

    private void verifyRemove(int parentIndex){
        int leftChildIndex = findLeftChild(parentIndex);
        int rightChildIndex = findRightChild(parentIndex);

        //Verify leftChild and rightChild are valid
        if(leftChildIndex <= endOfHeap && rightChildIndex <= endOfHeap){
            int smallestChildIndex = -1;
            if(data[leftChildIndex].compareTo(data[rightChildIndex]) <=0){
                smallestChildIndex = leftChildIndex;
            } else {
                smallestChildIndex = rightChildIndex;
            }

            if(data[parentIndex].compareTO(data[smallestChildIndex]) > 0){
                swap(parentIndex, smallestChildIndex)

            }
        } else if(leftChildIndex <= endOfHeap){ //left child is valid

        }
    }

    private int findParent(int child){
        return (child-1)/2;
    }

    private int findLeftChild(int parent){
        return (parent * w) + 1;
    }

    private int findRightChild(int parent){
        return (parent *2) + 2;
    }
}
