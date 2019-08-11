package week3.mergeSort;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by scher on 10.08.2019.
 */
public class PermutationTest {
    @Test
    public void testAscendingSorting() {
        Integer[] actual ={1, 4, 0, 7, 2, 9, 8, 12, 11};

        int permutations = (new Permutations()).sort(actual);

        assertEquals(6, permutations);
    }
}
