package week2.queues;

import org.junit.Before;
import org.junit.Test;
import week2.RandomizedQueue;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class RandomizedQueueTest {
   private RandomizedQueue<String> underTestQueue;

   @Before
   public void setup() {
      underTestQueue = new RandomizedQueue<>();
   }

   @Test
   public void testQueue_when5AddedAnd6Extracted_expectedOk() {
      String str1 = "first";
      String str2 = "second";
      String str3 = "third";
      String str4 = "fourth";
      String str5 = "fifth";
      List<String> expected = new ArrayList<String>() {{
         add(str1);
         add(str2);
         add(str3);
         add(str4);
         add(str5);
      }};

      underTestQueue.enqueue(str1);
      underTestQueue.enqueue(str2);
      underTestQueue.enqueue(str3);
      underTestQueue.enqueue(str4);
      underTestQueue.enqueue(str5);

      assertTrue(contains(expected,underTestQueue.dequeue()));
      assertTrue(contains(expected,underTestQueue.dequeue()));
      assertTrue(contains(expected,underTestQueue.dequeue()));
      assertTrue(contains(expected,underTestQueue.dequeue()));
      assertTrue(contains(expected,underTestQueue.dequeue()));

      assertTrue(underTestQueue.isEmpty());
   }

   private boolean contains(List<String> list, String item){
      if(list.contains(item)) {
         list.remove(item);
         return true;
      }

      return false;
   }
}
