package week1.unions;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by scher on 29.07.2019.
 */
public class UnionEngineTest {

    @Test
    public void executeUnion_with2BigTrees_ExpectedOneTree() {
        UnionEngine unionEngine = new UnionEngine(7);

        unionEngine.union(2, 3);
        unionEngine.union(0, 3);
        unionEngine.union(4, 6);
        unionEngine.union(5, 6);
        unionEngine.union(4, 2);

        Map<Integer, LinkedList<Integer>> actualResult = unionEngine.getUnions();
        Map<Integer, List<Integer>> expectedResultResult = getExpectedResult();

        assertTrue(actualResult.size() == 2);

        actualResult.keySet().forEach(root -> assertArrayEquals(actualResult.get(root).toArray(), expectedResultResult.get(root).toArray()));
    }

    @Test
    public void executeFindWithIndex_2UnionsExist_expectedTheBiggestElementFromTheUnion() {
        UnionEngine unionEngine = new UnionEngine(10);

        unionEngine.union(2, 3);
        unionEngine.union(0, 3);
        unionEngine.union(4, 6);
        unionEngine.union(5, 6);
        unionEngine.union(4, 2);
        unionEngine.union(2,9);

        int actual1 = unionEngine.find(0);
        int expected1 = 9;

        int actual2 = unionEngine.find(1);
        int expected2 = 1;

        int actual3 = unionEngine.find(8);
        int expected3 = 8;

        assertEquals(actual1,expected1);
        assertEquals(actual2,expected2);
        assertEquals(actual3,expected3);
    }

    private Map<Integer, List<Integer>> getExpectedResult() {
        Map<Integer, List<Integer>> result = new HashMap<>();
        result.put(1, Arrays.asList(1));
        result.put(4, Arrays.asList(0, 2, 3, 4, 5, 6));

        return result;
    }

}
