package week2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by scher on 07.08.2019.
 */
public class PermutationTest {
    @Test
    public void executeAreTheSame_whenTwoArraysHasTheSameElementsInDiffOrde_expectedTrue() {
        Integer[] actual = {2, 7, 1, 0, 3, 4, 6, 5, -9,11};
        Integer[] expected = {2, 7, 4, 0, 3, 1, 6, 5, -9,11};

        assertTrue(new Permutation().areTheSame(actual,expected));
    }
}
