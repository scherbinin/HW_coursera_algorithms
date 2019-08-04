package week2.queues;

import org.junit.Before;
import org.junit.Test;
import week2.Queue;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.Assert.assertEquals;

/**
 * Created by scher on 04.08.2019.
 */
public class QueueTest {
    private Queue<Integer> queue;

    @Before
    public void setup() {
        queue = new Queue<>();
    }

    @Test
    public void testQueue() {
        int[] actual = {1, 2, 3, 4, 5, 6, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 1};

        for (int item : actual) {
            queue.push(item);
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i],(int)queue.pop());
        }

        assertEquals(0, queue.size());
    }
}
