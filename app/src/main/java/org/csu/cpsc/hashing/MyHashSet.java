package org.csu.cpsc.hashing;

public class MyHashSet<E> {
    private Node<E>[] set;

    public MyHashSet(int capacity){
        set = new Node[capacity];
    }

    public MyHashSet(){
        this(10);
    }

    public boolean add(E value){
        int index = find_position(value);

        if(set[index] == null){
            set[index] = new Node(value);
        } else {
            Node<E> currentNode = set[index];
            while(currentNode.next != null){
                if(currentNode.data.equals(value)){
                    return false;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(value);
        }

        return true;
    }
 public boolean delete(E value) {
    int index = find_position(value);

    Node<E> currentNode = set[index];
    Node<E> previousNode = null;

    while (currentNode != null) {
        if (currentNode.data.equals(value)) {
            if (previousNode == null) {
                // Checks if the index is at zero
                set[index] = currentNode.next;
            } else {
                previousNode.next = currentNode.next;
            }
            return true;
        }
        previousNode = currentNode;
        currentNode = currentNode.next;
    }

    return false;
}
/*
    public boolean remove(Object o){
        int index = indexOf(o);
        if(index >= 0){
            remove(index);
            return true;
        } else {
          return false ;
        }
    }
 */

        public boolean remove(E value){
            int index = find_position(value);
            if(set[index] == null){
                return false;
            } else {
                Node<E> currentNode = set[index];
                Node<E> previousNode = null;

                while(currentNode != null){
                    if(currentNode.data == value){
                        return true;
                    } else{
                        previousNode = currentNode;
                        currentNode = currentNode.next;
                    }
                }

                return true;
            }
        }
    

    public boolean contains(E value){
        int index = find_position(value);
        if (set[index] != null){
            return false;
        } else {
            Node<E> currentNode = set[index];
            while(currentNode != null){
                if(currentNode.data.equals(value)){
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }
    }

    public void display() {
        for (int i = 0; i < set.length; i++) {
            System.out.println("Bucket " + i + ": " + set[i]);
        }
    }

    private int find_position(E value){
        return Math.abs(value.hashCode() % set.length);
    }


    private class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
            next = null;
        }
    }
}
