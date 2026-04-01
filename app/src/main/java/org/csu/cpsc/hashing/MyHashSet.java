package org.csu.cpsc.hashing;

public class MyHashSet {
    private Node<E>[] set;

    public MyHashSet(int capacity){
        set = new Node[capacity];
    }

    public MyHashSet(){
        this(10);
    }

    public boolean add(String value){
        int index = find_position(value);

        if(set[index] == null){
            set[index] = new Node(value);
        } else{
            Node currentNode = set[index];
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(value);
        }
        return true;
    }

    public boolean contains(String value){
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

    public boolean delete{

    }
    
    private class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
            next = null;
        }
    }

    private int find_position(String value){
        return Math.abs(value.hashCode() % set.length);
    }
}
