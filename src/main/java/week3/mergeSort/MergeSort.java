package week3.mergeSort;

/**
 * Created by scher on 08.08.2019.
 */
public class MergeSort {

    public void sort(Integer[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(Integer[] arr, int left, int right) {
        int mid = (right - left) / 2 + left;

        if (right - left > 1) {
            sort(arr, left, mid);
            sort(arr, mid, right);
        }


        merge(arr, left, right, mid);

    }

    public void merge(Integer[] arr, Integer left, Integer right, int mid) {
        int leftIndex = left;
        int midIndex = mid;
        Integer[] aux = new Integer[right - left];

        for (int i = 0; i < right - left; i++) {
            if (midIndex == right) {
                aux[i] = arr[leftIndex++];
            } else if (leftIndex == mid) {
                aux[i] = arr[midIndex++];
            } else if (arr[leftIndex] < arr[midIndex]) {
                aux[i] = arr[leftIndex++];
            } else {
                aux[i] = arr[midIndex++];
            }
        }


        System.arraycopy(aux, 0, arr, left, aux.length);
    }
}
