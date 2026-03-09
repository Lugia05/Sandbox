package org.csu.cpsc ;

public class IntegerSortingLibrary{
    public IntegerSortingLibrary(){};

    public int[] bubbleSort(int[] array){
        for(int stopIndex = array.length-1; stopIndex > 0; stopIndex--){
            for(int index = 0; index < stopIndex; index++){
                if(array[index]> array[index+1]){
                    swap(array, index, index+1);
                }
            }
        }
        return array;
    }

    public void insertionSort(int[] array){
        for(int nextPos = 1; nextPos < array.length; nextPos++){
            int index = nextPos;

            while(index >= 0 && array[index] < array[index -1]){
                swap(array, index, index-1);
                index--;
            }
        }
    }

    public void selectionSort(int[] array){
        for(int fill = 0; fill < array.length-1; fill++){
            int positionMin = fill;
            for(int next = fill + 1; next< array.length; next++){
                if(array[next] < array[positionMin]){
                    positionMin = next;
                }
            }
        }
    }

    public int[] mergeSort(int[] array){
        int tableSize = array.length;

        if(tableSize > 1){
            //find the halfsize of the table so it can be split into a left and right table
            int halfSize = tableSize/2;

            int[] leftTable = new int[halfSize];
            int[] rightTable = new int[tableSize - halfSize];

            //Copy the data from the array to the left and right table

            //Left Table
            for(int i = 0; i < halfSize; i++){
                leftTable[i] = array[i];
            }

            //Right table
            for(int i = halfSize; i < tableSize; i++){
                rightTable[i-halfSize] = array[i];
            }

            //Recursive call
            leftTable = mergeSort(leftTable);
            rightTable = mergeSort(rightTable);

            return mergeMethod(left)

        }

        return array;
    }

    private int[] mergeMethod(int[] leftTable, int[] rightTable){
        int[] array = new int[leftTable.length + rightTable.length];

        int leftTableIndex = 0;
        int rightTableIndex = 0;
        int arrayIndex = 0;

        //Combine left and right as long as there are values in both
        while(leftTableIndex < leftTable.length && rightTableIndex < rightTable.length){
            if(leftTable[leftTableIndex] <= rightTable[rightTableIndex]){
                array[arrayIndex] = leftTable[leftTableIndex];
                arrayIndex++;
                leftTableIndex++;
            } else {
                array[arrayIndex] = rightTable[rightTableIndex];
                arrayIndex++;
                rightTableIndex++;
            }
        }

        while(leftTableIndex < leftTable.length){
            array[arrayIndex] = leftTable[leftTableIndex];
            arrayIndex++;
            leftTableIndex++;
        }

        while(rightTableIndex < tightTable.length){
            array[arrayIndex] = rightTable[rightTableIndex];
            arrayIndex++;
            leftTableIndex++;

            return array;
        }
    }



    private void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }
}

