package week3.mergeSort;

/**
 * Created by scher on 08.08.2019.
 */
public class mergeSort {
    public void merge(int[] aux, int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int leftIndex = left;
        int midIndex = mid;
        int size = right - left;

        for (int i = 0; i <= size; i++) {
            if (midIndex > right) {
                aux[i] = arr[leftIndex];
                leftIndex++;
                continue;
            }

            if (leftIndex == mid) {
                aux[i] = arr[midIndex];
                midIndex++;
                continue;
            }

            if (arr[leftIndex] < arr[midIndex]) {
                aux[i] = arr[leftIndex];
                leftIndex++;
            } else {
                aux[i] = arr[midIndex];
                midIndex++;
            }
        }
    }
}
