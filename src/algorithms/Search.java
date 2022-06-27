package algorithms;

public class Search {
    int iterCounter;

    public void linearSearch(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            ++iterCounter;
            if (values[i] == target) {
                System.out.println("Result index: " + i + "\nIteration: " + iterCounter);
                break;
            }
        }
        System.out.println("Result index: " + -1 + "\nIteration: " + iterCounter);
    }

    public void binarySearch(int[] values, int target) {
        int max = values.length - 1;
        int min = 0;
        int guess;

        while (max >= min) {
            guess = (max + min) / 2;
            iterCounter++;
            if (values[guess] == target) {
                System.out.println("Result index: " + guess + "\nIteration: " + iterCounter);
                break;
            } else if (values[guess] > target) {
                max = (guess - 1);
            } else {
                min = (guess + 1);
            }
        }
        while (max < min) {
            System.out.println("Result index: " + -1 + "\nIteration: " + iterCounter);
            break;
        }
    }

    public void jumpSearch(int[] values, int target) {
        int arrLen = values.length;
        int step = (int) Math.sqrt(arrLen);
        int prev = 0;
        while (values[Math.min(step, arrLen) - 1] < target) {
            iterCounter++;
            prev = step;
            step += (int) Math.sqrt(arrLen);
            if (prev >= arrLen)
                System.out.println("Result index: " + -1 + "\nIteration: " + iterCounter);

        }
        while (values[prev] < target) {
            iterCounter++;
            prev++;
            if (prev == Math.min(step, arrLen))
                System.out.println("Result index: " + -1 + "\nIteration: " + iterCounter);

        }

        // If element is found
        if (values[prev] == target) {
            iterCounter++;
            System.out.println("Result index: " + prev + "\nIteration: " + iterCounter);
        } else {
            while (values[prev] > arrLen) {
                System.out.println("Result index: " + -1 + "\nIteration: " + iterCounter);
                break;
            }
        }
    }

    public void ternarySearch2(int values[], int target) {
        int startIndex = 0;
        int arrLen = values.length;
        while (arrLen >= startIndex) {
            int mid1 = startIndex + (arrLen - startIndex) / 3;
            int mid2 = arrLen - (arrLen - startIndex) / 3;
            if (values[mid1] == target) {
                iterCounter++;
                System.out.println("Result index: " + mid1 + "\nIteration: " + iterCounter);
                break;
            }
            if (values[mid2] == target) {
                iterCounter++;
                System.out.println("Result index: " + mid2 + "\nIteration: " + iterCounter);
                break;
            }
            if (target < values[mid1]) {
                iterCounter++;
                arrLen = mid1 - 1;
            } else if (target > values[mid2]) {
                iterCounter++;
                startIndex = mid2 + 1;
            } else {
                iterCounter++;
                startIndex = mid1 + 1;
                arrLen = mid2 - 1;
            }
        }
        if(arrLen < startIndex) {
            System.out.println("Result index: " + -1 + "\nIteration: " + iterCounter);
        }
        // Key not found
    }
}
