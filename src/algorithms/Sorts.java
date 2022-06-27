package algorithms;

import java.util.Arrays;

public class Sorts {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nСложность сортировки: 0(Math.pow(n,2))");
    }

    public void bubbleFlagSort(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
        System.out.println("\nСложность сортировки: 0(n)");
    }

    public void isertionSort(int[] arr) {
        int j, temp;
        for (int i = 0; i < arr.length; i++) {
            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        System.out.println("Сложность сортировки: O( Math.pow(n,2) )");
    }

    public void stoogeSort(int[] arr, int start, int length) {
        if (start >= length) {
            return;
        }
        if (arr[start] > arr[length]) {
            int temp = arr[start];
            arr[start] = arr[length];
            arr[length] = temp;
        }

        if (arr[length] - arr[start] + 1 > 2) {
            int part = (arr[length] - arr[start] + 1) / 3;
            // Recursively sort first 2/3 elements
            stoogeSort(arr, start, length - part);
            // Recursively sort last 2/3 elements
            stoogeSort(arr, start + part, length);
            // Recursively sort first 2/3 elements
            stoogeSort(arr, start, length - part);
        }

    }

    public void selectionSort(int[] arr) {
        int arrLen = arr.length;
        for (int i = 0; i < arrLen - 1; i++) {
            int min_el = i;
            for (int j = i + 1; j < arrLen; j++)
                if (arr[j] < arr[min_el])
                    min_el = j;

            int temp = arr[min_el];
            arr[min_el] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Сложность сортировки: O( Math.pow(n,2) )");
    }

    public void quickSort(int[] arr, int start, int end) {
        int loc;
        if (start < end) {
            loc = partitionForQuickSort(arr, start, end);
            quickSort(arr, start, loc - 1);
            quickSort(arr, loc + 1, end);
        }
        if (start > end) {
            System.out.println("Сложность сортировки: O(n*Math.log(n))");
        }
    }

    public int partitionForQuickSort(int[] arr, int start, int end) {
        int left, right, temp, loc, flag;
        loc = left = start;
        right = end;
        flag = 0;

        while (flag != 1) {
            while ((arr[loc] <= arr[right]) && (loc != right)) {
                right--;
            }
            if (loc == right) flag = 1;
            else if (arr[loc] > arr[right]) {
                temp = arr[loc];
                arr[loc] = arr[right];
                arr[right] = temp;
                loc = right;
            }
            if (flag != 1) {
                while ((arr[loc] >= arr[left]) && (loc != left)) {
                    left++;
                }
                if (loc == left) flag = 1;
                else if (arr[loc] < arr[left]) {
                    temp = arr[loc];
                    arr[loc] = arr[left];
                    arr[left] = temp;
                    loc = left;
                }
            }
        }
        return loc;
    }

    public void mergeSort(int[] arr, int start, int end) {
        int half;
        if (start < end) {
            half = (start + end) / 2;
            mergeSort(arr, start, half);
            mergeSort(arr, half + 1, end);
            mergeForMergeSort(arr, start, half, end);
        }

    }
    public void mergeForMergeSort(int[] arr, int start, int half, int end) {
        int[] newArr = new int[arr.length];
        int i, j, k;
        k = 0;
        i = start;
        j = half + 1;
        while (i <= half && j <= end) {
            if (arr[i] < arr[j]) newArr[k++] = arr[i++];
            else newArr[k++] = arr[j++];
        }
        while (i <= half) newArr[k++] = arr[i++];
        while (j <= end) newArr[k++] = arr[j++];

        for (i = end; i >= start; i--) {
            arr[i] = newArr[--k];
        }
    }

    public void heapSort(int[] arr){
            int n = arr.length;
            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);

            // One by one extract an element from heap
            for (int i = n - 1; i > 0; i--) {
                // Move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // call max heapify on the reduced heap
                heapify(arr, i, 0);
            }
        System.out.println("Сложность сортировки: O(n*Math.log(n))");

    }
    public void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public void countingSort(int [] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

}
