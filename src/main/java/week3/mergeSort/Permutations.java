package week3.mergeSort;

/**
 * Created by scher on 10.08.2019.
 *
 * An inversion in an array a[\,]a[] is a pair of entries a[i]a[i] and a[j]a[j] such that i < ji<j but a[i] > a[j]a[i]>a[j].
 * Given an array, design a linearithmic algorithm to count the number of inversions.
 */
public class Permutations {
    int permutations;

    public int sort(Integer[] arr) {
        sort(arr, 0, arr.length);
        return permutations;
    }

    private void sort(Integer[] arr, int left, int right) {
        int mid = (right - left) / 2 + left;

        if (right - left > 1) {
            sort(arr, left, mid);
            sort(arr, mid, right);
        }

        permutations += merge(arr, left, right, mid);
    }

    public int merge(Integer[] arr, Integer left, Integer right, int mid) {
        int leftIndex = left;
        int midIndex = mid;
        int permutations = 0;
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
                permutations += mid - leftIndex;
            }
        }

        for (int i = 0; i < aux.length; i++)
            arr[left + i] = aux[i];

        return permutations;
    }
}
