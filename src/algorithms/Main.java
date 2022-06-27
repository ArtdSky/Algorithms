package algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr ;

//----------------SEARCHING--------------------------------------------
        Search search = new Search();
        arr = new int[]{5, 34, 65, 12, 77, 35};  //not sorted array
//      search.linearSearch(arr, 65);
        arr = new int[]{ 13, 21, 54, 81, 90, 111, 112,223, 452, 875};  //sorted array
//      search.binarySearch(arr, 90);
//      search.ternarySearch2(arr, 91);
//      search.jumpSearch(arr,90) ;




//----------------SORTING--------------------------------------------
        arr = new int[]{5, 34, 65,34,  12, 77, 35};
        Sorts sort = new Sorts();
//      sort.bubbleSort(arr);  //bubble sort
//      sort.bubbleFlagSort(arr); //bubble sort with flag
//      sort.isertionSort(arr);
//      sort.stoogeSort(arr, 0, arr.length-1);
//      sort.selectionSort(arr);
//      sort.quickSort(arr, 0, arr.length-1);
//      sort.mergeSort(arr, 0, arr.length-1);
//      sort.heapSort(arr);
//      sort.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}