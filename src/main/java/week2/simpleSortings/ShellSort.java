package week2.simpleSortings;

import java.util.Comparator;

/**
 * Created by scher on 07.08.2019.
 */
public class ShellSort implements Comparator<Integer> {
    public void sort(Integer[] arr) {
        //The sequences of the gaps calculated by following way: h = 3*a + 1, where a=0,1,2,3...
        int h = arr.length - 2;

        //the sense of that: to pass firstly comparisons with long interval, to prepare whole arrays to insertion sorting, to obtain the best time (less swapping)
        while (h > 0) {
            for (int rightIndex = h; rightIndex < arr.length; rightIndex = rightIndex + h) {
                for (int i = rightIndex - h; i >= 0; i = i - h) {//go from right to left and swapping all pairs of numbers where right less than left
                    if (isLess(arr[rightIndex], arr[i])) {
                        swap(arr, rightIndex, i);
                        rightIndex = i;//just to save pointer on swapped number
                    }
                }
            }

            h = h / 3;
        }

        for (int rightIndex = 1; rightIndex < arr.length; rightIndex++) {
            for (int i = rightIndex - 1; i >= 0; i--) {//go from right to left and swapping all pairs of numbers where right less than left
                if (isLess(arr[rightIndex], arr[i])) {
                    swap(arr, rightIndex, i);
                    rightIndex = i;//just to save pointer on swapped number
                }
            }
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        int buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }

    private boolean isLess(int one, int two) {
        if (compare(one, two) < 1)
            return true;

        return false;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) return -1;
        else if (o1 == o2) return 0;
        else return 1;
    }
}