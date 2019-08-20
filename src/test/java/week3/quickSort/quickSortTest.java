package week3.quickSort;

import org.junit.Test;

public class quickSortTest {
    @Test
    public void testPartionWorkability() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {10, 1, 23, 5, 45, 3, 46, 7, 2, 3, -1, 16};

        quickSort.sort(arr);

        for (int item : arr) {
            System.out.print(item + ", ");
        }

    }
}
