package org.csu.cpsc.basic_data_structures;

public class MyLinkedList<E> implements MyListInterface<E> {
    private Node<E> head;

    public MyLinkedList(){
        this.head = null;
    }

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


}


/*
package org.csu.cpsc.basic_data_structures

public class MyLinkedList<E> implements MylistInterface<E>{
    private class MyLinkedlist<E> implements MyListInterface<E>{
        private Node<E> head;

        public myLinkedList(){
            this.head = null
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
                currentNode.data = E element;
                return currentNode.data;
            } else {
                throw IndexOutOfBoundsException(s: "Unable to get");
            }

        }

        @Override
        public void add(int index, E element){
            if(index >= 0 && index <= size()){
                int position = 0;
                Node<E> currentNode = head;
                //checks if the index is not at 0 before starting
                if (index = 0){
                //checks if the index is 0
                    
                } else if (index = size()){
                    //checks if the index is at the end
                    while(position != index){
                        currentNode = currentNode.next;
                        position ++;
                    }
                    add(element);

                } else{
                    //default to this if the index is not 0 nor at the end
                    while(position < index){
                        currentNode = currentNode.next;
                        position ++;
                    }
                }
                //add here

            } else {
                throw IndexOutOfBoundsException(s: "Unable to get");
            }
        }


        //below is stuff before the assignment

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
            throw IndexOutOfBoundsException(s: "Unable to get");
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

/* public void traverse(){
    //start at head
    Node current = head;

    //Loop until end
    while (current != null){
        System.out.print(*current.data=())
    }
}

Step 1 current = head
Step 2

last note points to null
transversal uses a loop.
 */