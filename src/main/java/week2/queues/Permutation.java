package week2.queues;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int inputAmount = Integer.parseInt(args[0]);

        for (int i = 0; i < inputAmount; i++) {
            String scannedRow = StdIn.readString();
            queue.enqueue(scannedRow);
        }

        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}
