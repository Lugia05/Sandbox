package org.csu.cpsc.basic_data_structures;

import java.util.Arrays;

public class MyArrayList<E> implements MyListInterface<E> {
    private E[] data;

    public MyArrayList(){
        data = (E[]) new Object[0];
    }

    @Override
    public boolean add(E element){
        try{
            //Resizing array to have 1 additional position
            data = Arrays.copyOf(data, data.length + 1);

            //add element to the last spot in the array
            data[data.length - 1 ] = element;

            //return true if added
            return true;
        } catch (Exception e){
            return false;
        }
    }

    // @Override
    public void add(int index, E element){
        //1. Resize array to have 1 additional position
        data = Arrays.copyOf(data, data.length+1);
       
        //2. Shift elements down until we reach index
        for(int x = data.length-1; x > index; x--){
            data[x] = data[x-1];
        }

        //3. Insert element into index
        data[index] = element;
    }

    @Override
    public boolean contains(Object o){
        for(int i = 0; i <= data.length-1; i++){
            if(data[i].equals(o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public E get(int index){
        if(index >= 0 && index <= data.length){
            return data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o){
        for(int i = 0; i < data.length; i++){
            if(data[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    // @Override
    public int lastIndexOf(Object o){
        for(int i = data.length-1; i >= 0; i--){
            if(data[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    // @Override
    public E set(int index, E element){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        } else {
            E temp = data[index];
            data[index] = element;
            return temp;
        }
    }

    @Override
    public int size(){
        return data.length;
    }

    // @Override
    public E remove(int index){
        // Step 0: Checking to find if index is valid
        if(index >= 0 && index <= data.length - 1){
            // Step 1: Store the value to be returned
            E returnValue = data[index];

            // Step 2: Shift the elements down
            for(int i = 0; i < data.length - 1; i++){
                data[i] = data[i+1];
            }

            // Step 3: Resize the Array
            data = Arrays.copyOf(data, data.length-1);

            // Step 4: Return the value
            return returnValue;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(Object o){
        // If the object o is contained in the list, remove the object
        int index = indexOf(o);
        if(index >= 0){
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(data);
    }
}











/*
package org.csu.cpsc.basic_data_structures ;

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
            data = Arrays.copyOf(data, data.length+1) ;

            //2. Shoft elements down until we reach index
            for(int x = data.length-1; x > index; i--){
                data[x] = data [x-1];
            }

            //3. Insert element into index
            data[index = element;]

            //Start data.length-1 ---> index
            //for (x = data.length-1 , x>=index+1, x--)
            // data[x] = data[x-1]


        }

        @Override
        public E get(int index){
            return data[index];
        }

        @Overridepublic int size(){
            return data.length;
        }

}
*/