package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
   public static void main(String[] args) {
      RandomizedQueue<String> queue = new RandomizedQueue<>();
      int inputAmount = Integer.parseInt(args[0]);

      for(int i=0; i<inputAmount; i++) {
         while (!StdIn.isEmpty())
            queue.enqueue(StdIn.readString());
      }

      for (String item : queue) {
         StdOut.println(item);
      }
   }
}
