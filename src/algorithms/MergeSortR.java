package algorithms;

import java.util.Arrays;

public class MergeSortR {
    int[] tempArray;

    public void sort (int[] inputArray) {
        if (inputArray == null || inputArray.length ==0){
            System.out.println("Array is empty or null");
            return;
        }

        tempArray = new int[inputArray.length];
        sort(inputArray, 0, inputArray.length-1);

        System.out.println(Arrays.toString(inputArray));
    }

    private void sort (int[] inputArray, int low, int high){
        if(low == high){
            return;
        }

        int mid = (low+high)/2;
        sort(inputArray, low, mid);
        sort(inputArray, mid+1, high);

        merge(inputArray, low, mid, high);
    }

    private void merge (int[] inputArray, int low, int mid, int high) {
        arrayCopy(inputArray, tempArray);

        //Already in order
        if(tempArray[mid] <= tempArray[mid+1]){
            for (int i=low; i<=high; i++){
                inputArray[i] = tempArray[i];
            }
        }

        else {
            int i=low, j=mid+1, k=low;
            while (i<=mid && j<=high) {
                if (tempArray[i] < tempArray[j]) {
                    inputArray[k++] = tempArray[i++];
                } else {
                    inputArray[k++] = tempArray[j++];
                }
            }

            //Overflow
            //TODO is i==mid enough?
            if (i<=mid){
                for (; i<=mid; i++, k++){
                    inputArray[k] = tempArray[i];
                }
            }
            if (j<=high){
                for (; j<=high; j++, k++){
                    inputArray[k] = tempArray[j];
                }
            }
        }
    }

    private static void arrayCopy(int[] source, int[] destination){
        System.arraycopy(source, 0, destination, 0, source.length);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] inputArray = {-2,38,-58,-6,-53,37,60,40};

        MergeSortR mergeSort = new MergeSortR();
        mergeSort.sort(inputArray);

        long endTime = System.nanoTime() - startTime;

        System.out.println("Time:"+ endTime);
    }
}
