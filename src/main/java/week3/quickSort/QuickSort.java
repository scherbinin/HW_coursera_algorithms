package week3.quickSort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public void sort(int[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    //return new index of pivot element
    private int partition(int[] arr, int left, int right) {
        //Let it be the pivot element - the first in the array
        //We will move it close to middle at the end
        int leftInd = left;
        int righInd = right + 1;

        while (true) {
            while (arr[left] < arr[--righInd]) {
                if (righInd == left) break;
            }
            while (arr[left] > arr[++leftInd]) {
                if (leftInd == right) break;
            }

            if (leftInd >= righInd)
                break;

            swap(arr, leftInd, righInd);
        }

        swap(arr, left, righInd);
        return righInd;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
