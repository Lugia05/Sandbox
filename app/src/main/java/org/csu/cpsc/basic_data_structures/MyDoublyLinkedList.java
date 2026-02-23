package org.csu.cpsc.basic_data_structures;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> implements MyListInterface<E>, MyQueueInterface<E> {
    private Node<E> head;
    private Node<E> tail;
    private int counter;

    /**
     * Constructs an empty MyDoublyLinkedList.
     * Initializes head and tail to null and counter to 0.
     */
    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        counter = 0;
    }

    /**
     * Inserts a new element at the specified index.
     * Elements at or after the index are shifted forward.
     *
     * @param index   the position at which to insert the element (0-based)
     * @param element the data to store in the new node
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than size()
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<E>(element);

        if (index == 0) {
            if (head == null) {
                // List is empty — new node becomes both head and tail
                head = newNode;
                tail = newNode;
            } else {
                // Link new node ahead of current head
                newNode.next = head;
                head.prev = newNode;
                // Update head to the new front node
                head = newNode;
            }
            counter++;
        } else if (index == size()) {
            // Inserting at the end — delegate to add(E) which handles tail update
            add(element);
        } else {
            // Traverse from nearest end to find insertion point
            Node<E> currentNode;
            if (index <= size() / 2) {
                currentNode = head;
                int position = 0;
                while (position < index - 1) {
                    currentNode = currentNode.next;
                    position++;
                }
            } else {
                currentNode = tail;
                int position = size() - 1;
                while (position > index - 1) {
                    currentNode = currentNode.prev;
                    position--;
                }
            }
            // Wire the new node between currentNode and currentNode.next
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
            counter++;
        }
    }

    /**
     * Appends a new element to the end (tail) of the list.
     * Uses the tail reference for O(1) insertion — no traversal required.
     *
     * @param element the data to store in the new node
     * @return true if the element was successfully added
     */
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<E>(element);

        if (head == null) {
            // List is empty — new node becomes both head and tail
            head = newNode;
            tail = newNode;
        } else {
            // Attach new node after current tail
            tail.next = newNode;
            // Point new node back to old tail
            newNode.prev = tail;
            // Advance tail to the new last node
            tail = newNode;
        }
        counter++;
        return true;
    }

    /**
     * Checks whether the list contains the specified object.
     * Traverses from head to tail comparing each node's data using equals().
     *
     * @param o the object to search for
     * @return true if the object is found, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Returns the element at the specified index without removing it.
     * Traverses from the nearest end (head or tail) to minimize steps.
     *
     * @param index the position of the element to retrieve (0-based)
     * @return the element stored at the given index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Unable to Get");
        }

        Node<E> currentNode;
        if (index <= size() / 2) {
            // Index is in the first half — traverse forward from head
            currentNode = head;
            int position = 0;
            while (position < index) {
                currentNode = currentNode.next;
                position++;
            }
        } else {
            // Index is in the second half — traverse backward from tail
            currentNode = tail;
            int position = size() - 1;
            while (position > index) {
                currentNode = currentNode.prev;
                position--;
            }
        }
        return currentNode.data;
    }

    /**
     * Returns the index of the first occurrence of the specified object.
     * Traverses from head to tail comparing each node's data using equals().
     *
     * @param o the object to search for
     * @return the 0-based index of the first match, or -1 if not found
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    /**
     * Returns the number of elements currently in the list.
     * Uses the counter field for O(1) performance.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return counter;
    }

    /**
     * Replaces the element at the specified index with a new value.
     * Traverses from the nearest end (head or tail) to minimize steps.
     *
     * @param index   the position of the element to replace (0-based)
     * @param element the new value to store at the given index
     * @return the element previously stored at the given index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Unable to set value");
        }

        Node<E> currentNode;
        if (index <= size() / 2) {
            // Index is in the first half — traverse forward from head
            currentNode = head;
            int position = 0;
            while (position < index) {
                currentNode = currentNode.next;
                position++;
            }
        } else {
            // Index is in the second half — traverse backward from tail
            currentNode = tail;
            int position = size() - 1;
            while (position > index) {
                currentNode = currentNode.prev;
                position--;
            }
        }

        E tempData = currentNode.data;
        currentNode.data = element;
        return tempData;
    }

    /**
     * Removes and returns the element at the specified index.
     * Removal at the head or tail is O(1) using the head/tail references.
     * Removal in the middle traverses from the nearest end.
     *
     * @param index the position of the element to remove (0-based)
     * @return the data that was stored in the removed node
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        E returnValue;

        if (index == 0) {
            // Removing the head node
            returnValue = head.data;
            if (head == tail) {
                // Only one node in the list — clear both head and tail
                head = null;
                tail = null;
            } else {
                // Advance head to the next node and clear its prev pointer
                head = head.next;
                head.prev = null;
            }
        } else if (index == size() - 1) {
            // Removing the tail node — no traversal needed
            returnValue = tail.data;
            // Move tail back to the previous node
            tail = tail.prev;
            // Detach the old tail by clearing its next pointer
            tail.next = null;
        } else {
            // Removing a middle node — traverse from nearest end
            Node<E> currentNode;
            if (index <= size() / 2) {
                currentNode = head;
                int position = 0;
                while (position < index) {
                    currentNode = currentNode.next;
                    position++;
                }
            } else {
                currentNode = tail;
                int position = size() - 1;
                while (position > index) {
                    currentNode = currentNode.prev;
                    position--;
                }
            }
            // Bypass the current node by relinking its neighbors
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            // Detach removed node from the list
            currentNode.next = null;
            currentNode.prev = null;
            returnValue = currentNode.data;
        }

        counter--;
        return returnValue;
    }

    /**
     * Removes the first occurrence of the specified object from the list.
     * Uses indexOf() to locate the object, then delegates to remove(int).
     *
     * @param o the object to remove
     * @return true if the object was found and removed, false otherwise
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    // -- MyQueueInterface Implementation --

    //View Data - Throws Exception if Empty
    @Override
    public E element(){
        if (head == null){
            throw new NoSuchElementException("Queue is Empty");
        }
        return head.data;
    }

    // Add data
    @Override
    public boolean offer(E e){
        try{
            add(e);
        } catch (Exception ex){
            return false;
        }
        return true;
    }

    //View - no exception
    @Override
    public E peek(){
        if(head == null){
            return null;
        } else {
            return head.data;
        }
    }

    //Remove - no exception
    @Override
    public E poll(){
        if(head == null){
            return null;
        }

        return remove(0);
    }

    //Remove - exception
    @Override
    public E remove(){
        if(head == null){
            throw new NoSuchElementException("Queue is Empty");
        }
        return head.data;
    }


    // ── Inner Node class ──────────────────────────────────

    /**
     * A private inner class representing a single node in the doubly linked list.
     * Each node stores a data element and references to both the next and previous nodes.
     *
     * @param <E> the type of data stored in this node
     */
    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        /**
         * Constructs a new Node with the given data.
         * Both next and prev are initialized to null.
         *
         * @param data the value to store in this node
         */
        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}