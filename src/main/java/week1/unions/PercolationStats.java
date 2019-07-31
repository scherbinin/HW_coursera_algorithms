package week1.unions;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

   private final double[] experiments;
   private final int T;

   // perform independent trials on an n-by-n grid
   public PercolationStats(int n, int trials) {
      if (n < 1 || trials < 1)
         throw new IllegalArgumentException();

      experiments = new double[trials];
      T = trials;

      for (int i = 0; i < trials; i++) {
         experiments[i] = experimentConduction(n);
      }

      StdOut.printf("mean\t = %f\n", mean());
      StdOut.printf("stddev\t = %f\n", stddev());
      StdOut.printf("95%c confidence interval\t = [%f, %f]\n", '%', confidenceLo(), confidenceHi());
   }

   // sample mean of percolation threshold
   public double mean() {
      return StdStats.mean(experiments);
   }

   // sample standard deviation of percolation threshold
   public double stddev() {
      return StdStats.stddev(experiments);
   }

   // low endpoint of 95% confidence interval
   public double confidenceLo() {
      return (mean() - 1.96 / Math.sqrt(T));
   }

   // high endpoint of 95% confidence interval
   public double confidenceHi() {
      return (mean() + 1.96 / Math.sqrt(T));
   }

   // test client (see below)
   public static void main(String[] args) {
      if (args.length == 2) {
         int n = Integer.parseInt(args[0]);
         int t = Integer.parseInt(args[1]);

         new PercolationStats(n, t);
      }
   }

   private static double experimentConduction(int n) {
      Percolation percolation = new Percolation(n);
      final int totalSize = n * n;

      do {
         int row = StdRandom.uniform(n) + 1;
         int col = StdRandom.uniform(n) + 1;

         percolation.open(row, col);
      } while (!percolation.percolates());

      return percolation.numberOfOpenSites() / (double) totalSize;
   }
}