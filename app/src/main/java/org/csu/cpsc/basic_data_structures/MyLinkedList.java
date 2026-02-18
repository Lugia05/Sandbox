package org.csu.cpsc.basic_data_structures;

import java.util.Arrays;
import java.util.ArrayList;

//import java.util.IndexOutOfBoundsException;

public class MyLinkedList<E> implements MyListInterface<E> {
    private Node<E> head;

    public MyLinkedList(){
        this.head = null;
    }

        @Override
        public E set(int index, E element){
            if(index >= 0 && index < size()){
                int position = 0;
                Node<E> currentNode = head;

                while(position < index){
                    currentNode = currentNode.next;
                    position ++;
                }
                currentNode.data = element;
                return currentNode.data;
            } else {
                throw new IndexOutOfBoundsException("Unable to get");
            }

        }

        @Override
        public void add(int index, E element){

            if(index >= 0 && index < size()){
                int position = 0;
                Node<E> currentNode = head;
                //checks if the index is not at 0 before starting
                if (index == 0){
                    if ((head == null)){
                        head = currentNode;
                        currentNode.next = null;
                    } else {
                        Node<E> SaveIt = head;
                        head = new Node<E>(element); 
                        head.next = SaveIt;
                    }

                } else if (index == (size()-1)){
                    //checks if the index is at the end
                    while(position != index){
                        currentNode = currentNode.next;
                        position ++;
                    }
                    currentNode.next = new Node<E>(element);
                    currentNode.next.next = null;

                } else{
                    //default to this if the indexs is not 0 nor at the end
                    while(position < index){
                        currentNode = currentNode.next;
                        position ++;

                    }
                    Node<E> SaveIt = currentNode;
                    currentNode = new Node<E>(element);
                    currentNode.next = SaveIt;
                }
                //add here

            } else {
                throw new IndexOutOfBoundsException( "Unable to get");
            }
            
        }

        //remove()
        @Override
        public E remove(int index){
            //E Re = this.get(index);
            //E Neighbor = this.get(index-1);
            //Neighbor
            E re = this.get(index);

            if(index >= 0 && index < size()){
                int position = 0;
                Node<E> currentNode = head;
                //checks if the index is not at 0 before starting
                if (index == 0){
                    head = currentNode.next;
                    currentNode.next = null;

                } else if (index == (size()-1)){
                    //checks if the index is at the end
                    while(position != index){
                        currentNode = currentNode.next;
                        position ++;
                    }
                    currentNode.next = null;

                } else{
                    //default to this if the indexs is not 0 nor at the end
                    while(position < index){
                        currentNode = currentNode.next;
                        position ++;

                    }
                    currentNode.next = currentNode.next.next;
                    currentNode.next = null;
                }
                //add here

            } else {
                throw new IndexOutOfBoundsException( "Unable to get");
            }
            return re;
            
        }

        //below is stuff before the assignment

    @Override
    public boolean add(E element){
        Node<E> newNode = new Node<E>(element);

        if(head == null){
            this.head = newNode;
        } else {
            Node<E> currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        return true;
    }

    @Override
    public boolean contains(Object o){
        if(head != null) {
            Node<E> currentNode = this.head;

            while(currentNode.next != null){
                if(currentNode.data.equals(o)){
                    return true;
                } else {
                    currentNode = currentNode.next;
                }
            }
        } 

        return false;
    }

    @Override
    public E get(int index){
        if(index >= 0 && index < size()){
            int position = 0;
            Node<E> currentNode = head;

            while(position < index){
                currentNode = currentNode.next;
                position++;
            }

            return currentNode.data;
        } else {
            throw new IndexOutOfBoundsException("Unable to Get");
        }

    }

    @Override
    public int indexOf(Object o){
        int defaultIndex = -1;

        if(head != null){
            int index = 0;

            Node<E> currentNode = head;
            while(currentNode != null){
                if(currentNode.data.equals(o)){
                    return index;
                } else {
                    index++;
                    currentNode = currentNode.next;
                }
            }
        }
        return defaultIndex;
    }

    @Override
    public int size(){
        Node<E> currentNode = head;
        int size = 0;

        while(currentNode != null){
            size += 1;
            currentNode = currentNode.next;
        }
        return size;
    }



    private class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
            next = null;
        }
    }

    @Override
    public String toString(){
        ArrayList<E> ArList = new ArrayList<E>();
        Node<E> currentNode = head;
        while(currentNode != null){
            ArList.add(currentNode.data);

         
            currentNode = currentNode.next;
        }
       
        return ArList.toString() ;
    }

    //public boolean remove(Object o){

    //}
    /*
    @Override
    public E set(int index, E element){
    //valid index
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Unable to set up value");
        } else {
            Node currentNode = head;
            int position = 0;

            while(position < index){
                position++;
                currentNode= currentNode.next;
            }

            // 1. Save the data to a temporary object to return
            E tempData = currentNode.data;

            //2. Set the data in the object
            currentNode.data = element;

            //3. Return the old data
            return tempData;
        }

        @Override
        public void add(int index, E element){
            //Bevahior: insert a new node (element) at the index
            //Parameters:
            // int index: The index where the object should be inserted
            // E element: The data for the new object

            // Is it a valid index
            if(index < 0 || index >= size()){
                throw new IndexOutOfBoundsException();
            } else {
                Node<E> newNode = new Node<E>(element);
                if(index == 0){
                    newNode.next = head;
                    head = newNode;
                } else if (index == size()){
                    add(element);
                } else {
                    Node<E> currentNode = head;
                    int position = 0;

                    while(position < index - 1){
                        position++;
                        currentNode = currentNode.next;
                    }

                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                }
            }
        }
    }

    public E remove(int index){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        } else {
            E returnValue = null;

            if(index == 0){
                Node<E> temp = head;
                head = head.next;
                temp.next = null;
                returnValue = temp.data;
            } else {
                Node<E> currentNode = head;
                int position = 0;

                while (position < index -1 ){
                    position++;
                    currentNode = currentNode.next;
                }

                Node<E> temp = currentNode.next;
                currentNode.next = currentNode.nexrt.next;

                temp.next = null;
                returnValue = temp.data;
            }

            return returnValue;
        }
    }
    
    */


}
