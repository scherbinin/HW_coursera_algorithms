package week2.simpleSortings;

import java.util.Comparator;

/**
 * Created by scher on 07.08.2019.
 */
public class SelectingSort implements Comparator<Integer> {
    public void sort(Integer[] arr) {

        for(int leftIndex = 0; leftIndex < arr.length; leftIndex++) {
            for (int i = leftIndex+1; i< arr.length; i++) {
                if(isLess(arr[i], arr[leftIndex])) {
                    swap(arr, i, leftIndex);
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
