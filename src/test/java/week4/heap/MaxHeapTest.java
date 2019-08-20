package week4.heap;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by scher on 20.08.2019.
 */
public class MaxHeapTest {
    private MaxHeap maxHeap;

    @Before
    public void setup() {
        maxHeap = new MaxHeap();
    }

    @Test
    public void test4InsertionAnd4Deletion_ExpectedRightOrderAndEmptyHeap() {
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        int value = maxHeap.delete();
        value = maxHeap.delete();
        value = maxHeap.delete();
        value = maxHeap.delete();

        int size = maxHeap.size();
    }

    @Test
    public void testHeapSort() {
        List<Integer> arr = Arrays.asList(0,10, -1,-4,22,44,5,2,1,-12);
        List<Integer> expectedArr = new ArrayList<>(arr);
        expectedArr.sort(this::descComparator);
        List<Integer> rez = new ArrayList<>();

        for (Integer item : arr)
            maxHeap.insert(item);

        int size = maxHeap.size();

        for (int i = 0; i < size; i++)
           rez.add(maxHeap.delete());

        assertArrayEquals(expectedArr.toArray(),rez.toArray());
    }

    @Test
    public void test6InsertionAnd4RandomDeletion_ExpectedRightOrderAndEmptyHeap() {
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        int value = maxHeap.delRandom();
        value = maxHeap.delRandom();
        value = maxHeap.delRandom();
        value = maxHeap.delRandom();

        int size = maxHeap.size();
    }

    private int descComparator(Integer o1, Integer o2) {
        return Integer.compare(o1,o2) * -1;
    }
}
