package org.csu.cpsc.tree;

public class MyBinarySearch {
    public static int search(int[] array, int x){
        int low = 0;
        int high = array.length -1;

        while(low <= high){
            int mid = ((high - low)/2);

            if(array[mid] == x){
                return mid;
            } else if(x < mid){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        //check for these questions
        return high;
    }
}
