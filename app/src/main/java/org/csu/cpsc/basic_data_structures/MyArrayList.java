package org.csu.cpsc

import java.util.Arrays;

public class MyArrayList<E> implements MyListInterface<E>{
    private E[] data;

    public MyArrayList(){
        data = (E[]) new Object[0];
    }

    @Override
    public boolean add(E element){
        try {
            //Resizing array to have 1 additional position
            data = Arrays.copyOf(data, data.length + 1) ;

            //add element to the last spot in the array
            data[data.length - 1] = element;

            //return true if added
            return true;

        } catch (Exception e) {
            return false;
        }

        @Override
        public void add(int index, E element){
            //1. Resize array to have 1 additional position


            //2. Shoft elements down until we reach index

            //3. Insert element into index

            //Start data.length-1 ---> index
            //for (x = data.length-1 , x>=index+1, x--)
            // data[x] = data[x-1]


        }
}