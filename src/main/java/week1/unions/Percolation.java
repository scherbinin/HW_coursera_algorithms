package week1.unions;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

   private WeightedQuickUnionUF unionEngine;
   private char[] sites;
   private final int N;
   private final int TOP_SITE = 0;
   private final int BOTTOM_SITE = 1;
   private final char BLOCKED_SITE = '0';
   private int numberOfOpenSites = 0;

   // creates n-by-n grid, with all sites initially blocked
   public Percolation(int n) {
      N = n;
      int size = n * n;

      //Zero index - is a virtual sites for top row
      //SIZE+1 index - is virtual sites for bottom row
      unionEngine = new WeightedQuickUnionUF(size + 2);
      sites = new char[size + 2];
      sites[TOP_SITE] = TOP_SITE;
      sites[BOTTOM_SITE] = BOTTOM_SITE;

      for (int i = 2; i < size + 2; i++)
         sites[i] = BLOCKED_SITE;
   }

   // opens the sites (row, col) if it is not open already
   public void open(int row, int col) {
      validateBoundaries(row, col);

      if (isOpen(row, col))
         return;

      sites[getIndexFlatArray(row, col)] = '*';
      numberOfOpenSites++;

      if (row == 1) {
         unionEngine.union(getIndexFlatArray(row, col), TOP_SITE);
      }

      if (row == N) {
         unionEngine.union(BOTTOM_SITE, getIndexFlatArray(row, col));
      }

      //percolate it to all of its adjacent open sites.
      percolate(row - 1, col, row, col);
      percolate(row + 1, col, row, col);
      percolate(row, col - 1, row, col);
      percolate(row, col + 1, row, col);
   }

   // is the sites (row, col) open?
   public boolean isOpen(int row, int col) {
      validateBoundaries(row, col);

      return sites[getIndexFlatArray(row, col)] != BLOCKED_SITE;
   }

   // is the sites (row, col) full?
   public boolean isFull(int row, int col) {
      //A full sites is an open sites that can be connected to an open sites in the top row
      validateBoundaries(row, col);

      return unionEngine.connected(getIndexFlatArray(row, col), TOP_SITE);
   }

   // returns the number of open sites
   public int numberOfOpenSites() {
      return numberOfOpenSites;
   }

   // does the system percolate?
   public boolean percolates() {
      return unionEngine.connected(TOP_SITE, BOTTOM_SITE);
   }

   private void percolate(int row, int col, int actualRow, int actualCol) {
      if (inBoundaries(row, col) && isOpen(row, col)) {
         unionEngine.union(getIndexFlatArray(row, col), getIndexFlatArray(actualRow, actualCol));
      }
   }

   private int getIndexFlatArray(int row, int column) {
      return N * (row - 1) + column + 1;
   }

   private void validateBoundaries(int row, int col) {
      if (!inBoundaries(row, col))
         throw new IllegalArgumentException();
   }

   private boolean inBoundaries(int row, int col) {
      if (row < 1 || row > N || col < 1 || col > N)
         return false;

      return true;
   }

   //Simple visualization for debug
   private void print() {
      for (int i = 0; i < N * N; i++) {
         if (i % N == 0) {
            StdOut.print("\n");
         }
         StdOut.print(sites[i + 2] + " ");
      }
      StdOut.print("\n\n");
   }

   // test client (optional)
   public static void main(String[] args) {

   }
}
