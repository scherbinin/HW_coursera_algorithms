package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int inputAmount = Integer.parseInt(args[0]);

       StdOut.println("The input rows amount: " + inputAmount);

        for (int i = 0; i < inputAmount; i++) {
           String scannedRow = StdIn.readString();

           StdOut.println("The scanned raw: " + scannedRow);
           queue.enqueue(scannedRow);
        }

        StdOut.println("---> The queue size=" + queue.size());

       while(!queue.isEmpty())
          StdOut.println(queue.dequeue());
    }
}
