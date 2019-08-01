package week1.searches;

import java.util.Arrays;

/**
 * Created by scher on 01.08.2019.
 */
public class BitonicSearch {

    public int bitonicSearch(int[] arr, int value) {
        validateInputArrayOnBitonicCriteria(arr);

        int indexOfMaxValue = maxBinarySearch(arr);
        int result = ascendingBinarySearch(arr, value, 0, indexOfMaxValue);

        if (result < 0)
            result = descendingBinarySearch(arr, value, indexOfMaxValue, arr.length);

        return result;
    }


    public int ascendingBinarySearch(int[] arr, int value, int left, int right) {
        validate(arr);

        while (left <= right) {
            int middle = (left + right) / 2;

            if (value < arr[middle])
                right = middle - 1;
            else
                left = middle + 1;

            if (arr[middle] == value)
                return middle;
        }

        return -1;
    }

    public int descendingBinarySearch(int[] arr, int value, int left, int right) {
        validate(arr);

        while (left <= right) {
            int middle = (left + right) / 2;

            if (value < arr[middle])
                left = middle + 1;
            if (value > arr[middle])
                right = middle - 1;

            if (arr[middle] == value)
                return middle;

        }

        return -1;
    }

    public int maxBinarySearch(int[] array) {
        validate(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (array[middle - 1] < array[middle]) {
                left = middle;
            } else {
                right = middle;
            }

            if (left + 1 == right)
                if (array[left] > array[right])
                    return left;
                else
                    return right;
        }

        return left;
    }

    private void validate(int[] arr) {
        if (arr == null || arr.length < 1)
            throw new IllegalArgumentException("Wrong input array");
    }

    private void validateInputArrayOnBitonicCriteria(int[] arr) {
        if (Arrays.stream(arr).distinct().count() != arr.length)
            throw new IllegalArgumentException("The massive has duplicates !");

        int maxDigitIndex = maxBinarySearch(arr);

        //Check ascending
        for (int i = 1; i < maxDigitIndex; i++) {
            if (arr[i - 1] > arr[i])
                throw new IllegalArgumentException("The massive is bitonic ");
        }

        //Check descending
        for (int i = maxDigitIndex + 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("The massive is bitonic ");
        }
    }
}
