package week3.mergeSort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by scher on 09.08.2019.
 */
public class MergeSortTest {
//    @Test
//    public void testMergingOfTwoSortedArrays2() {
//        Integer[] arr = {-1,2, 3,-2,1,10,12,};
//        Integer[] rez = new Integer[arr.length];
//
//        new MergeSort().merge(rez, arr, 0, arr.length, 3);
//
//    }

    @Test
    public void testAscendingSorting() {
        List<Integer> initialData = Arrays.asList(2, 7, 1, 0, 3, 12, 434, -99871, 4, 4, 6, 5, -9,11,-99);
        Integer[] actual = new Integer[initialData.size()];
        Integer[] expected = new Integer[initialData.size()];

        initialData.toArray(actual);
        Arrays.sort(initialData.toArray(expected));

        new MergeSort().sort(actual);

        assertArrayEquals(actual, expected);
    }

}
