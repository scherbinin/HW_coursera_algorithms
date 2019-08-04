package week2.queues;

import org.junit.Before;
import org.junit.Test;
import week2.Deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by scher on 04.08.2019.
 */
public class DequeTest {
    private Deque<String> underTestQueue;

    @Before
    public void setup() {
        underTestQueue = new Deque<>();
    }

    @Test
    public void testLIFO_whenCallOnlyFist_expectedOk() {
        String str1 = "first";
        String str2 = "second";
        String str3 = "third";
        String str4 = "fourth";

        //Push 3
        underTestQueue.addFirst(str1);
        underTestQueue.addFirst(str2);
        underTestQueue.addFirst(str3);

        //Pop 1
        assertEquals(underTestQueue.removeFirst(), str3);

        //Push 1 more
        underTestQueue.addFirst(str4);

        //Pop all
        assertEquals(underTestQueue.removeFirst(), str4);
        assertEquals(underTestQueue.removeFirst(), str2);
        assertEquals(underTestQueue.removeFirst(), str1);

        //Check is empty
        assertTrue(underTestQueue.isEmpty());
        assertEquals(underTestQueue.size(),0);
    }

    @Test
    public void testLIFO_whenCallOnlyLast_expectedOk() {
        String str1 = "first";
        String str2 = "second";
        String str3 = "third";
        String str4 = "fourth";

        //Push 3
        underTestQueue.addLast(str1);
        underTestQueue.addLast(str2);
        underTestQueue.addLast(str3);

        assertEquals(underTestQueue.size(),3);

        //Pop 1
        assertEquals(underTestQueue.removeLast(), str3);

        //Push 1 more
        underTestQueue.addLast(str4);

        //Pop all
        assertEquals(underTestQueue.removeLast(), str4);
        assertEquals(underTestQueue.removeLast(), str2);
        assertEquals(underTestQueue.removeLast(), str1);

        //Check is empty
        assertTrue(underTestQueue.isEmpty());
        assertEquals(underTestQueue.size(),0);
    }

    @Test
    public void testLILO_whenAddFront_expectedOk() {
        String str1 = "first";
        String str2 = "second";
        String str3 = "third";
        String str4 = "fourth";

        //Push 3
        underTestQueue.addFirst(str1);
        underTestQueue.addFirst(str2);
        underTestQueue.addFirst(str3);

        //Pop 1
        assertEquals(underTestQueue.removeLast(), str1);

        //Push 1 more
        underTestQueue.addFirst(str4);

        //Pop all
        assertEquals(underTestQueue.removeLast(), str2);
        assertEquals(underTestQueue.removeLast(), str3);
        assertEquals(underTestQueue.removeLast(), str4);

        //Check is empty
        assertTrue(underTestQueue.isEmpty());
        assertEquals(underTestQueue.size(),0);
    }
}
