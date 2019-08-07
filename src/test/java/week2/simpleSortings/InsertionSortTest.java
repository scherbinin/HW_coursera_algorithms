package week2.simpleSortings;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by scher on 07.08.2019.
 */
public class InsertionSortTest {
    @Test
    public void testAscendingSorting() {
        List<Integer> initialData = Arrays.asList(2, 7, 1, 0, 3, 4, 6, 5, -9,11);
        Integer[] actual = new Integer[initialData.size()];
        Integer[] expected = new Integer[initialData.size()];

        initialData.toArray(actual);
        Arrays.sort(initialData.toArray(expected));

        new InsertionSort().sort(actual);

        assertArrayEquals(actual, expected);
    }
}
