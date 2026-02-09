package org.csu.cpsc.basic_data_structures

public class MyLinkedList<E> implements MylistInterface<E>{
    private class MyLinkedlist<E> implements MyListInterface<E>{
        private Node<E> head;

        public myLinkedList(){
            this.head = null
        }

        @Override
        public boolean add(E element){
            Node<E> newNode = new Node<E>(element);

            if(head.next == null){
                this.head = newNode;
            } else {
                Node<E> currentNode = head;
                while(currentNode.head.next = null){
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }

            return true;
        }

        public boolean contains(Object o){
            if(head != null){
                Node<E> currentNode = new Node<E>();

                while(currentNode.next != null){
                    if (currentNode.data.equals(o)){
                        return true;
                    } else {
                        currentnode = currentNode.next ;
                    }
                }
            }
            //check placement
            return false;
        }

        @Override
        public int size(){
            Node<E> currentNode = head;
            int size = 0;
            while (currentNode != null){
                size += 1;
                currentNode = currentNode.next;
            }
            return size;
        }

        @Override
        public int indexOf(Object o){
            int index = -1;

            if(head 1= null){
                index = 0;

                Node<E> currentNode = head;
                while(currentNode != null){
                    if(currentNode.equals(o)){
                        return index;
                    } else {
                        index++;
                        currentNode = currentNode.next;
                    }

                }
                return index;
            }
        }

        @Override
        public E get(int index){
            if(index >= 0 && index < size()){
                int position = 0;
                Node<E> currentNode = head;

                while(position < index){
                    currentNode = currentNode.next;
                    position ++;
                }
                return currentNode.data;
            } else {
                throw IndexOutOfBoundsException(s: "Unable to get");
            }

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
}