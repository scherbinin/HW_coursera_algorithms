package week3.mergeSort;

import org.junit.Test;

/**
 * Created by scher on 10.08.2019.
 */
public class HelperTest {
    @Test
    public void helperTest() {
        int[] arr = {1, 4, 0, 7, 2, 9, 8, 10};

        int a = (new Helper()).permutations(arr);
    }
}
