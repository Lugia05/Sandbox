package org.csu.cpsc.heap;

public class Main {
    public static void main(String[] args){
        MyHeap<Integer> heap = new MyHeap<>();

        heap.insert(5);
        heap.insert(6);
        heap.insert(1);

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
    }
}
