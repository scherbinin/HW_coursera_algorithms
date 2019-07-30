package week1.unions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuccessorWithDeleteTest {

   @Test
   public void takeSuccessorForDeletedNumber_TheHighestNumbersWasDeleted_DefaultValueReturned(){
      SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(6);
      successorWithDelete.delete(5);
      successorWithDelete.delete(4);

      int actual = successorWithDelete.successor(4);
      int expected = -1;

      assertEquals(actual, expected);
   }

   @Test
   public void takeSuccessorNotDeletedNamber_TheHighestNambersWasDeleted_DefaultValueReturned(){
      SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(6);
      successorWithDelete.delete(5);
      successorWithDelete.delete(4);

      int actual = successorWithDelete.successor(3);
      int expected = 3;

      assertEquals(actual, expected);
   }

   @Test
   public void JustDifferentTests(){
      // TEST 1
      SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(0);
      successorWithDelete.delete(1);
      successorWithDelete.delete(2);
      successorWithDelete.delete(5);

      int actual = successorWithDelete.successor(6);
      int expected = 6;

      assertEquals(actual, expected);

      //TEST 2
      successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(0);
      successorWithDelete.delete(1);
      successorWithDelete.delete(2);
      successorWithDelete.delete(5);

      actual = successorWithDelete.successor(3);
      expected = 3;

      assertEquals(actual, expected);

      //TEST 3
      successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(0);
      successorWithDelete.delete(1);
      successorWithDelete.delete(2);

      actual = successorWithDelete.successor(3);
      expected = 3;

      assertEquals(actual, expected);

      //TEST 4
      successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(0);
      successorWithDelete.delete(1);
      successorWithDelete.delete(2);

      actual = successorWithDelete.successor(6);
      expected = 6;

      assertEquals(actual, expected);

      //TEST 5
      successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(6);
      successorWithDelete.delete(5);
      successorWithDelete.delete(4);

      actual = successorWithDelete.successor(0);
      expected = 0;

      assertEquals(actual, expected);

      //TEST 6
      successorWithDelete = new SuccessorWithDelete(7);

      successorWithDelete.delete(0);
      successorWithDelete.delete(6);
      successorWithDelete.delete(5);
      successorWithDelete.delete(4);

      actual = successorWithDelete.successor(2);
      expected = 2;

      assertEquals(actual, expected);
   }
}
