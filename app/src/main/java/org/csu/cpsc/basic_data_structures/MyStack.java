package org.csu.cpsc.basic_data_structures ;

import java.util.List;
import java.util.LinkedList;
import java.util.EmptyStackException;

public class MyStack<E> {
    private List<E> stack;

    public MyStack(){
        stack = new LinkedList<>();
    }

    public void push(E item){
        stack.add(0, item) ;
    }

    public E peek(){
        if(!empty()){
            return stack.get(0) ;
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean empty(){
        if (stack.size() == 0){
            return true;
        } else {
            return false;
        }
    }


    public E pop(){
        if (! empty()){
            return stack.remove(0);
        } else {
            throw new EmptyStackException();
        }
    }
}