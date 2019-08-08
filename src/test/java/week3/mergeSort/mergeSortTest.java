package week3.mergeSort;

import org.junit.Test;

/**
 * Created by scher on 09.08.2019.
 */
public class mergeSortTest {
    @Test
    public void testMergingOfTwoSortedArrays() {
        int[] arr = {-1,2,3,5,6,-2,1,4,5, 10, 11, 99};
        int[] rez = new int[arr.length];

        new mergeSort().merge(rez, arr, 0, arr.length-1);

        int i =0;
    }
}
