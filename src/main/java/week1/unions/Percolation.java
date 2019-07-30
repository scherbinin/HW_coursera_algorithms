package week1.unions;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   private int[][] sites;//TODO: delete it
   private WeightedQuickUnionUF[] unions;
   private final int BLOCKED_SITE = 1;
   private final int OPEN_SITE = 0;
   private final int SIZE;

   // creates n-by-n grid, with all sites initially blocked
   public Percolation(int n) {
      //Что если помечать в обычном массиве, когда вызываются все функции кроме percolates ?
      //А что если одновременно транслировать это в WeightedQuickUnionUF[n*n] ?
      //Как понять что есть путь ?

      SIZE = n;
      sites = new int[n][n];
      unions = new WeightedQuickUnionUF[SIZE];

      for (int i=0; i<SIZE; i++)
         unions[i] = new WeightedQuickUnionUF(SIZE);

      //TODO: Delete all below
      for (int i=0; i < n; i++)
         for (int j=0; j < n; j++)
            sites[i][j] = BLOCKED_SITE;
   }

   // opens the site (row, col) if it is not open already
   public void open(int row, int col) {
//      unions[row-1].
      sites[row][col] = OPEN_SITE;
   }

   // is the site (row, col) open?
   public boolean isOpen(int row, int col) {
      return sites[row][col] == OPEN_SITE;
   }

   // is the site (row, col) full?
   public boolean isFull(int row, int col) {
      //A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites.
      // We say the system percolates if there is a full site in the bottom row.
      // In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row
   }

   // returns the number of open sites
   public int numberOfOpenSites() {

   }

   // does the system percolate?
   public boolean percolates() {

   }

   // test client (optional)
   public static void main(String[] args) {

   }
}
