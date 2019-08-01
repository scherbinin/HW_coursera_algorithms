package week1.searches;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by scher on 01.08.2019.
 */
public class BitonicSearchTest {
    private BitonicSearch underTestSearchEngine;

    @Before
    public void setup() {
        underTestSearchEngine = new BitonicSearch();
    }

    //The input array consists of distinct digits, the first part of array is ascending till some maximum digit and second part is descending.
    @Test
    public void executeBitonicSearch_whenSortedArrayWithMoreThatOneElement_expectedFoundValue() {
        final int[] array1 = {-1, 0, 1, 7, 6, 5, 4, 3, 2, -2, -3, -7, -11};

        IntStream.range(0, array1.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(array1, array1[index]), index));
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeBitonicSearch_whenInputArrayIsNotBitonic1_expectedException() {
        final int[] arrayWithoutDuplicationsButNotBitonic1 = {-1, 9, 1, 7, 6, 5, 4, 3, 2, -2, -3, -7};
        IntStream.range(0, arrayWithoutDuplicationsButNotBitonic1.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(arrayWithoutDuplicationsButNotBitonic1, arrayWithoutDuplicationsButNotBitonic1[index]), index));
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeBitonicSearch_whenInputArrayIsNotBitonic2_expectedException() {
        final int[] arrayWithoutDuplicationsButNotBitonic2 = {-1, 0, 1, 7, 6, 5, 4, 3, 2, -2, 2, -7};

        IntStream.range(0, arrayWithoutDuplicationsButNotBitonic2.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(arrayWithoutDuplicationsButNotBitonic2, arrayWithoutDuplicationsButNotBitonic2[index]), index));
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeBitonicSearch_whenInputArrayWithDuplications_expectedException() {
        final int[] array1 = {-1, 0, 1, 7, 6, 5, 4, 3, 2, -2, -3, -7, -1};

        IntStream.range(0, array1.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(array1, array1[index]), index));
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeBitonicSearch_whenInputArrayIsNotBitonic_expectedException() {
        final int[] arrayWithDuplications = {-1, 0, 1, 7, 6, 5, 4, 3, 2, -2, -3, -7, -1};
        final int[] arrayWithoutDuplicationsButNotBitonic1 = {-1, 9, 1, 7, 6, 5, 4, 3, 2, -2, -3, -7};
        final int[] arrayWithoutDuplicationsButNotBitonic2 = {-1, 0, 1, 7, 6, 5, 4, 3, 2, -2, 2 -7};

        IntStream.range(0, arrayWithDuplications.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(arrayWithDuplications, arrayWithDuplications[index]), index));
        IntStream.range(0, arrayWithoutDuplicationsButNotBitonic1.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(arrayWithoutDuplicationsButNotBitonic1, arrayWithoutDuplicationsButNotBitonic1[index]), index));
        IntStream.range(0, arrayWithoutDuplicationsButNotBitonic2.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.bitonicSearch(arrayWithoutDuplicationsButNotBitonic2, arrayWithoutDuplicationsButNotBitonic2[index]), index));
    }

    @Test
    public void executeAscendingBinarySearch_whenSortedArrayWithMoreThatOneElement_expectedFoundValue() {
        final int[] array1 = {1, 3, 5, 6, 7, 8, 9};
        final int[] array2 = {1, 3, 5, 6, 7, 8};

        IntStream.range(0, array1.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.ascendingBinarySearch(array1, array1[index], 0, array1.length), index));
        IntStream.range(0, array2.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.ascendingBinarySearch(array2, array2[index], 0, array1.length), index));

    }

    @Test
    public void executeDescendingBinarySearch_whenSortedArrayWithMoreThatOneElement_expectedFoundValue() {
        final int[] array1 = {9, 7, 5, 4, 3, 2};
        final int[] array2 = {9, 7, 5, 4, 3, 2, 0};

        IntStream.range(0, array1.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.descendingBinarySearch(array1, array1[index], 0, array1.length), index));
        IntStream.range(0, array2.length - 1).forEach(index ->
                assertEquals(underTestSearchEngine.descendingBinarySearch(array2, array2[index], 0, array1.length), index));

    }

    @Test
    public void executeFindMaxBinarySearch_whenBionicArrayMoreThatOneElement_expectedFoundValue() {
        final int[] array1 = {-1, 0, 1, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2};
        final int expectedIndex = 3;

        int actualIndex = underTestSearchEngine.maxBinarySearch(array1);

        assertEquals(expectedIndex, actualIndex);
    }
}
