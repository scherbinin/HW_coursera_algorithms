package week3.quickSort;

public class QuickSort {
    public void sort(int[] arr) {

    }

    //return new index of pivot element
    public int partion(int[] arr, int lo, int hi) {
        //Let it be the pivot element - the first in the array
        int left = lo;
        int right = hi;

        while (true) {
            while (arr[lo] < arr[--right]) {
                if (right == lo) break;
            }
            while (arr[lo] > arr[++left]) {
                if (left == right) break;
            }

            if (left >= right)
                break;

            swap(arr, left, right);
        }

        swap(arr, lo, right);
        return right;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
